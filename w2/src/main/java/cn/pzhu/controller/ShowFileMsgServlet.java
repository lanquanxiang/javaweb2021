package cn.pzhu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.pojo.FileMsg;
import cn.pzhu.service.FileMsgService;
import cn.pzhu.service.imp.FileMsgServieImp;

/**
 * Servlet implementation class ShowFileMsgServlet
 */
@WebServlet("/show")
public class ShowFileMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FileMsgService fs = new FileMsgServieImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFileMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FileMsg> list = fs.showFileMsg();
		request.getSession().setAttribute("list", list);
		response.sendRedirect("show.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
