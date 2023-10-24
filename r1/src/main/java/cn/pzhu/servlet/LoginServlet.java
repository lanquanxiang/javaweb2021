package cn.pzhu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.pojo.Message;
import cn.pzhu.pojo.User;
import cn.pzhu.service.UserService;
import cn.pzhu.service.imp.UserServiveImp;

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
		//2. 数据封装
		User user = new User(username,password,null);//null表示账号的状态，和用户无关，状态需要数据库查询
		//3. 调用业务层实现业务处理
		UserService us = new UserServiveImp();//只能使用实现类来初始化接口
		Message msg = us.login(user);
		//4. 处理结果
		if(msg.isSuccess()) {
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
