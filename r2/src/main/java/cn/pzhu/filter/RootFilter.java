package cn.pzhu.filter;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Filter1Filter
 */
@WebFilter(urlPatterns = {"/userinfo.jsp"})
public class RootFilter extends HttpFilter  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {		
		
		if(request.getSession().getAttribute("user")==null) {
			//response.sendRedirect("login.jsp");
			response.setContentType("text/html");
			response.getWriter().print("<script>alert('你还没有登录，请先登录...');window.location.href='login.jsp';</script>");
		}else {
			super.doFilter(request, response, chain);
		}
	}
	
	
  

}
