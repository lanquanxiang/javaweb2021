package cn.pzhu.servlet;

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
import cn.pzhu.util.PageUtil;

/**
 * Servlet implementation class ShowFileMsgServlet
 */
@WebServlet("/show")
public class ShowFileMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FileMsgService fs = new FileMsgServiceImp();//初始化文件操作的业务接口
       
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
		List<FileMsg> list = fs.showFileMsg();//查询了所有信息
		
		String spage = request.getParameter("page");
		String snum= request.getParameter("num");
		int page = 1;
		try {
			page = Integer.valueOf(spage);
		} catch (Exception e) {
			page = 1; //如果类型转换失败，默认显示第1页
		}
		int num = 10;
		try {
			num = Integer.valueOf(snum);
		} catch (Exception e) {
			num = 10; //如果类型转换失败，默认每页显示10条
		}
		
		List<FileMsg> newlist = PageUtil.getPageData(list, page, num);//将list进行分割,变成newlist
		
		
		request.getSession().setAttribute("list", newlist);
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
