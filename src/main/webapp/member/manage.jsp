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
		// 화면이 열리면 곧바로 실행
	}
	function fnDetail(){
		// 조회 버튼을 클릭하면 실행
	}
	function fnAdd(){
		// 등록 버튼을 클릭하면 실행
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
	}
	
</script>
</head>
<body>
	<h1>회원관리</h1>
	<div>
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