<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="<c:url value="/resources/css/accommodation.css" />" rel="stylesheet" type="text/css"> 
<!--     <link rel="stylesheet" href="./accommodation.css"> -->
</head>
<body>
    <div class="container">
        <header>
            <div class="accommodation_image"></div>
            <div class="accommodation_content">
                <div class="accommodation_title"></div>
                <div class="accommodation_information"></div>
                <div class="accommodation_date"></div>
                <div class="date_button"></div>
            </div>
        </header>
        <section class="section_contianer">
        	<c:forEach items="${roomlist}" var="room">
            <div class="room_review_tab"></div>
            <div class="room_view">
                <div class="room_image">
                	
                </div>
                <div class="room_number">
                	<c:out value="${room.ro_name}" />
                </div>
                <div class="room_infomation">
                	<c:out value="${room.ro_info}" />
                </div>
                <div class="room_price">
                	<c:out value="${room.room_price}" />
                </div>
                <div class="room_infomation_button">
                	<td><a href="/stay/room/detail_of_detail?ac_id=${room.ac_id}&ro_name=${room.ro_name}"><c:out value="${room.ro_name}" /></a></td>
                </div>
                <div class="booking_button"></div>
            </div>
            </c:forEach>
        </section> 
    </div>
    
    
    

</body>
</html>