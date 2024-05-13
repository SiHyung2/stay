<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 목록</title>
</head>


<body>
	<%@include file="../menu.jsp"%>
	<link href="<c:url value="/resources/css/room_detail.css" />" rel="stylesheet" type="text/css">
    <div class="_container">
		<div class="ro_image">
		    <%@include file="./carousel.jsp"%>
	    </div>
	    
  		
   		<div class="ac_title_ro_name">
   			<div>
	   			<p><c:out value="${accommodation_list[0].ac_title}" /></p>&nbsp;&nbsp;
				<p><c:out value="${room.ro_name}" /></p>				
   			</div>
			
   		</div>   	
   		<div class="room_outline">
   			<p>객실 기본정보</p>
   		</div>	
   		<div class="room_price">
   			<div>
   				<p>가격 &nbsp;&nbsp;&nbsp;</p>
   				<p><c:out value="${room.room_price}" /></p>
   			</div>
   		</div>   		
   		<div class="checkin">
   			<div>
   				<p>체크인 &nbsp;&nbsp;&nbsp;</p>
   				<p><c:out value="${accommodation_list[0].checkin_string}" /></p>
   			</div>
   		</div>
   		<div class="checkout">
   			<div>
   				<p>체크아웃 &nbsp;&nbsp;&nbsp;</p>
   				<p><c:out value="${accommodation_list[0].checkout_string}" /></p>
   			</div>
   		</div>
   		
   		<div class="ro_info">
   			<div>
   				<p><c:out value="${room.ro_info}" /></p>
   			</div>
   		</div>
   		
   		<div class="room_button_collection">
   			<!--   {% if (세션아이디가 이호텔의 사장 아이디일때 %} -->
   			<div class="modify_button_and_delete_button">
<!--    			이 호텔의 사장님일때 보여준다 -->
<!-- 				정보 수정 페이지에서 객실 삭제도 가능 -->
				<form action="/stay/room/insert_view" method="post">
			        <input type="hidden" name="ac_id" value="${accommodation_list[0].ac_id}">
			        <button type="submit" class="modify_button" onclick="location.href='/stay/room/modify_and_delete_view?room_num=${room.room_num}'">
			        	정보 수정
			        </button>
			    </form>
   			</div>
<!--    		{% else %} -->
   			<div class="booking_button_div">
<!--    		평소에는 객실 예약 버튼을 보여준다 -->
   				<button class="booking_button" onclick="location.href=''">객실 예약</button>
   			</div>
<!--    		{% endif %} -->
   		</div>
   		
   	</div>
   	
   	
   	
   	
   	
   	

   	
</body>
</html>

