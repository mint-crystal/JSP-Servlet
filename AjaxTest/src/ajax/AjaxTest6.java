package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import vo.Member;

@WebServlet("/ajaxTest6.do")
public class AjaxTest6 extends HttpServlet {
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
		
		/*
		 * 사용자가 특정 유저의 번호를 입력했을 때
		 * 정보(list)안에 해당 유저의 index가 있으면 꺼내서 list안에 1개만 저장해서 전송하고
		 * 정보(list)안에 해당 유저의 index가 없으면 꺼내서 list안에 모든 정보를 전송.
		 * 즉, 1개의 데이터가 있든 여러 개의 데이터가 있든 list 안에 담아서 보내면 
		 * 	보내는 곳에서도 받는 곳에서도 문제없이 처리할 수 있음
		 */
		
		//ajax에서 보내온 값 저장
		int userIndex2 = Integer.parseInt(request.getParameter("userIndex2"));
		
		/*
		 * 사용자가 리스트 범위 안에 있는 수를 입력했을 경우와 리스트 안에 있는 번호를 입력하지 않았을 경우
		 * 사용자 1번 -> 인덱스[0]
		 * list의 인덱스 범위 : 0 ~ 9
		 */
		
		//서버에서는 1개의 객체만 보낸다면 JSONObject를 사용할 수 있지만 여러 개의 객체를 보내려면 JSONArray를 사용해야함
		JSONArray array = new JSONArray();
		
		//0 ~ 9
		if(0<=(userIndex2-1) && (userIndex2-1)<=list.size()) {
			//사용자가 리스트 범위 안에 있는 index를 입력했을 경우
			JSONObject object = new JSONObject();
			Member m = list.get(userIndex2-1);
			object.put("name",m.getName());
			object.put("age", m.getAge());
			object.put("addr", m.getAddr());
			array.add(object);
		}else {
			//사용자가 리스트 범위 안에 있는 index를 벗어났을 경우
			for(Member m : list) {
				JSONObject object = new JSONObject();
				object.put("name",m.getName());
				object.put("age", m.getAge());
				object.put("addr", m.getAddr());
				array.add(object);
			}
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(array);
	}

}
