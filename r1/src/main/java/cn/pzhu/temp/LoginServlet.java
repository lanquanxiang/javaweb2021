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
		//1. 处理编码
		request.setCharacterEncoding("utf-8");
		String path = request.getContextPath();
		//2. 接收视图层传递的参数
		String username  = request.getParameter("username");
		String password  = request.getParameter("password");
		//3. 进行必要的数据验证和类型转换，若验证失败跳转到步骤9
		if(username==null || password==null) { //表单控件没有名字，名字写错了
			request.getSession().setAttribute("msg", "控制器没有获得正确的数据");
			response.sendRedirect(path+"/error.jsp");
			return;
		}
		if("".equals(username)||"".equals(password)) {
			request.getSession().setAttribute("msg", "用户名或密码不能为空");
			response.sendRedirect(path+"/error.jsp");
			return;
		}
		//4. 进行数据封装
		User user = new User(username,password,1);
		
		//5. 初始化模型，来处理数据
		//6. 保存处理结果		
		if(!"123456".equals(password)) {
			request.getSession().setAttribute("msg", "密码输入错误");
			//9. 不符合预期
			response.sendRedirect(path+"/error.jsp");
			return;
		}
		// 7. 对必要的信息或者是标识进行保存
		request.getSession().setAttribute("user", user); //保存的是user，user里面包含了用户名和密码
		//8. 如果处理完毕，定向到正确页面
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
