package ajax;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxTest2.do")
public class AjaxTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송받는 값은 없음 -> 받는 것에 대한 인코딩은 할 필요가 없음
		//전송 보내는 Servlet이기 때문에 보내는 것에 대한 인코딩 처리 필요
		
		response.setCharacterEncoding("utf-8");
		//response.setContentType(); //웹페이지 형식으로 보낼때 사용. 여기서는 데이터만 보내는 것이라 필요X
		PrintWriter out = response.getWriter();
		out.print("오늘의 점심 : 볶음우동");
	}

}
