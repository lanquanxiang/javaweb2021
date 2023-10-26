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
		ResultSet res= null;
		try {			
			con = JDBCUtil.getConnection();
			//String sql = "select * from filemsg where username='"+keyword+"'";
			String sql = "select * from filemsg where filename like ?";
			//sta = con.createStatement();
			sta = con.prepareStatement(sql);//创建预编译的命令对象
			sta.setString(1, "%"+keyword+"%");//为问号赋值
			
			//res = sta.executeQuery(sql);
			res = sta.executeQuery();//预编译命令在执行的时候不需要SQL
			List<FileMsg> list = new ArrayList<FileMsg>();
			while(res.next()) {
				FileMsg file = new FileMsg(res.getInt(1), res.getString(2), 
						res.getString(3), res.getString(4), res.getString(5), 
						res.getDate(6), res.getDouble(7), res.getString(8));
				list.add(file);
			}
			request.getSession().setAttribute("list", list);
			response.sendRedirect("show.jsp");			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			
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
