package cn.pzhu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.service.UserService;
import cn.pzhu.service.imp.UserServiveImp;

/**
 * Servlet implementation class CheckUsernameServlet
 */
@WebServlet("/checkusername")
public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us =new UserServiveImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsernameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		if (username == null||username.equals("")) 
		{
			return;
		}
		if (us.isExist(username))
		{
			response.getWriter().append("此用户已存在");
		}else {
			response.getWriter().append("此账号可用");
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
