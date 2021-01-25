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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import vo.Member;

@WebServlet("/ajaxTest7.do")
public class AjaxTest7 extends HttpServlet {
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
		String userIndex3 = request.getParameter("userIndex3");

		System.out.println(userIndex3);

		//여러 개로 되어있는 데이터를 쪼개는 작업이 필요
		StringTokenizer st = new StringTokenizer(userIndex3,",");

		ArrayList<Integer> indexs = new ArrayList<Integer>();

		while(st.hasMoreTokens()) { //그 다음 토큰이 있다면
			indexs.add(Integer.parseInt(st.nextToken())); //토큰을 하나씩 꺼내줌(String -> int)
		}

		JSONArray arr = new JSONArray();

		for(int i = 0; i<indexs.size(); i++) {
			Member m = list.get(indexs.get(i)-1);

			JSONObject obj = new JSONObject();

			obj.put("name", m.getName());
			obj.put("age", m.getAge());
			obj.put("addr", m.getAddr());

			arr.add(obj);
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.print(arr);
	}

}
