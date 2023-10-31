package cn.pzhu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.pzhu.pojo.Message;
import cn.pzhu.pojo.User;
import cn.pzhu.pojo.UserInfo;
import cn.pzhu.service.UserService;
import cn.pzhu.service.imp.UserServiveImp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		String path = request.getContextPath();
		//1. 接受参数
		String username  = request.getParameter("username");
		String password  = request.getParameter("password");
		String email=request.getParameter("email");
		String sgender=request.getParameter("gender");
		String [] types=request.getParameterValues("type");
		String code=request.getParameter("code");
		if(!"gbcw".equalsIgnoreCase(code)) {
			request.getSession().setAttribute("msg", "验证码输入错误");
			response.sendRedirect(path+"/error.jsp");
			return;
		}
		//2. 数据封装
		User user = new User(username,password,1);//注册账号默认为1
		int gender=0;
		try {
			gender=Integer.valueOf(sgender);
			if(gender!=1&&gender!=0) {
				throw new Exception();
			}
		} catch (Exception e) {
			request.getSession().setAttribute("msg", "性别数据异常");
			response.sendRedirect(path+"/error.jsp");
			return;
		}
		UserInfo userinfo=new UserInfo(username,email,gender,JSON.toJSONString(types));
		//3. 调用业务层实现业务处理
		UserService us = new UserServiveImp();//只能使用实现类来初始化接口
		Message msg = us.regist(user,userinfo);
		//4. 处理结果
		if(msg.isSuccess()) {
			response.setContentType("text/html");
			response.getWriter().append("<script>alert('注册成功！');window.location.href='login.jsp';</script>");
		}else {
			request.getSession().setAttribute("msg", msg.getMsg());
			response.sendRedirect(path+"/error.jsp");
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
