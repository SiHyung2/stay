<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 50vh;
}

.room_view {
	width: 80%;
	border-collapse: collapse;
	margin-top: 20px;
}

.room_view td {
	padding: 10px;
	border: 1px solid #ccc;
}

.room_title {
	font-weight: bold;
	font-size: 18px;
}

.room_info {
	font-size: 16px;
}
</style>
</head>
<body>
	<%@include file="../menu.jsp"%>
	<%@include file="./booking_check_menu.jsp"%>
	<%@include file="./booking_check_sidebar.jsp"%>

	<div class="container">
		<table class="room_view">
			<c:forEach var="booking" items="${checkBookings}">
			<c:if test="${booking.status == 1}">
				<tr>
					<td rowspan='5' class="ac_image"><img src="ro_image_url"
						alt="Room Image"></td>
					<td class="room_title"><c:out value="${booking.ac_title}" /></td>
				</tr>
				<tr>
					<td class="room_info"><strong>방이름:</strong> <c:out
							value="${booking.ro_name}" /></td>
				</tr>
				<tr>
					<td class="room_info"><strong>입실:</strong> <c:out
							value="${booking.checkin_day}" /></td>
				</tr>
				<tr>
					<td class="room_info"><strong>퇴실:</strong> <c:out
							value="${booking.checkout_day}" /></td>
				</tr>
				<tr>
					<td class="room_info"><strong>가격:</strong> <c:out
							value="${booking.room_price}" />원
						<div class="float-right">
							<button type="button" class="btn btn-primary btn-sm cancel-btn" data-bo-num="${booking.bo_num}">예약취소</button>
						</div></td>
				</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).on('click', '.cancel-btn', function(e) {
            e.preventDefault();

            var bo_num = $(this).data('bo_num');
            console.log("예약번호: " + bo_num);

            var form = $('<form>', {
                'action': '/stay/booking/bookingcancel_button',
                'method': 'post'
            });

            form.append($('<input>', {
                'type': 'hidden',
                'name': 'bo_num',
                'value': $(this).data('bo-num') // 클릭한 버튼의 data-bo-num 속성 값을 사용합니다.
            }));
            
            form.append($('<input>', {
                'type': 'hidden',
                'name': 'email_id',
                'value': '${sessionScope.LoginVO.email_id}'
            }));
            
            $('body').append(form);
            form.submit();

        });

    </script>
</body>
</html>
