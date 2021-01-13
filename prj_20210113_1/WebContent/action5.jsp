<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action5</title>
</head>
<body>
	<%	
		//인자 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		MessageDTO dto = new MessageDTO();
		dto.setWriter(request.getParameter("writer"));
		dto.setPassword(request.getParameter("password"));
		dto.setMessage(request.getParameter("message"));
		dto.setKind(request.getParameterValues("kind"));
		dto.setPhone1(request.getParameter("phone1"));
		dto.setPhone2(request.getParameter("phone2"));
		dto.setPhone3(request.getParameter("phone3"));
		
		// DB 저장
		MessageVO messageVO = new MessageVO(dto);
		// 인자 확인
		out.println("messageVO : "+messageVO);
		// dao.insertMessage(messageVO);
	%>
</body>
</html>