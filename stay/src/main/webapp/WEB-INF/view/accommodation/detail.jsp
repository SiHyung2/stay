<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
		$('.room_view_button').click(function() {
			$('.accommodation_view').hide();
// 			$('.accommodation_view').hide().filter(this.hash).fadeIn();
			$('.review_view a').removeClass('active');
			$(this).addClass('active');
			return false;
		}).filter(':eq(0)').click();
	});
	</script>
</head>




<body>
	<div class="container">
		<header class="header_container">
			<div class="accommodation_image"></div>
            <div class="accommodation_content">
<!--             	accommodation_list 은 배열이므로 첫번째 것을 가져온다. -->
<!--             	첫번째 것을 가져오는 이유는 두번째것이 없을 수도 있기 때문이다 -->
                <div class="accommodation_title">
                	<c:out value="${accommodation_list[0].ac_title}" />
                </div>
                <div class="accommodation_information">
                	<c:out value="${accommodation_list[0].ac_info}" />
                </div>
                <div class="accommodation_date">
                	checkin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" id="checkin" class="date_input" name="checkin"/><br>
                	checkout&nbsp;&nbsp;&nbsp;<input type="date" id="checkout" class="date_input" name="checkout"/>
                	
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
				<button id="room_view_button" onclick="location.href=''">객실</button>
				<button id="review_view_button" onclick="location.href=''">리뷰</button>
			</div>
		</header>
		
		<section class="section_container">
			<!-- 이제 테이블로 만들고 체크인, 체크아웃을 문자열로 만들면 될거같다 -->
			<table class="accommodation_view">
				<c:forEach items="${accommodation_list}" var="accommodation">
					<tr>
						<td class="ac_image">ac_image</td>
						<td class="room_title"><c:out value="${accommodation.ro_name}"/></td>
						<td class="ro_basic_and_max">
							최소 <c:out value="${accommodation.ro_basic_count}"/>인
							최대 <c:out value="${accommodation.ro_max_count}"/>인
						</td>
						<td class="ro_check">
							체크인&nbsp; <c:out value="${accommodation.checkin}"/>
							체크아웃      <c:out value="${accommodation.checkout}"/>
						</td>
						<td class="ro_price">
							<h3><c:out value="${accommodation.room_price}"/>원</h3>
						</td>
						<td class="button">
							<button>예약하기</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="review_view">리뷰 - 뷰</div>
		</section>
	</div>
</body>
</html>