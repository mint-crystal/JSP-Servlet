package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet(
		asyncSupported = true, 
		description = "데모 서블릿", 
		urlPatterns = { 
				"/DemoServlet", 
				"/demo.do"
		}, 
		initParams = { 
				@WebInitParam(name = "java", value = "1.8", description = "jdk version"), 
				@WebInitParam(name = "jsp", value = "2.3", description = "jsp version")
		})
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println("서블릿 생성자");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("service");
//		doGet(request, response); //명시적으로 호출하여 Console 창에 doGet 출력
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//인자 처리
		response.setContentType("text/html; charset=UTF-8"); //한글 변환
		PrintWriter out = response.getWriter();
		out.println("java : "+request.getParameter("java"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		
		request.setCharacterEncoding("UTF-8");	//POST방식 전용 인코딩 처리 => 필터(filter)화 시키면 좋음
		response.setCharacterEncoding("UTF-8"); //안 해도 되지만 해놓으면 좋음 : 페이지 응답에 대한 처리?
		
		response.setContentType("text/html; charset=UTF-8"); //한글 변환
		PrintWriter out = response.getWriter();
		out.println("java : "+request.getParameter("java"));
	}

}
