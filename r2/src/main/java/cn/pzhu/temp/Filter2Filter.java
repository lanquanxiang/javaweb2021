package cn.pzhu.temp;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Filter1Filter
 */

public class Filter2Filter extends HttpFilter  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("Filter2-1");
		super.doFilter(request, response, chain);
		//System.out.println("Filter2-2");
	}
	
	
  

}
