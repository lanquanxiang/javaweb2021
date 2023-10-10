package cn.pzhu.filter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(urlPatterns = {"/userinfo.jsp"})
public class RootFilter extends HttpFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		if(req.getSession().getAttribute("user")==null) {
			res.setContentType("text/html");
			res.getWriter().append("<script>alert('请先登录之后在操作...');window.location.href='login.jsp';</script>");
			//res.sendRedirect("login.jsp");
		}else {
			super.doFilter(req, res, chain);
		}
	}
}
