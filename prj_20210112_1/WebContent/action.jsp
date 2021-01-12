<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.MessageDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>action</title>
</head>
<body>
	<%	//JEE영역
		//인자처리
		//인코딩 방식 지원 선처리
		/* 참고) EUC-KR(표준 완성형 : KSC-5601) -> MS-949(x-window-949)
			MS-949가 EUC-KR체계를 포함	*/
		//기본 인코딩 : ISO-8859-1(서유럽어) -> 변환필요
		request.setCharacterEncoding("UTF-8");	//POST방식 전용 인코딩 변환(적용)
		//추후에는 주로 필터(filter)로 선처리하는 경향
		/* 	참고) Tomcat 8 이후에는 get방식 인자 한글처리는 자동!
				이전 버전은 수동 변환 처리 해야됨
				ex) String.getByte 메소드 활용, server.xml의 
				<Connector URIEncoding="UTF-8" />로 처리(서버 차원에서 처리 : 모든 프로젝트에 적용)*/
		
		/*	request : 클라이언트 요청 처리  JSP 기본(내장) 객체
			원형 : HttpServletRequest	*/
		/*	out : 웹브라우저 출력 처리 JSP 기본(내장) 객체
			원형 : JspWriter	*/
		//인자 수신
		out.println("인자 : "+request.getParameter("message"));
		
		 // 인자 수신 : DTO 단위
	    // <jsp:useBean /> 액션 태그(xml)
	    // java code 비교)
	    // domain.MessageDTO messageDTO = new domain.MessageDTO();
	    MessageDTO messageDTO2 = new MessageDTO();
	%>
	 
	<%-- <jsp:useBean id="messageDTO" class="domain.MessageDTO"></jsp:useBean> --%>
	    <jsp:useBean id="messageDTO" class="domain.MessageDTO"/>   
	             
	    <!-- setter 역할 : 인자 입력 -->       
	    <jsp:setProperty name="messageDTO" property="message" />
	    <%
	        messageDTO2.setMessage(request.getParameter("message"));
	    %>
	   
	    <!-- getter/출력 역할 : 인자 출력 -->
	    <br>
	    - message : <jsp:getProperty name="messageDTO" property="message" />
	    <br>
	    - message2 : <%=messageDTO2.getMessage() %>              
</body>
</html>