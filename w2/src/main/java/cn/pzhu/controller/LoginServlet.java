package cn.pzhu.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.pojo.Result;
import cn.pzhu.pojo.User;
import cn.pzhu.service.UserService;
import cn.pzhu.service.imp.UserServiceImp;
import cn.pzhu.util.Conver2MD5;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//初始化业务层接口
	private UserService us = new UserServiceImp();
       
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
		String path = request.getContextPath(); //${pageContext.request.ContextPath}
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		
		String sec_password =Conver2MD5.getSHA256(Conver2MD5.getSHA256("pzhu")+Conver2MD5.getSHA256(username)+Conver2MD5.getSHA256(password));	
		
		User user = new User(username, sec_password, null);
		Result res = us.login(user);//调用业务层接口的方法
		if(!res.isSuccess()) {
			request.getSession().setAttribute("msg", res.getMsg());
			response.sendRedirect("error.jsp");
			return;
		}
		
		String save = request.getParameter("save");
		if(save!=null && "1".equals(save)) {
			//存cookie
			Cookie usernamecookie = new Cookie("username", URLEncoder.encode(username,"UTF-8"));
			usernamecookie.setMaxAge(7*24*60*60);
			response.addCookie(usernamecookie);
			
			Cookie passwordcookie = new Cookie("password", URLEncoder.encode(password,"UTF-8"));
			passwordcookie.setMaxAge(7*24*60*60);
			response.addCookie(passwordcookie);
			
			Cookie savecookie = new Cookie("save", "1");
			savecookie.setMaxAge(7*24*60*60);
			response.addCookie(savecookie);
		}else {
			//清理cookie
			Cookie usernamecookie = new Cookie("username", URLEncoder.encode(username,"UTF-8"));
			usernamecookie.setMaxAge(0);
			response.addCookie(usernamecookie);
			
			Cookie passwordcookie = new Cookie("password", URLEncoder.encode(password,"UTF-8"));
			passwordcookie.setMaxAge(0);
			response.addCookie(passwordcookie);
			
			Cookie savecookie = new Cookie("save","");
			savecookie.setMaxAge(0);
			response.addCookie(savecookie);
		}
		
		request.getSession().setAttribute("user", user);		
		response.sendRedirect(path+"/index.jsp");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
