package cn.pzhu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.pojo.Message;
import cn.pzhu.pojo.User;
import cn.pzhu.service.UserService;
import cn.pzhu.service.imp.UserServiveImp;
import cn.pzhu.util.Conver2MD5;

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
		
		String path = request.getContextPath();
		//1. 接受参数
		String username  = request.getParameter("username");
		String password  = request.getParameter("password");
		
		String isSave = request.getParameter("isSave");//接收是否要保存密码的标志位
		
		
		//按照相同的规则处理密码，然后再与数据库比对
		String secpassword =  Conver2MD5.getSHA256(Conver2MD5.getSHA256(username)+Conver2MD5.getSHA256(password));//混入用户名的加盐操作
		//2. 数据封装
		User user = new User(username,secpassword,null);//null表示账号的状态，和用户无关，状态需要数据库查询
		//3. 调用业务层实现业务处理
		UserService us = new UserServiveImp();//只能使用实现类来初始化接口
		Message msg = us.login(user);
		//4. 处理结果
		if(msg.isSuccess()) {
			//如果成功才将密码写入cookie
			if("yes".equals(isSave)) {
				Cookie usernamecookie = new Cookie("username",username);
				usernamecookie.setMaxAge(60*60*24*7);//保存7天
				response.addCookie(usernamecookie);
				
				Cookie passwordcookie = new Cookie("password",password);
				passwordcookie.setMaxAge(60*60*24*7);//保存7天
				response.addCookie(passwordcookie);
				
				Cookie savecookie = new Cookie("save","yes");
				savecookie.setMaxAge(60*60*24*7);//保存7天
				response.addCookie(savecookie);
			}else {
				Cookie usernamecookie = new Cookie("username",username);
				usernamecookie.setMaxAge(0);//销毁cookie
				response.addCookie(usernamecookie);
				
				Cookie passwordcookie = new Cookie("password",password);
				passwordcookie.setMaxAge(0);//销毁cookie
				response.addCookie(passwordcookie);
				
				Cookie savecookie = new Cookie("save","yes");
				savecookie.setMaxAge(0);//销毁cookie
				response.addCookie(savecookie);
			}			
			request.getSession().setAttribute("user", user); 
			response.sendRedirect("index.jsp");
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
