<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action6</title>
</head>
<body>
	<%	
		//인자 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		//MessageDTO dto = new MessageDTO();
		//MessageDTO dto = new MessageDTO(request.getParameterMap());
		
		// DB 저장
		//MessageVO messageVO = new MessageVO(dto);
		MessageVO messageVO = new MessageVO(new MessageDTO(request.getParameterMap())); //위 코드들을 한 줄로
		
		// 인자 확인
		out.println("messageVO : "+messageVO);
		// dao.insertMessage(messageVO);
		
		//dao.insertMessage(new MessageVO(new MessageDTO(request.getParameterMap())));
	%>
</body>
</html>