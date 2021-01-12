<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Map와 Set 컬렉션을 사용하기 위해 import  -->
<%-- <%@ page import="java.util.Map, domain.MessageDTO" %> --%>
<%@ page import="java.util.*"%>
<%@ page import="domain.MessageDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action3</title>
</head>
<body>
	<%	
		//인자 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		//인자를 한꺼번에 받아서 처리
		Map<String, String[]> map = request.getParameterMap();
		/*	Map => 키/값(pair) 구조
			ex) 아이디/패쓰워드,	우편번호/기본 주소, 전화번호(지역번호)/지역 ...
			인자의 이름 /값	*/
			
		Set<String> set = map.keySet(); 
		Iterator<String> it = set.iterator(); //다음 요소 검색 : 반복자 디자인 패턴 방식
		
		while(it.hasNext()){ //다음 요소 유무 검사(반복문)
			String key = it.next();
			String[] value = map.get(key);
			if(value.length == 1){	// 키/값 = 1:1
				out.println("인자 이름 : " + key +", 값 : " + value[0] + "<br>");
			} else if(value.length>1) {	// 키/값 = 1:n ex)checkbox
				for(String s : value){
					out.println("인자 이름 : " + key +", 값 : " + s + "<br>");
				}
			}
		}
		
		//map.forEach((x,y)->System.out.print(x+"="+y[0]));
		
		//////////////////////////////////////////////////////////////////
		
		out.println("분류 : ");
		
	/* 	//방법1
		String kinds[] = request.getParameterValues("kind");
		if(kinds == null){
			out.println("<script>alert('kind인자를 체크해주세요')</script>");
		}else{
			for(String s : kinds){
				out.print(s+" ");
			}
		} */
		
		//방법2
		if(request.getParameterValues("kind")==null){
			out.println("<script>alert('kind인자를 체크해주세요')</script>");
		} else {
			String kinds[] = request.getParameterValues("kind");
			for(String s : kinds){
				out.print(s+" ");
			}
		}
	%>
</body>
</html>