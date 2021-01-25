package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import vo.Member;

@WebServlet("/ajaxTest9.do")
public class AjaxTest9 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//정보를 받아서 처리하기 전에 비지니스 로직으로 DB에서 리스트를 가져왔다고 가정
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("홍길동", 20, "성남")); //인덱스[0]
		list.add(new Member("김길동", 32, "서울")); //인덱스[1]
		list.add(new Member("이길동", 34, "시흥")); //인덱스[2]
		list.add(new Member("최길동", 22, "오이도")); //인덱스[3]
		list.add(new Member("박길동", 12, "강릉")); //인덱스[4]
		list.add(new Member("정길동", 23, "춘천")); //인덱스[5]
		list.add(new Member("오길동", 25, "하남")); //인덱스[6]
		list.add(new Member("유길동", 18, "인천")); //인덱스[7]
		list.add(new Member("조길동", 31, "대구")); //인덱스[8]
		list.add(new Member("한길동", 28, "해남")); //인덱스[9]
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		
		new Gson().toJson(list,out);
	}

}
