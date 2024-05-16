<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>메뉴 페이지</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary mt-5">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto" style="margin: auto;">
				<li class="nav-item active"><a class="nav-link"
					href="./bookingcomplete?email_id=${sessionScope.LoginVO.email_id}"
					style="color: black; font-size: 20px; margin-right: 30px;">예약
						완료</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="./bookingcancel?email_id=${sessionScope.LoginVO.email_id}"
					style="color: black; font-size: 20px; margin-right: 30px;">예약
						취소</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="./bookingend?email_id=${sessionScope.LoginVO.email_id}"
					style="color: black; font-size: 20px; margin-right: 30px;">이용
						완료</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>