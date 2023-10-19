package cn.pzhu.temp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		//1.加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//2. 获得连接
		String url = "jdbc:mysql://127.0.0.1:3308/filesys?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
		String user="root";
		String password="123456";	
		*/	
		Connection con = null;
		Statement sta = null;
		ResultSet res= null;
		try {
			//Connection con = DriverManager.getConnection(url, user, password);
			con = JDBCUtil.getConnection();
			System.out.println(con);
			//3.编写SQL语句：查询所有的文件信息
			String sql = "select * from filemsg";
			//4.创建命令对象
			sta = con.createStatement();
			//5.执行SQL
			res = sta.executeQuery(sql);
			//6.处理结果
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
			//7. 释放资源
			/*
			res.close();
			sta.close();
			con.close();
			*/
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
