

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//인자 생성
		request.setAttribute("java", "1.8");
		request.setAttribute("jsp", "2.3");
		
		//foward 방식으로만 인자 전송 가능!
		//페이지(JSP)이동. URL 불변.
		
		//reponse.sendRedirect("페이지 주소(URL)"); => 페이지/URL 동시 변경
		//request.setAttribute 전송 X
		
		//페이지 이동(forward) - 포워드 방식으로 페이지를 이동하기 위해 디스패처 사용
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
