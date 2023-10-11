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
@WebFilter("/note/*")
public class AccessFilter extends HttpFilter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//允许跨域请求
		res.setHeader("Access-Control-Allow-Origin", "*");
		super.doFilter(req, res, chain);
		
		
		
	}

	

}
