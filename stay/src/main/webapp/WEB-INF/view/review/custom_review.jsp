<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<%@include file="../menu.jsp"%>

<body>



    <h2>리뷰 작성</h2>

<form id="reviewForm" action="/stay/review/addReview" method="POST">
    <label for="content">리뷰 내용:</label><br>
    <textarea id="content" name="content" rows="5" cols="50" required></textarea><br><br>
    
    <input type="submit" value="리뷰 작성">
</form>



</body>
</html>







