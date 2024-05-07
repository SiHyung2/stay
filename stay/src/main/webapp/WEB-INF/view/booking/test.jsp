<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<div class="form-group">
			<label for="reservationDate">시작 날</label> <input type="date"
				class="form-control" id="reservationDate">
		</div>
		<div class="form-group">
			<label for="reservationDate">마지막 날</label> <input type="date"
				class="form-control" id="reservationDate">
		</div>
		<a href="reservation.html" class="btn btn-primary">예약하기</a>
	</div>
</body>
</html>