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
@WebFilter("/*")
public class EncodingFilter extends HttpFilter  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//System.out.println("编码过滤器正在处理编码...");
		super.doFilter(request, response, chain);
	}
	
	
  

}
