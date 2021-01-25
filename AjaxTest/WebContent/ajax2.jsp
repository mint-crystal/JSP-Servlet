<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>다양한 jQuery 예제</h1>
	<!-- jquery cdn -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>

	<h2>1. 버튼 클릭시 서버에게 값을 전송</h2>
	<input type="text" id="myName" />
	<button id="btn1">전송</button>
	<br><hr>
	
	<script>
		$(function() {
			$('#btn1').click(function(){
				var myName = $('#myName').val(); //myName이라는 ID를 가진 input태그의 value 값
				
				//jQuery Ajax코드
				$.ajax({
					url : "ajaxTest1.do",
					data : {"name":myName}, //key:value 형태
					type : "get",
					success : function(){
						console.log("서버 호출을 정상적으로 완료하였습니다.");
					},
					error : function(){
						console.log("서버 호출을 정상적으로 처리하지 못 했습니다.");
					},
					complete : function(){
						console.log("ajax 1번 코드 완료");
					}
				});
			});
		});
	</script>
	
	
	<h2>2. 버튼 클릭시 서버에서 보낸 값을 가져와서 브라우저로 출력해보기</h2>
	<button id="btn2">가져오기</button>
	<p id="p2" style="width:300px; height:50px; border:1px solid red;"></p>
	<hr><br>
	<script>
		$(function(){
			$('#btn2').click(function(){
				$.ajax({
					url : "ajaxTest2.do",
					type : "get",
					success : function(data){
						$('#p2').text(data);
					},
					error : function(){ //error, complete는 생략가능
						console.log("서버에서 데이터 가져오기 ajax로직 실패");
					}
				});
			});	
		});
	</script>
	
	
	<h2>3. 서버로 기본값을 전송하고, 결과를 받아서 출력</h2>
	첫 번째 수 입력 : <input type="text" id="su1" /><br>
	두 번째 수 입력 : <input type="text" id="su2" /><br>
	<button id="btn3">결과보기</button>
	결과 출력<br>
	<p id="p3" style="width:300px; height:50px; border:1px solid red;"></p>
	<hr><br>
	<script>
		$(function(){
			$('#btn3').click(function(){
				var su1 = $('#su1').val();
				var su2 = $('#su2').val();
				
				$.ajax({
					url : "ajaxTest3.do",
					type : "get",
					data : {"su1":su1, "su2":su2},
					success : function(data){
						$('#p3').text(data); //Servlet에서 보낸 결과값 data를 p태그에 출력
					},
					error : function(){
						console.log("ajax 3번째 동작 실패");
					}
				});
			});
		});
	</script>
	
	
	<h2>4. 서버로 Object 형태의 데이터 전송, 서버에서 처리</h2>
	이름 : <input type="text" id="studentName" /><br>
	나이 : <input type="text" id="studentAge" /><br>
	주소 : <input type="text" id="studentAddr" /><br>
	<button id="btn4">전송하기</button>
	<hr><br>
	<script>
		$(function(){
			$('#btn4').click(function(){
				var studentName = $('#studentName').val();
				var studentAge = $('#studentAge').val();
				var studentAddr = $('#studentAddr').val();
				
				var object = {"name":studentName, "age":studentAge, "addr":studentAddr};
				$.ajax({
					url : "ajaxTest4.do",
					type : "get",
					data : object,
					success : function(){
						console.log("전송 성공");
					},
					error : function(){
						console.log("전송 실패");
					}
				});
			});
		});
	</script>
	
	
	<h2>5. 서버에게 기본 데이터 전송 후 객체 리턴</h2>
	자바스크립트에서 VO객체의 값을 사용하려면 json이 필요(key, value 형태로 가져옴)
	<br><br>
	유저 번호 입력 : <input type="text" id="userIndex" />
	<button id="btn5">전송</button>
	<p id="p5" style="width:300px; height:100px; border:1px solid red;"></p>
	<hr><br>
	<script>
		$(function(){
			$('#btn5').click(function(){
				var userIndex = $('#userIndex').val();
				
				$.ajax({
					url : "ajaxTest5.do",
					type : "get",
					data : {"userIndex" : userIndex},
					success : function(data){
						$('#p5').html("이름 : "+data.name+"<br>"
								+"나이 : "+data.age+"<br>"
								+"주소 : "+data.addr+"<br>");
					},
					error : function(){
						console.log("ajax 동작 실패");
					}
				});
			});
		});
	</script>
	
	
	<h2>6. 기본값을 전송, 서버에서 리스트 객체 반환</h2>
	<h5>(유저 번호를 보내서 유저번호가 있으면 해당 유저 정보, 없으면 전체 유저 정보 리턴)</h5>
	유저번호 입력 : <input type="text" id="userIndex2" />
	<button id="btn6">전송</button>
	
	<p id="p6" style="width:300px; height:100px; border:1px solid red;"></p>
	<hr><br>
	<script>
		$(function(){
			$('#btn6').click(function(){
				var userIndex2 = $('#userIndex2').val();
				
				$.ajax({
					url : "ajaxTest6.do",
					type : "get",
					data : {"userIndex2" : userIndex2},
					success : function(data){ //배열이 넘어옴
						$('#p6').text(""); //기존 내용 삭제
						for(var i = 0; i<data.length; i++){
							$('#p6').append("이름 : "+data[i].name+"/"
									+"나이 : "+data[i].age+"/"
									+"주소 : "+data[i].addr+"<br>");
						}
					},
					error : function(){
						console.log("ajax 통신 실패");
					}
				});
			});
		});
	</script>
	
	
	<h2>7. 번호를 여러 개 전송하여 여러 개의 객체를 리스트로 반환</h2>
	<h5>( , 콤마로 표시하여 전송 )</h5>
	유저 번호 입력(번호, 번호, 번호...) : <input type="text" id="userIndex3" />
	<button id="btn7">전송</button>
	<p id="p7" style="width:300px; height:100px; border:1px solid red;"></p>
	<hr><br>
	<script>
		$(function(){
			$("#btn7").click(function(){
				var userIndex3 = $('#userIndex3').val();
				//보내는 데이터 형식 ex) 1 / 1,2 / 1,3,5 / 1,6,9
				$.ajax({
					url : "ajaxTest7.do",
					type : "get",
					data : {"userIndex3" : userIndex3},
					success : function(data){
						$('#p7').text(""); //기존 내용 삭제
						for(var i = 0; i<data.length; i++){
							$('#p7').append("이름 : "+data[i].name+"/"
									+"나이 : "+data[i].age+"/"
									+"주소 : "+data[i].addr+"<br>");
						}
					},
					error : function(){
						console.log("ajax 통신 실패");
					}
				});
			});
		});
	</script>
	
	
	<h2>8. 서버로 기본형 데이터 여러 개 전송, 서버에서 맵 형태로 객체를 리턴(JSON MAP)</h2>
	유저 번호 입력(번호, 번호, 번호...) : <input type="text" id="userIndex8" />
	<button id="btn8">전송</button>
	<p id="p8" style="width:300px; height:100px; border:1px solid red;"></p>
	<hr><br>
	<script>
		$(function(){
			$("#btn8").click(function(){
				var userIndex8 = $('#userIndex8').val();
				$.ajax({
					url : "ajaxTest8.do",
					type : "get",
					data : {"userIndex8":userIndex8},
					success : function(data){
						//JSON(MAP)을 접근할 때에는 key를 가지고 접근할 수 있음
						
						//JSON(MAP)의 데이터를 접근할 때 key를 가지고 접근하는데,
						//접근 방법은 .key 혹은 [key]로 접근할 수 있음
						
						//그렇기때문에 key추출 작업이 되어야 함
						var keys = Object.keys(data);
						//console.log(keys); <-키 확인 코드
						//Object는 자바스크립트에서 제공해주는 기본 객체
						
						$('#8').text(""); //초기화
						for(var i = 0; i<keys.length; i++){
							$('#p8').append("이름 : "+data[keys[i]].name+"/"
									+"나이 : "+data[keys[i]].age+"/"
									+"주소 : "+data[keys[i]].addr+"<br>");
						}
					},
					error : function(){
						console.log("ajax 통신 실패");
					}
				});
			});
		});
	</script>
	
	
	<h2>9. GSON을 이용한 List 전체 목록 받아오기</h2>
	<h5>GSON은 구글이 만든 JSON</h5>
	<h6>자바 객체 -> JSON 변환하는 작업을 GSON으로 한 번에 처리하기 위해 제작됨</h6>
	<button id="btn9">모든 List 가져오기</button>
	<p id="p9" style="width:500px; height:300px; border:1px solid red;"></p>
	<script>
		$(function(){
			$('#btn9').click(function(){
				$.ajax({
					url : "ajaxTest9.do",
					type : "get",
					success : function(data){
						$('#p9').text(""); //기존 내용 삭제
						for(var i = 0; i<data.length; i++){
							$('#p9').append("이름 : "+data[i].name+"/"
									+"나이 : "+data[i].age+"/"
									+"주소 : "+data[i].addr+"<br>");
						}
					},
					error : function(){
						console.log("ajax 통신 실패");
					}
				});
			});
		});
	</script>
</body>
</html>