package cn.pzhu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.pzhuweb.filesys.util.FileUtil;
import cn.pzhuweb.filesys.util.Result;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part file = request.getPart("file");
		FileUtil.setPath("C:/Alan/upload/");
		Result res =  FileUtil.uploadFile(file);
		if (res.isSuccess()) {
			response.setContentType("text/html");
			response.getWriter().print("<script>alert('上传成功，文件被命名为"+res.getData()+"');location.href='upload.jsp';</script>");
		}else {
			response.setContentType("text/html");
			response.getWriter().print("<script>alert('上传失败，失败的原因'"+res.getMsg()+");location.href='upload.jsp';</script>");
		}
		//需要将上传的文件信息存储到数据库中
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
