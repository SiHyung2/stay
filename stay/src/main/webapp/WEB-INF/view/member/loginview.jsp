<%@ page language="java" 
    pageEncoding="UTF-8"%>
    <%@include file="../base/menu.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/login.css">
 	
<meta charset="EUC-KR">
<title>login</title>
</head>
<body>
  <div class="container">
        <div class="login-form">
            <h1>Stay</h1>
            <form action="/stay/member/login" method="post">
                <div class="form-group">
                    <label for="username">아이디</label>
                    <input type="text" id="email_id" name="email_id" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password">비밀번호</label>
                    <input type="password" id="password" name="password" class="form-control">
                </div>
                <button type="submit" class="btn">로그인</button>
                <a href="#" class="forgot-password">회원가입</a>
                <a href="#" class="forgot-password">비밀번호를 잊으셨나요?</a>
            </form>
        </div>
    </div>
</body>
</html>

