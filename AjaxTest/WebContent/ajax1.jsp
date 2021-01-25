<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>ajax 동작 시키기</h2>
	<button id="btn">클릭</button>
	
	<!-- jquery cdn -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>

	<script>
		$(function(){
			$('#btn').click(function(){
			//Ajax 동작 방식
			//ajax코드를 작성하고, url에 적혀있는 Servlet을 호출(비동기식 방식으로 호출)
			//Servlet에서는 받은 데이터를 바탕으로 로직 처리 및 처리 후 결과를 돌려주는 방식
			//모든 로직이 비동기식 방식으로 동작
			
				//jQuery Ajax코드
				$.ajax({
					url : "test.do", //호출할 서블릿
					type : "get", //post or get
					success : function(){ //위에 있는 url 페이지 혹은 Servlet을 호출했을때 성공하면 불려지는 이벤트 핸들러(함수)
						alert("정상적으로 페이지가 호출됩니다.");
					},
					error : function(){ //위에 있는 url 페이지 혹은 Servlet을 호출했을때 실패하면 불려지는 이벤트 핸들러(함수)
						alert("페이지 호출에 실패하였습니다.");
					},
					complete : function(){ //위에 있는 url 페이지 혹은 Servlet을 호출했을 때 성공유무와 상관없이 무조건 호출되는 이벤트 핸들러(함수)
						alert("저는 무엇이 되었든 자동으로 무조건 호출됩니다.")
					}
				});
			});
		});
	</script>
</body>
</html>