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
		
		String keyword = request.getParameter("keyword"); //接收用户输入的关键词
		
		Connection con = null;
		//Statement sta = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			con = JDBCUtil.getConnection();
			//3. 编写SQL语句
			String sql = "SELECT * FROM filemsg where username=?"; //查询filemsg表的所有信息
			//4. 创建命令对象
			//sta = con.createStatement();
			sta = con.prepareStatement(sql);
			//5. 执行SQL语句
			sta.setString(1, keyword);//为问号赋值
			//res = sta.executeQuery(sql);
			res = sta.executeQuery();
			//6. 处理结果
			List<FileMsg> list = new ArrayList<FileMsg>();
			while(res.next()) {
				FileMsg filemsg = new FileMsg(res.getInt(1), res.getString(2), 
						res.getString(3), res.getString(4), res.getString(5),
						res.getDate(6), res.getDouble(7), res.getString(8));
				list.add(filemsg);
			}			
			//保存所有的文件信息到session域，然后回到视图show.jsp
			request.getSession().setAttribute("list", list);
			response.sendRedirect("show.jsp");			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//7. 释放资源
			/*res.close();sta.close();con.close();*/
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
