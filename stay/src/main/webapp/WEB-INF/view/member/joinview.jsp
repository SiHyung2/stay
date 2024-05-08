<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../menu.jsp"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="join.css">
<meta charset="EUC-KR">
<title>login</title>
</head>
<body>
	<div class="registration-form">
		<h1>회원가입</h1>
		<form action="/stay/member/insert" method="post">




			<div class="form-group">
				<label>이메일아이디</label> <input class="form-control" name='email_id'>
			</div>

			<div class="form-group">
				<label>비밀번호</label><input class="form-control" name='password'> 
			</div>

			<div class="form-group">
				<label for="confirmPassword">비밀번호 확인:</label> <input
					class="form-control" type="password" id="confirmPassword"
					name="confirmPassword" required>
			</div>


			<div class="form-group">
				<label>이름</label> <input class="form-control" name='name'></input>
			</div>

			<div class="form-group">
				<label>전화번호</label> <input class="form-control" name='tel'></input>
			</div>

			<div class="form-group">
				<label for="type_code">Type Code</label> <select
					class="form-control" name="type_code" id="type_code">
					<option value="1">일반고객</option>
					<option value="2">사업자</option>
				</select>
			</div>
			
			
			

			<button type="submit">Register</button>
		</form>
	</div>

</body>
</html>

