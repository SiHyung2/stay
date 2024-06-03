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
   				<p><c:out value="${accommodation_list[0].checkin}" /></p>
   			</div>
   		</div>
   		<div class="checkout">
   			<div>
   				<p>체크아웃 &nbsp;&nbsp;&nbsp;</p>
   				<p><c:out value="${accommodation_list[0].checkout}" /></p>
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
				<div class="business_view" data-member_email="${accommodation_list[0].email_id}" data-session_email_id="${sessionScope.LoginVO.email_id}">
					<form action="/stay/room/modify_and_delete_view" method="post">
				        <input type="hidden" name="ac_id" value="${accommodation_list[0].ac_id}">
				        <input type="hidden" name="room_num" value="${room.room_num}">
				        <button type="submit" class="modify_button" onclick="location.href='/stay/room/modify_and_delete_view'"
>				        	정보 수정
				        </button>
				    </form>
				</div>
   			</div>
   			<div class="booking_button_div">
   				<button class="booking_button" onclick="location.href=''">객실 예약</button>
   			</div>
   		</div>
   		
   	</div>
   	
   	
   	
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- 만약 세션에 일치하는 ac_id와 숙소의 ac_id가 일치하면 비즈니스 뷰를 보여주는 함수 -->
<script>
$(function() {
// 	모델로 입력된 이메일 아이디를 가져오는법
	var member_email_id= $('.business_view').data('member_email');
	var session_email_id= $('.business_view').data('session_email_id');
    $('.business_view').hide();
    if (member_email_id === session_email_id) {
//         alert("해당 숙소의 주인이므로 출력");
        $('.business_view').show();
    }
});
</script>


   	
</body>
</html>

