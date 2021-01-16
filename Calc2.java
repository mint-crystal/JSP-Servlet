package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session과 application, cookie를 사용했을 때의 결과는 같음
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies(); //읽어오기 위한 변수 선언
		
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
//			//application
//			int x = (Integer)application.getAttribute("value");
			
//			//session
//			int x = (Integer)session.getAttribute("value"); //저장된 값 호출해서 담음
//						//Object로 값을 반환하기 때문에 int형 변환 필요
			
			//cookie
			int x = 0;
			for(Cookie c : cookies) {	//쿠키 읽기
				if(c.getName().equals("value")) { //value 값 찾기
					x = Integer.parseInt(c.getValue());
					break; //value값을 찾으면 중지
				}
			}
			
			int y = v;
			
			//String operator = (String)application.getAttribute("op");
			//String operator = (String)session.getAttribute("op"); //저장된 연산자 호출해서 담음
			String operator = "";
			for(Cookie c : cookies) {	//쿠키 읽기
				if(c.getName().equals("op")) { 
					operator = (c.getValue());
					break; 
				}
			}
			
			int result = 0;		
			if(operator.equals("+")) {
				result = x+y;
			} else {
				result = x-y;
			}	
			response.getWriter().printf("result is %d\n", result);
		} else {
			//+, - 연산자를 클릭하면 값을 저장
//			application.setAttribute("value",v);	//컬렉션의 Map과 동일한 역할
//			application.setAttribute("op", op);
			
//			session.setAttribute("value",v);
//			session.setAttribute("op", op);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v)); 
							//쿠키값을 보낼때에는 반드시 url을 사용할 수 있는 형태의문자열로!
			Cookie opCookie = new Cookie("op", op);
			
			/*	쿠키 path 옵션 설정 - 쿠키가 어느 경우에 사용자로부터 전달되어야하는지에 대한 경로
			 	ex) / = 모든 경로
			 		/notice/ = notice 안에 있는 모든것	*/
			valueCookie.setPath("/calc2"); //calc2에서만 쿠키를 받음
			//쿠키 maxAge 설정
			valueCookie.setMaxAge(24*60*60); //24시간 후 만료
			opCookie.setPath("/calc2"); //maxAge 설정 안 해서 브라우저가 닫히며 쿠키 만료
			
			
			//클라이언트에 전송 - response.header에 심어져서 전달
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			//서버에서 페이지 전환(redirect)
			response.sendRedirect("calc2.html");
		}

	}

}
