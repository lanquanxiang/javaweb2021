package cn.pzhu.temp;

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
		Part file =  request.getPart("file");
		Result res =  FileUtil.uploadFile(file);
		response.setContentType("text/html");
		if(res.isSuccess()) {
			System.out.println("你上传的文件已经保存到：d:/upload/"+ res.getData());
			response.getWriter().append("<script>alert('上传成功');window.location.href='temp/upload.jsp';</script>");
		}else {
			response.getWriter().append("<script>alert('"+res.getMsg()+"');window.location.href='temp/upload.jsp';</script>");
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
