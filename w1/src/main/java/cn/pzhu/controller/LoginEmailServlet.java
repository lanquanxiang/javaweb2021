package cn.pzhu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.pojo.User;
import cn.pzhu.util.Conver2MD5;

/**
 * Servlet implementation class LoginEmailServlet
 */
@WebServlet("/loginemail")
public class LoginEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		//进行校验
		if(username==null || "".equals(username) || email==null || 
				"".equals(email) || code==null || "".equals(code)) {
			request.getSession().setAttribute("msg","登录信息不完整");
			response.sendRedirect("error.jsp");
			return;
		}
		Object obj = request.getSession().getAttribute("token");
		if(obj==null) {
			request.getSession().setAttribute("msg","还没有发送验证码");
			response.sendRedirect("error.jsp");
			return;
		}
		//用户发送邮件之后，正确的token
		String token = (String)obj;
		//用户登录时输入的信息，按照相同规则，生成的token
		String usertoken = Conver2MD5.getSHA256(Conver2MD5.getSHA256(username)+
				Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(code));
		if(token.equals(usertoken)) {
			request.getSession().setAttribute("user", new User(username, usertoken, 1));
			response.sendRedirect("index.jsp");
		}else {
			request.getSession().setAttribute("msg","验证码输入错误");
			response.sendRedirect("error.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
