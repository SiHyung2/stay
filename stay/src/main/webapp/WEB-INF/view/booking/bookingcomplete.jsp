<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../menu.jsp"%>
<%@include file="./booking_check_munu.jsp"%>
<%@include file="./booking_check_sidebar.jsp"%>

<%-- 	<c:forEach var="booking" items="${checkBookings}"> --%>
	
<!--                 <tr> -->
<%--                     <td>방번호 : ${booking.bo_num}</td> --%>
<%--                     <td>${booking.room_num}</td> --%>
<%--                     <td>${booking.checkin_day}</td> --%>
<%--                     <td>${booking.checkout_day}</td> --%>
<%--                     <td>${booking.email_id}</td> --%>
<%--                     <td>${booking.tel}</td> --%>
<%--                     <td>${booking.status}</td> --%>
<%--                     <td>${booking.ac_id}</td> --%>
<!--                 </tr> -->
<%--             </c:forEach> --%>
	<table class="room_view">
				<c:forEach var="booking" items="${checkBookings}">
					<tr>
						<td  rowspan='3' class="ac_image">
							ro_image
						</td>
						<td class="room_title">
							<c:out value="${booking.bo_num}"/>
							<c:out value="${booking.email_id}"/>
							
						</td>
					</tr>
					<tr>
						<td class="ro_basic_and_max_and_checkin_checkout">
							<div>
								방번호 : <c:out value="${booking.room_num}"/>
							</div>
							<br>
							<div>
								입실 <c:out value="${booking.checkin_day}"/>
								/퇴실 <c:out value="${booking.checkout_day}"/>
							</div>
							
						</td>
					</tr>
					<tr class="tr_3rd">
						<button  onclick="location.href='#'">
								예약하기
							</button>
					</tr>
				</c:forEach>
			</table>
</body>
</html>