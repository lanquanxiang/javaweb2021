package cn.pzhu.temp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//1. 处理编码
		request.setCharacterEncoding("utf-8");
		//2. 接收视图层传递的参数
		String username  = request.getParameter("username");
		String password  = request.getParameter("password");
		//3. 进行必要的数据验证和类型转换，若验证失败跳转到步骤9
		if("".equals(username)||"".equals(password)) {
			response.sendRedirect("login.jsp");
			return;
		}
		if(!"123456".equals(password)) {
			response.sendRedirect("login.jsp");
			return;
		}
		// 4. 对必要的信息或者是标识进行保存
		request.getSession().setAttribute("username", username);
		response.sendRedirect("index.jsp");
		
		/*
		 * 

对数据进行封装
初始化模型层对象，并调用模型层方法
初始化结果变量保存模型层方法处理结果

根据处理结果，如果符合预期，请求转发或者重定向到正确页面
如果不符合预期，请求转发或者重定向到错误页面
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
