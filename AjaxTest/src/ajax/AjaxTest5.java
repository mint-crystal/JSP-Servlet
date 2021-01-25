package ajax;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import vo.Member;

@WebServlet("/ajaxTest5.do")
public class AjaxTest5 extends HttpServlet {
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
		
		int userIndex = Integer.parseInt(request.getParameter("userIndex"));
		//사용자가 1번을 보냈으면 list의 0번 인덱스에 위치한 홍길동의 정보를 주어야 함
		
		Member m = list.get(userIndex-1); //userIndex-1은 유저가 3을 입력하면 인덱스[2]값을 뜻함
		//Member 객체는 자바꺼라서 자바스크립트는 인식을 못함. 그래서 자바스크립트가 처리할 수 있는 JSON형태로 바꿔줘야함
		//그때 JSON 형태로 바꾸러 주려면 별도 라이브러리를 사용해야 함.
		//json-simple.jar 라이브러리 사용
		
		JSONObject object = new JSONObject();
		//JSONObject는 map형태에서 파생되었음(key, value)
		
		object.put("name", m.getName());
		object.put("age", m.getAge());
		object.put("addr", m.getAddr());
		//위에서처럼 작성하게 되면 JSON형태로 처리되었다고 생각하면 됨
		//{"name":m.getName(), "age":m.getAge(), "addr":m.getAddr()}
		
		//JSON 객체를 보내주기 전에 해당 ajax에 데이터 타입을 알려줘야함
		response.setContentType("application/json");
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(object);
	}

}
