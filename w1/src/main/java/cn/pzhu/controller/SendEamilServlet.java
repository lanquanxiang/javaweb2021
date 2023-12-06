package cn.pzhu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.pojo.Result;
import cn.pzhu.service.UserService;
import cn.pzhu.service.imp.UserServiceImp;
import cn.pzhu.util.Conver2MD5;

/**
 * Servlet implementation class SendEamilServlet
 */
@WebServlet("/sendemail")
public class SendEamilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService us = new UserServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEamilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		Result res = us.sendEmail(username, email);
		response.setContentType("text/html");
		if(res.isSuccess()) {
			//保存code，提供给登录去校验用户输入的code
			String code = res.getMsg(); //如果成功，msg里面存储的就是验证码
			String token = Conver2MD5.getSHA256(Conver2MD5.getSHA256(username)+
					Conver2MD5.getSHA256(email)+Conver2MD5.getSHA256(code));
			request.getSession().setAttribute("token", token);
			response.getWriter().print("验证码已发送!");
		}else {
			//提示错误信息
			response.getWriter().print(res.getMsg());
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
