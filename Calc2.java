package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값을 저장할 ServletContest 객체 선언
		ServletContext application = request.getServletContext();
		
		//인코딩 처리
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//입력 값 가져오기
		String v_ = request.getParameter("v");
		String op = request.getParameter("operator");
		
		int v = 0;	//사용자가 값을 입력하지 않았을 때 0으로 처리하기 위함
		if(!v_.equals("")) v = Integer.parseInt(v_); //문자열로 받은 숫자를 int형으로 치환
		
		if(op.equals("=")) {
			//값을 계산
			int x = (Integer)application.getAttribute("value"); //저장된 값 호출해서 담음
					//Object로 값을 반환하기 때문에 int형 변환 필요
			int y = v;
			String operator = (String)application.getAttribute("op"); //저장된 연산자 호출해서 담음
			
			int result = 0;		
			if(operator.equals("+")) {
				result = x+y;
			} else {
				result = x-y;
			}	
			response.getWriter().printf("result is %d\n", result);
		} else {
			//+, - 연산자를 클릭하면 값을 저장
			application.setAttribute("value",v);  //컬렉션의 Map과 동일한 역할
			application.setAttribute("op", op);
		}

	}

}
