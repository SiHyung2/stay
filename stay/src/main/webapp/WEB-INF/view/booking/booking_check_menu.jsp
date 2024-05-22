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
				<li class="nav-item active">
					<form action="./bookingcomplete" method="post" style="margin: 0;">
						<input type="hidden" name="email_id"
							value="${sessionScope.LoginVO.email_id}">
						<button type="submit" class="nav-link"
							style="color: black; font-size: 20px; margin-right: 30px; background: none; border: none; padding: 0;">예약
							완료</button>
					</form>
				</li>

				<li class="nav-item active">
					<form action="./bookingcancel" method="post" style="margin: 0;">
						<input type="hidden" name="email_id"
							value="${sessionScope.LoginVO.email_id}">
						<button type="submit" class="nav-link"
							style="color: black; font-size: 20px; margin-right: 30px; background: none; border: none; padding: 0;">예약
							취소</button>
					</form>
				</li>

				<li class="nav-item active">
					<form action="./bookingend" method="post" style="margin: 0;">
						<input type="hidden" name="email_id"
							value="${sessionScope.LoginVO.email_id}">
						<button type="submit" class="nav-link"
							style="color: black; font-size: 20px; margin-right: 30px; background: none; border: none; padding: 0;">이용
							완료</button>
					</form>
				</li>
			</ul>
		</div>
	</nav>
</body>
</html>