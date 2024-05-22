<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="<c:url value="/resources/css/accommodation_detail.css" />" rel="stylesheet" type="text/css"> 
	<!--탭메뉴 제작중... -->
	
	<script>
	$(function() {
		<!-- 만약 세션에 일치하는 ac_id와 숙소의 ac_id가 일치하면 비즈니스 뷰를 보여주는 함수 -->
		var member_email_id= $('.business_view').data('member_email');
		var session_email_id= $('.business_view').data('session_email_id');
	    $('.business_view').hide();
	    $('.review_view').hide();	
	    if (member_email_id === session_email_id) {
//	         alert("해당 숙소의 주인이므로 출력");
	        $('.business_view').show();
	    }
	});
	
	function switchToReviewView() {
	    $('.room_view').hide(); 
	    $('.review_view').fadeIn(); 
// 	    $('.room_view_button').removeClass('active'); 
	    $('#review_view_button').addClass('active'); 
	}
	
	function switchToRoomView() {
	    $('.review_view').hide(); 
	    $('.room_view').fadeIn(); 
// 	    $('.review_view_button').removeClass('active'); 
	    $('#review_view_button').addClass('active'); 
	}
	
	</script>
</head>

<body>
	<%@include file="../menu.jsp"%>
	<div class="_container">
		<header class="header_container">
			<div class="accommodation_image">ac_img</div>
            <div class="accommodation_content">
<!--             	accommodation_list 은 배열이므로 첫번째 것을 가져온다. -->
<!--             	첫번째 것을 가져오는 이유는 두번째것이 없을 수도 있기 때문이다 -->
                <div class="accommodation_title">
                	<c:out value="${accommodation_list[0].ac_title}" />
                </div>
                <div class="accommodation_information_address">
                	<p>
                		<c:out value="${accommodation_list[0].ac_info}" />
                	</p>
                	<p>
                		<c:out value="${accommodation_list[0].ac_address}" />
                	</p>
                </div>
                <div class="accommodation_date">
                	checkin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=text id="checkin" class="date_input" name="checkin"/><br>
                	checkout&nbsp;&nbsp;&nbsp;<input type="text" id="checkout" class="date_input" name="checkout"/>
                	
                </div>
                <div class="date_button_div">
                	<button class="date_button" onclick="location.href='http://localhost:8085/stay/accommodation/detail?ac_id=<c:out value="${accommodation_list[0].ac_id}" />'">날짜 변경</button>
                </div>
            </div>
            <script>
            	let today = new Date();
            	if(document.getElementById('checkin').value == ""){
            		document.getElementById('checkin').value= today.toISOString().slice(0, 10);
            	}
			  
			  	document.getElementById('checkout').value= new Date(today.setDate(today.getDate() + 1)).toISOString().slice(0, 10);
			</script>
			<div class="room_review_tab">
				<button id="room_view_button" class="room_view_button" onclick="switchToRoomView()">객실</button>
				<button id="review_view_button" class="review_view_button" onclick="switchToReviewView()">리뷰</button>
			</div>
		</header>
		
		<section class="section_container">
			<!-- 이제 테이블로 만들고 체크인, 체크아웃을 문자열로 만들면 될거같다 -->
			<table class="room_view">
				<c:forEach items="${accommodation_list}" var="accommodation">
<!-- 					1번째 줄 -->
					<tr>
						<td  rowspan='3' class="ac_image">
							ro_image
						</td>
						<td class="room_title">
							<c:out value="${accommodation.ro_name}"/>
						</td>
						<td class="room_button" rowspan='3'>
							<button onclick="location.href='/stay/room/detail_of_detail?ac_id=${accommodation.ac_id}&room_num=${accommodation.room_num}'" >
								방 정보
							</button>
							<br/>
							<button  onclick="location.href='/stay/booking/booking_insertview?email_id=${sessionScope.LoginVO.email_id}&ac_id=${accommodation.ac_id}&room_num=${accommodation.room_num}'">
								예약하기
							</button>
						</td>
					</tr>
<!-- 					2번째 줄 -->
					<tr>
<!-- 						<td>     -->
<!-- 							룸 이미지 -->
<!-- 						</td> -->
						<td class="ro_basic_and_max_and_checkin_checkout">
							<div>
								기준 <c:out value="${accommodation.ro_basic_count}"/>인,
								최대 <c:out value="${accommodation.ro_max_count}"/>인
							</div>
							<br>
							<div>
								입실 <c:out value="${accommodation.checkin}"/>
								/퇴실 <c:out value="${accommodation.checkout}"/>
							</div>
							
						</td>
<!-- 						<td> -->
<!-- 							버튼 -->
<!-- 						</td> -->
					</tr>
<!-- 					3번째 줄 -->
					<tr class="tr_3rd">
<!-- 						<td> -->
<!-- 							룸 이미지 -->
<!-- 						</td> -->
						<td class="ro_price">
							가격 : 
							<span><c:out value="${accommodation.room_price}"/>원</span>
						</td>
						<td>
<!-- 							버튼 -->
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="review_view">리뷰 - 뷰</div>
		</section>
		
		
<!-- 		해당 숙소의 ac_id와 email_id에 입력된 값의 ac_id와 같으면 출력한다 (제이 쿼리 활용)-->
		<div class="business_view" data-member_email="${accommodation_list[0].email_id}" data-session_email_id="${sessionScope.LoginVO.email_id}">
			<form action="/stay/room/insert_view" method="post">
		        <!-- 여기에 ac_id를 hidden으로 전달 -->
		        <input type="hidden" name="ac_id" value="${accommodation_list[0].ac_id}">
		        <button type="submit" class="btn btn-info w-100">방 추가 View</button>
		    </form>
			
			<form action="/stay/accommodation/modify_and_delete_view" method="post">
		        <!-- 여기에 ac_id를 hidden으로 전달 -->
		        <input type="hidden" name="email_id" value="${accommodation_list[0].email_id}">
		        <input type="hidden" name="ac_id" value="${accommodation_list[0].ac_id}">
		        <button type="submit" class="btn btn-info w-100">숙소 수정 View</button>
		    </form>
			
			<form action="/stay/accommodation/insert_view" method="post">
		        <!-- 여기에 ac_id를 hidden으로 전달 -->
		        <input type="hidden" name="email_id" value="${accommodation_list[0].email_id}">
		        <button type="submit" class="btn btn-info w-100">숙소 추가 View</button>
		    </form>
	    </div>
	    




	
</body>
</html>