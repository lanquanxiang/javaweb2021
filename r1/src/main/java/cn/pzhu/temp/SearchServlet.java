package cn.pzhu.temp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pzhu.pojo.FileMsg;
import cn.pzhu.util.JDBCUtil;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword = request.getParameter("keyword"); //假设这个是分享者的名字
		
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			//2.建立连接				
			 con = JDBCUtil.getConnetion();
			
			//3.编写SQL语句
			String sql = "SELECT * FROM filemsg where filename like ?";
			//4.创建命令对象
			 //sta = con.createStatement();
			sta = con.prepareStatement(sql);
			sta.setString(1, "%"+ keyword+"%");
			//5.查询
			// res = sta.executeQuery(sql); //只有statement才需要SQL
			 res = sta.executeQuery();//执行的时候不需要SQL
			//6.处理结果
			List<FileMsg> list = new ArrayList<>();
			while(res.next()) {
				int fileid = res.getInt(1);
				String username = res.getString(2);
				String filename = res.getString(3);
				String classification = res.getString(4);
				String filepath = res.getString(5);
				Date releasedate = res.getDate(6);
				Double rating = res.getDouble(7);
				String description = res.getString(8);
				FileMsg filemsg = new FileMsg(fileid, username, filename, classification, filepath, releasedate, rating, description);
				list.add(filemsg);			
			}			
			//list.stream().map(FileMsg::getFilename).forEach(System.out::println); //输出所有的文件名	
			/*
			//7. 释放资源
			res.close();
			sta.close();
			con.close();
			*/
			request.getSession().setAttribute("list", list);
			response.sendRedirect("show.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7. 释放资源
			JDBCUtil.close(con, sta, res);
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
