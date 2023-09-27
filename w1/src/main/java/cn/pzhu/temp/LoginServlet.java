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
		//1. 处理编码  2'
		request.setCharacterEncoding("utf-8");
		//2. 接收参数 4'
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//3. 数据验证 4'
		if(username==null || password ==null) {
			//9.保存错误信息，重定向到错误页面
			request.getSession().setAttribute("msg", "前端数据接收异常");
			response.sendRedirect("error.jsp");return; //2'			
		}
		if(username.equals("")) {
			request.getSession().setAttribute("msg", "用户名不能为空");
			response.sendRedirect("error.jsp");return;
		}
		if(password.equals("")) {
			request.getSession().setAttribute("msg", "密码不能为空");
			response.sendRedirect("error.jsp");return;
		}
		//4. 数据封装（接收的信息较多）
		User user = new User(username,password,null);
		//5. 初始化模型层，调用方法（业务层处理）
		//6. 根据业务层处理结果，执行不同的操作
		if(!password.equals("123456")) {
			request.getSession().setAttribute("msg", "密码错误");
			response.sendRedirect("error.jsp");
			return;
		}
		//7. 保存用户信息 2'
		request.getSession().setAttribute("user", user);
		//8. 符合预期，转到正确的页面 2'
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
