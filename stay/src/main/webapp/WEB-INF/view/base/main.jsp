<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="../menu.jsp"%>
	<%@include file="./search.jsp"%>

	  <div class="section_container">
		<div class="box">
			<div class="image-text">
				<label>호텔</label>
				<img src="../resources/img/main_test.jpg" onclick="location.href='/stay/base/ac_list?ac_type=1&checkin=&checkout=&ac_title=';" alt="호텔">
			</div>
		</div>
		<div class="box">
			<div class="image-text">
				<label>모텔</label>
				<img src="../resources/img/main_test.jpg" onclick="location.href='/stay/base/ac_list?ac_type=2&checkin=&checkout=&ac_title=';" alt="모텔">
			</div>
		</div>
		<div class="box">
			<div class="image-text">
				<label>펜션</label>
				<img src="../resources/img/main_test.jpg" onclick="location.href='/stay/base/ac_list?ac_type=3&checkin=&checkout=&ac_title=';" alt="팬션">
			</div>
		</div>
			
		<div class="box">
			<div class="image-text">
				<label>리조트</label>
				<img src="../resources/img/main_test.jpg" onclick="location.href='/stay/base/ac_list?ac_type=4&checkin=&checkout=&ac_title=';" alt="리조트">
			</div>
		</div>
	</div>
	
	
	
<!-- 	<img src="../resources/img/main_test.jpg" -->
<!-- 					alt="모텔" style="max-width: 650px; max-height: 200px;"> -->

</body>
</html>
