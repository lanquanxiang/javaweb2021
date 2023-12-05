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
		Part file = request.getPart("file"); //用于接收非文本
		Result res =  FileUtil.uploadFile(file);
		response.setContentType("text/html");
		if(res.isSuccess()) {
			response.getWriter().print("上传成功！你的文件已经保存在："+res.getData());
		}else {
			response.getWriter().print("上传失败，失败的原因是："+res.getMsg());
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
