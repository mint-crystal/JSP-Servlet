<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삽입 페이지</title>
</head>
<body>
끼어들어가는 페이지 <br>
인자1 : <%=request.getParameter("abcd") %> <br>
인자2 : <%=request.getParameter("python") %><br>
<!-- EL방법 -->
인자 1-2 : ${param.abcd}<br> 
인자 2-2 : ${param.python}<br>
</body>
</html>