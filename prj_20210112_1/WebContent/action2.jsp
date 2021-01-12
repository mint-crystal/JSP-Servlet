<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.MessageDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action2</title>
</head>
<body>
	<%	
		request.setCharacterEncoding("UTF-8");
		
		//인자 수신
		out.println("작성자 : "+request.getParameter("writer")+"<br>");
		out.println("메시지 : "+request.getParameter("message")+"<br>");
		
	%>
	 	<hr>
	 	
	    <jsp:useBean id="messageDTO" class="domain.MessageDTO"/>   
	             
	    <!-- setter 역할 : 인자 입력 --> 
	    <%-- <jsp:setProperty name="messageDTO" property="writer" />      
	    <jsp:setProperty name="messageDTO" property="message" /> --%>
	    <jsp:setProperty name="messageDTO" property="*" />
	    <!-- *(와일드카드) : 모든 인자를 받아줌 -->
	   
	    <!-- getter/출력 역할 : 인자 출력 -->
	    <br>
	    - 작성자 : <jsp:getProperty name="messageDTO" property="writer" />   
	    - 메시지 : <jsp:getProperty name="messageDTO" property="message" />      
</body>
</html>