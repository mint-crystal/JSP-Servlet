package com.sujung.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//어노테이션을 이용해 필터 설정
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8"); //모든 파일이 실행되기 전에 인코딩을 수행함
		
		//다음 실행을 관할
		chain.doFilter(request,response);
		
		//System.out.println("after filter");
	}

}
