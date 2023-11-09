package cn.pzhu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.pzhu.pojo.Result;
import cn.pzhu.pojo.User;
import cn.pzhu.pojo.UserInfo;
import cn.pzhu.service.UserService;
import cn.pzhu.service.imp.UserServiceImp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//初始化业务层接口
	private UserService us = new UserServiceImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getContextPath(); //${pageContext.request.ContextPath}  /w2
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		String email = request.getParameter("email");
		String sgender = request.getParameter("gender");
		String [] types = request.getParameterValues("type");
		String code = request.getParameter("code");
		
		String ans = (String)request.getSession().getAttribute("ans");
		if (!ans.equalsIgnoreCase(code)) {
			request.getSession().setAttribute("msg", "验证码错误");
			response.sendRedirect("error.jsp");
			return;
		}
		User user = new User(username, password,1);
		int gender = 1;
		try {
			gender = Integer.parseInt(sgender);
			if(gender!=0 && gender!=1) {
				throw new Exception();
			}
			
		} catch (Exception e) {
			request.getSession().setAttribute("msg", "性别数据异常");
			response.sendRedirect("error.jsp");
			return;
			
		}
		String type = JSON.toJSONString(types);
		UserInfo userinfo = new UserInfo(username, email, gender, type);
    	Result res = us.regist(user,userinfo);//调用业务层接口的方法
		if(!res.isSuccess()) {
			request.getSession().setAttribute("msg", res.getMsg());
			response.sendRedirect(path+"/error.jsp");
			return;
		}	
		response.setContentType("text/html");
		response.getWriter().print("<script>alert('注册成功，请登录...');location.href='login.jsp';</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
