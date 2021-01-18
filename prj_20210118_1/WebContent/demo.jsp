<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- c : 코어라이브러리 --%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>demo</title>
</head>
<body>
<%
request.setAttribute("java", "1.8");
request.setAttribute("page_link", "includee.jsp?abcd=1234&python=3.7");
%>
<c:forEach items="${list}" var="board">

</c:forEach>
인자 : <c:out value="${java}" /> <br>

jsp:include : <jsp:include page="${page_link} " /><br>
			<%-- <jsp:include page="${page_link}">
				<jsp:param value="4567" name="abcd"/>
				<jsp:param value="2.5" name="python"/>
			</jsp:include><br> --%> <!-- setAttribute로 우선 적용 -->
include directive : <%@ include file="includee.jsp" %>
</body>
</html>