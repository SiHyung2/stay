<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="<c:url value="/resources/css/accommodation_detail.css" />" rel="stylesheet" type="text/css"> 
<!--     <link rel="stylesheet" href="./accommodation.css"> -->
</head>

<body> 
	<div class="container">
		<header class="header_container">
			<div class="accommodation_image"></div>
            <div class="accommodation_content">
                <div class="accommodation_title">
                	<c:out value="${accommodation_detail.ro_name}" />accommodation_title
                </div>
                <div class="accommodation_information">
                	<c:out value="${accommodation_detail.ro_name}" />accommodation_information
                </div>
                <div class="accommodation_date">
                	checkin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" id="checkin" class="date_input" name="checkin"/><br>
                	checkout&nbsp;&nbsp;&nbsp;<input type="date" id="checkout" class="date_input" name="checkout"/>
                	
                </div>
                <div class="date_button_div">
                	<button class="date_button">날짜 변경</button>
                </div>
            </div>
            <script>
            	let today = new Date();
            	if(document.getElementById('checkin').value == ""){
            		document.getElementById('checkin').value= today.toISOString().slice(0, 10);
            	}
			  
			  	document.getElementById('checkout').value= new Date(today.setDate(today.getDate() + 1)).toISOString().slice(0, 10);
			</script>
		</header>
		
		<div class="room_review_tab">room_review_tab4</div>
		<div class="ac_image">ac_image</div>
		<div class="room_title">room_title</div>
		<div class="ro_basic_and_max">ro_basic_and_max</div>
		<div class="ro_check">ro_check</div>
		<div class="ro_price">ro_price</div>
		<div class="button">button</div>
	</div>
</body>
</html>