package com.wrh.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 
 * 管理过滤器
 * 
 * @author 李彦学
 * 
 */
public class ManageFilter implements Filter {

	public void destroy() {
		// TODO 自动生成的方法存根

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getServletPath();
		System.out.println(url);
				String path = request.getContextPath();
				String basePath = request.getScheme() + "://"
						+ request.getServerName() + ":"
						+ request.getServerPort() + path;
				System.out.println(basePath + "/");
				if (1==1) {
					chain.doFilter(request, response);
				}else {
					response.sendRedirect(basePath + "/hello");
				}	
			}

		// chain.doFilter(request, response);

	public void init(FilterConfig arg0) throws ServletException {
		// TODO 自动生成的方法存根

	}

}
