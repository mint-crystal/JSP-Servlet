<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action4</title>
</head>
<body>
	<%	
		//인자 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		//반복자 (디자인) 패턴 : 다음(next) 요소 검색 방식. 인덱스 검색X
		Enumeration<String> en =  request.getParameterNames();
		while(en.hasMoreElements()) {//iterator의 hasNext()와 같은 기능
			String key = en.nextElement();
			String value = request.getParameter(key); //인자명을 사용해 값 파악
			if(key.equals("kind")){	//체크박스(다수의 값)
				String[] vals = request.getParameterValues(key);
				for(String val : vals){
					out.println("인자명 : "+key+"=");
					out.println("인자값 : "+val+"<br>");
				}
			} else {
				out.println("인자명 : "+key+"=");
				out.println("인자값 : "+value+"<br>");
			}
		}
	%>
</body>
</html>