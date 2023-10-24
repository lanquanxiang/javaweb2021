package cn.pzhu.temp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
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
		
		String keyword = request.getParameter("keyword");
		
		Connection con = null;
		//Statement sta = null;
		PreparedStatement sta = null;
		ResultSet res = null;		
		try {			
			con = JDBCUtil.getConnection();
			// 'or'1'='1
			String sql = "SELECT * FROM filemsg WHERE filename LIKE ?";
			//sta = con.createStatement();
			sta = con.prepareStatement(sql);
			sta.setString(1, "%"+keyword+"%"); //为第一个问号赋值一个字符串
			
			res = sta.executeQuery();//不需要参数，如果使用了参数，会认为在调用父类Statement的方法
			List<FileMsg> list = new ArrayList<>();
			while(res.next()) {
				FileMsg filemsg = new FileMsg(
						res.getInt(1), 
						res.getString(2), 
						res.getString(3), 
						res.getString(4), 
						res.getString("filepath"), 
						res.getDate(6), 
						res.getDouble("rating"), 
						res.getString(8));
				list.add(filemsg);
			}
			request.getSession().setAttribute("list", list);
			response.sendRedirect("show.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, sta ,res);
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
