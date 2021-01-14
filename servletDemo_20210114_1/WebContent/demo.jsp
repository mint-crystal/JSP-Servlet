<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
	<!-- 프로젝트 시작(최상위:root) 경로(path) -->
	context path-1 : <%=request.getContextPath()%> <br>
	context path-2 : ${pageContext.request.contextPath} <br> <!-- El방법 -->
	<form method="post" action="<%=request.getContextPath()%>/DemoServlet">
						<!-- servet.xml의 ContextPath를 이용해 경로 지정 가능 -->
		<input type="text" name="java" />
		
	</form>
</body>
</html>