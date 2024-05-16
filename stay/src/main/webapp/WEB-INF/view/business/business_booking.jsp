<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <title>Business Booking Details</title>
    <style>
        .con {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<%@include file="../menu.jsp"%>
<%@include file="./business_menu.jsp"%>
<div class="con">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">예약번호</th>
            <th scope="col">객실이름</th>
            <th scope="col">체크인</th>
            <th scope="col">체크아웃</th>
            <th scope="col">예약자</th>
            <th scope="col">전화번호</th>
            <th scope="col">예약상태</th>
            <th scope="col">숙소이름</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="booking" items="${businessbooking}">
                <tr>
                    <td>${booking.bo_num}</td>
                    <td>${booking.room_rum}</td>
                    <td>${booking.checkin_day}</td>
                    <td>${booking.checkout_day}</td>
                    <td>${booking.email_id}</td>
                    <td>${booking.tel}</td>
                    <td>${booking.status}</td>
                    <td>${booking.ac_id}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

	
