package com.sujung.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//out.println의 데이터를 한글로 출력하기 위해 사용
		response.setCharacterEncoding("UTF-8");
		
		//브라우저마다 문자코드를 해석하는 default가 다르므로 형식과 charset 지정
		response.setContentType("text/html; charset=UTF-8");
		
		//POST방식으로 보내는 값이 '한글'일 경우 깨지지 않게 전달하기 위해 사용
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		out.println(title);
		out.println(content);
	}
}
