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
import cn.pzhu.service.imp.FileMsgServiceImp;

/**
 * Servlet implementation class ShowFileMsgServlet
 */
@WebServlet("/show")
public class ShowFileMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FileMsgService fs = new FileMsgServiceImp();
       
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
		String spage = request.getParameter("page");
		String snum = request.getParameter("num");
		int page = 1,num = 10;
		try {
			page = Integer.valueOf(spage); //将前端的数据进行强制类型转换
		} catch (Exception e) {
			page = 1; //如果转换失败，设置为默认值
		}
		try {
			num = Integer.valueOf(snum); //将前端的数据进行强制类型转换
		} catch (Exception e) {
			num = 10; //如果转换失败，设置为默认值
		}
		List<FileMsg> list = fs.showFileMsgByPage(page, num);
		
		StringBuffer bar=fs.createBar(page, num);
		request.getSession().setAttribute("bar", bar);
		request.getSession().setAttribute("num", num);
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
