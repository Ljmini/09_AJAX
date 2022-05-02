<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label{
		display: block;
	}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	// 페이지로드 이벤트
	$(document).ready(function(){
		fnList();
		fnDetail();
		fnAdd();
		fnModify();
		fnRemove();
		fnInit();
		
	})
	
	// 함수 영역
	function fnList(){
		/* $('#').on('',function(){
			$.ajax({
				
			})
		}); */
	}
	function fnDetail(){
		// 조회 버튼을 클릭하면 실행
	}
	function fnAdd(){
		// 등록 버튼을 클릭하면 실행
		// 화면이 열리면 곧바로 실행
		$('#btnAdd').click(function(){

			// 요청 URL
			// http://localhost:9090/AJAX/add.do
				
			// 요청 Method
			// POST
			
			// 요청 Parameter
			// id=아이디&name=이름&gender=성별&address=주소
			
			// 요청 Parameter 상세
			// id 		: 신규 회원의 아이디 (필수, 중복 불가)
			// name 	: 신규 회원의 이름
			// gender 	: 신규 회원의 성별
			// address 	: 신규 회원의 주소
			
			$.ajax({
				url : '/AJAX/add.do',
				type : 'POST',
				data : 'id=' + $('#id').val() + '&name=' + $('#name').val() + '&gender=' + $(':radio[name="gender"]:checked').val() + '&address=' + $('#address').val(),				
				dataType : 'json',
				success: function(responseText){		// AddService에서 out.write(reponseText) 가 success일 때, 함수 매개변수로 넘어온다.
					alert(responseText.res);
				},
				error : function(jqXHR){
					alert(jqXHR.status);
					alert(jqXHR.responseText);
				}
			})
		});
	}
	function fnModify(){
		// 수정 버튼을 클릭하면 실행
	}
	function fnRemove()
	{
		// 삭제 버튼을 클릭하면 실행
	}
	function fnInit(){
		// 초기화 버튼을 클릭하면 실행
		$('#btnInit').on('click',function(){
			$('#id').val('');
			$('#name').val('');
			$(':radio[name="gender"]').prop('checked',false);
			$('#address').val('');	
		});
	}
	
</script>
</head>
<body>
	<h1>회원관리</h1>
	<div>
		<form id="formMember">
			<label for="id">
				아이디<input type="text" name="id" id="id">		
			</label>
			<label for="name">
				이름<input type="text" name="name" id="name">
			</label>
			<label for="male">
				남자<input type="radio" name="gender" id="male" value="male">
			</label>
			<label for="female">
				여자<input type="radio" name="gender" id="female" value="female">
			</label>
			<label for="address">
				주소<input type="text" name="address" id="address">
			</label>
			
			<div>
				<input type="button" value="초기화" id="btnInit">
				<input type="button" value="등록" id="btnAdd">
				<input type="button" value="수정" id="btnModify">
				<input type="button" value="삭제" id="btnRemove">
			</div>	
		</form>
	</div>
	
	<hr>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>아이디</td>
					<td>이름</td>
					<td>성별</td>
					<td>주소</td>
					<td>버튼</td>
				</tr>
			</thead>
			<tbody id="memberList">

			</tbody>
		</table>
	</div>
</body>
</html>