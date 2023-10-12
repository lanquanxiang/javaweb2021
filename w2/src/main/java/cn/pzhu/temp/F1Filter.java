package cn.pzhu.temp;


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
@WebFilter("/*")
public class F1Filter extends HttpFilter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//System.out.println("F1-request");
		super.doFilter(req, res, chain);
		//System.out.println("F1-response");
	}
	
	

}
