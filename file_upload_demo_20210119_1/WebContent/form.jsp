<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>
<!--
// 가능한 경로
./file_action.do
file_action.do
${pageContext.request.contextPath}/file_action.do
 
// 잘못된 경로
../file_action.do
/file_action.do
-->
	<form name="frm" method="post" enctype="multipart/form-data" 
			action="file_action.do"
			<%-- action="${pageContext.request.contextPath}/file_action.do" --%>>
		파일 : <input type="file" name="file_name" /><br />
		<input type="submit" value="전송" />
	</form>
</body>
</html>