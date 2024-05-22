<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="<c:url value="/resources/css/accommodation_detail.css" />" rel="stylesheet" type="text/css"> 
	<!--탭메뉴 제작중... -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	$(function() {
		$('.review_view').hide();		
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
	
<!-- 	리뷰 스타일 -->
	<style>
		    /* CSS styles for the submit button */
		    input[type="submit"] {
		        background-color: blue; /* Set the background color to blue */
		        color: white; /* Set text color to white */
		        border: none; /* Remove default border */
		        padding: 10px 20px; /* Add padding for better appearance */
		        cursor: pointer; /* Change cursor to pointer on hover */
		        border-radius: 5px; /* Apply border radius for rounded corners */
		    }
		 
		    /* Hover effect for the submit button */
		    input[type="submit"]:hover {
		        background-color: darkblue; /* Change background color on hover */
		    }
		</style>
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
							<button  onclick="location.href='#'">
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
								최소 <c:out value="${accommodation.ro_basic_count}"/>인,
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
			<div class="review_view">
			
					    <table align="center" width="50%">
		        <c:forEach items="${reviews}" var="review">
		
		            <tr>
		                <td><c:out value="${review.email_Id}" /> -room<c:out value="${review.room_Num}" /></td>
		                <td></td>
		                <td style="text-align: right;"><c:out value="${review.update_Date}" /></td>
		            </tr>
		            <tr>
		                <td><strong><c:out value="${review.content}" /></strong></td>
		            </tr>
		            <tr>
		                <td colspan="3">
		                
		
		<form action="/reply/${review.rev_Num}" method="POST">
		    <textarea name="replyContent" rows="3" cols="50" placeholder="답글을 입력하세요..."></textarea>
		    <br>
		    <input type="submit" value="답글 달기">
		</form>
		
		                </td>
		            </tr>
		            <tr>
		                <td colspan="2">&nbsp;</td>
		                <!-- 리뷰 간의 간격을 위한 빈 행 추가 -->
		            </tr>
		        </c:forEach>
		    </table>
			
			
			</div>
		</section>
		
		<p>숙소 추가할때 사업자 아이디를 가지고있는지 확인하는 쿼리 추가 필요</p>
		<p>방 추가할때 사업자 아이디와 일치하는지 확인하는 쿼리 추가 필요</p>
		
		<form action="/stay/room/insert_view" method="post">
	        <!-- 여기에 ac_id를 hidden으로 전달 -->
	        <input type="hidden" name="ac_id" value="${accommodation_list[0].ac_id}">
	        <button type="submit" class="btn btn-warning w-25 h-25">방 추가 View</button>
	    </form>
		
		<form action="/stay/accommodation/modify_and_delete_view" method="post">
	        <!-- 여기에 ac_id를 hidden으로 전달 -->
	        <input type="hidden" name="email_id" value="${accommodation_list[0].email_id}">
	        <input type="hidden" name="bu_name" value="${accommodation_list[0].bu_name}"> 
	        <input type="hidden" name="ac_id" value="${accommodation_list[0].ac_id}">
	        <button type="submit" class="btn btn-danger w-25 h-25">숙소 수정 View</button>
	    </form>
		
		<form action="/stay/accommodation/insert_view" method="post">
	        <!-- 여기에 ac_id를 hidden으로 전달 -->
	        <input type="hidden" name="email_id" value="${accommodation_list[0].email_id}">
	        <input type="hidden" name="bu_name" value="${accommodation_list[0].bu_name}"> 
	        <button type="submit" class="btn btn-success w-25 h-25">숙소 추가 View</button>
	    </form>
	    
	    
	</div>
	
	
	
	
	
</body>
</html>