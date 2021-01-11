package com.sujung.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션 맵핑
@WebServlet("/hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답시 한글 출력
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//출력 스트림 생성
		PrintWriter out = response.getWriter();
		
		//HTTP 요청의 파라미터 값을 얻기 위해 사용
		String temp = request.getParameter("cnt");
		
		int cnt = 100;
		
		if(temp!=null && !temp.equals(""))
			cnt = Integer.parseInt(temp); //파라미터는 문자열을 가져오기때문에 int형태로 변환
		
		for(int i=0; i<cnt; i++) {
			out.println((i+1)+": 안녕 Servlet!!<br>");
		}
	}
}
