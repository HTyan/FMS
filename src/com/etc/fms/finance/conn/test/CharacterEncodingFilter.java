package com.etc.fms.finance.conn.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 这个过滤器负责将编码统一，本项目中统一为utf-8
 * **/
public class CharacterEncodingFilter implements Filter {
	// 字符编码
	String encoding = null;

	public void destroy() {
		// TODO Auto-generated method stub
		encoding = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 判断字符编码是否为空
		if (encoding != null) {
			// 设置request编码格式
			request.setCharacterEncoding(encoding);
			// 设置response编码格式
			// response.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset=" + encoding);
		}
		chain.doFilter(request, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}
}
