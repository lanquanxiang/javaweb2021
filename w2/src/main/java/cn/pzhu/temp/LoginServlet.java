package cn.pzhu.temp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 处理编码 //2'
		request.setCharacterEncoding("utf-8");
		
		String path = request.getContextPath(); //${pageContext.request.ContextPath}
		
		//2. 接收参数 //4'
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//3. 进行数据验证 //4'
		if(username==null || password ==null) {
			request.getSession().setAttribute("msg", "数据接收异常");
			//9. 不符合预期，重定向到错误页面
			response.sendRedirect(path+"/error.jsp");
			return;
		}
		if(username.equals("")) {
			request.getSession().setAttribute("msg", "用户名不能为空");
			//9. 不符合预期，重定向到错误页面
			response.sendRedirect("error.jsp");
			return;
		}
		if(password.equals("")) {
			request.getSession().setAttribute("msg", "密码不能为空");
			//9. 不符合预期，重定向到错误页面
			response.sendRedirect("error.jsp");
			return;
		}
		//4. 封装数据
		User user = new User(username, password, null);
		//5. 初始化模型（业务层）
		//6. 接收业务层结果  2'
		if(!password.equals("123456")) {
			request.getSession().setAttribute("msg", "密码错误");
			//9. 不符合预期，重定向到错误页面
			response.sendRedirect("error.jsp");
			return;
		}
		//7. 保存数据 2'
		request.getSession().setAttribute("user", user);
		//8. 跳转到正确页面 2'
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
