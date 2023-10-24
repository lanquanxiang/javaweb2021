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
@WebServlet("/login.old")
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
		//[第三题：程序设计 考试复习]
		
		//1. 处理编码(已经在过滤器中被处理)
		//request.setCharacterEncoding("utf-8"); //2'
		
		String path = request.getContextPath();  //${pageContext.request.contextPath}
		
		//2. 接收参数 //2'
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//3. 进行类型转换或者是数据验证 
		if(username==null || password ==null) {//2'
			request.getSession().setAttribute("msg", "前端数据异常!");//2'
			response.sendRedirect(path+"/error.jsp");
			return;
		}
		if("".equals(username)||"".equals(password)) {//2'
			request.getSession().setAttribute("msg", "用户名或密码为空!");//2'
			response.sendRedirect("error.jsp");
			return;
		}
		//4. 进行数据封装
		User user = new User(username, password, 1);
		//5. 调用工具JavaBean
		//6. 进行数据处理
		if(!"123456".equals(password)) {//2'
			//9. 不符合预期
			request.getSession().setAttribute("msg", "密码错误!");//2'
			response.sendRedirect("error.jsp");
			return;
		}
		//7. 保存必要的信息（保存用户名用于主页面显示）
		request.getSession().setAttribute("user", user);//2'
		//8. 跳转到主页
		response.sendRedirect("index.jsp");//2'
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
