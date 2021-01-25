package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import vo.Member;

@WebServlet("/ajaxText8.do")
public class AjaxText8 extends HttpServlet {
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

		//ajax에서 보낸 값 저장
		String userIndex8 = request.getParameter("userIndex8");
		
		System.out.println(userIndex8);
		
		//여러 개로 되어 있는 데이터를 쪼개는 작업이 필요
		StringTokenizer st = new StringTokenizer(userIndex8, ",");
		
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		
		while(st.hasMoreElements()) {
			indexs.add(Integer.parseInt(st.nextToken()));
		}
		
		//JSONObject는 기본적으로 map형태를 띄고 있기 때문에 JSONObject를 그냥 사용하면 MAP형태
		//map형태로 쓸건지, 배열 형태로 쓸건지는 자유
		JSONObject map = new JSONObject();
		
		for(int i = 0; i<indexs.size(); i++) {
			//ArrayList<Member>에서 해당 index를 가진 객체를 꺼내오는 작업
			//Member m = list.get(indexs.get(i)-1); 이거랑 같은 말
			int userIndex = indexs.get(i);
			Member m = list.get(userIndex-1);
			
			//꺼내온 java 객체를 JSON화 시키는 작업
			JSONObject object = new JSONObject();
			object.put("name",m.getName());
			object.put("age", m.getAge());
			object.put("addr", m.getAddr());
			
			map.put(i+1, object); //key, value
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.print(map);
	}

}
