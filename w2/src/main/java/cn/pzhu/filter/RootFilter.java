package cn.pzhu.filter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class F1Filter
 */
@WebFilter("/userinfo.jsp")
public class RootFilter extends HttpFilter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		if(req.getSession().getAttribute("user")==null) {
			//res.sendRedirect("login.jsp");
			res.setContentType("text/html");
			res.getWriter().print("<script>alert('你还没有登录，请先登录...');location.href='login.jsp';</script>");
		}else {
			super.doFilter(req, res, chain);
		}
	}
	
	

}
