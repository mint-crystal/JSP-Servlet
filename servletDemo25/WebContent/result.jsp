<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
<!-- servlet=>인자전송 -->
result1 : <%=request.getAttribute("java") %> <br />
result1 : ${java} <br />	<!-- El방식 -->
<!-- requestScope : EL(Expressional Language)의 request(요청 처리 객체)에 해당되는 기본 객체 -->
result1 : ${requestScope.java} <br/>
result2 : <%=request.getAttribute("jsp") %> <br />
result2 : ${jsp} <br />
result2 : ${requestScope.jsp} <br/>

</body>
</html>