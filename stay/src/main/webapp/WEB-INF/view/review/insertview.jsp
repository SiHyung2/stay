<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%@include file="../menu.jsp"%>

</head>
<!-- <body> -->


<!-- 	<form role="form" action="/review/insert" method="post"> -->


<!-- 		<div class="form-group"> -->
<!-- 			<label>rev_Num</label> <input class="form-control" name='rev_Num'>  -->
<!-- 		</div> -->

<!-- 		<div class="form-group"> -->
<!-- 			<label>bo_Num</label> <input class="form-control" name='bo_Num'> -->
<!-- 		</div> -->

<!-- 		<div class="form-group"> -->
<!-- 			<label>ac_Title</label><input class="form-control" name='ac_Title'> -->
<!-- 		</div> -->

<!-- 		<div class="form-group"> -->
<!-- 			<label>room_Num</label> <input class="form-control" name='room_Num'></input> -->
<!-- 		</div> -->

<!-- 		<div class="form-group"> -->
<!-- 			<label>content</label> <input class="form-control" name='content'></input> -->
<!-- 		</div> -->

<!-- 		<div class="form-group" style="display: none;"> -->
<!-- 			<label>review_Date</label> <input type="date" -->
<!-- 				class="form-control"name="review_Date"> -->
<!-- 		</div> -->

<!-- 		<div class="form-group" style="display: none;"> -->
<!-- 			<label>Update_Date</label> <input type="date" -->
<!-- 				class="form-control"  name="update_Date"> -->
<!-- 		</div> -->


<!-- 		<button type="submit" class="btn btn-default">Submit Button</button> -->
<!-- 	</form> -->




<!-- </body> -->




<body>

 <table>

        <c:forEach items="${reviews}" var="review">
            <tr>
                <td>${review.email_Id} - room${review.room_Num}</td>
                <td></td>
                <td style="text-align: right;">${review.update_Date}</td>
            </tr>
            <tr>
                <td><strong>${review.content}</strong></td>
            </tr>
        </c:forEach>
    </table>

    <h2>리뷰 작성</h2>

<form id="reviewForm" action="/stay/review/review" method="GET">
    <textarea name="reviewContent" rows="5" cols="50" placeholder="리뷰를 입력하세요..."></textarea>
    <input type="hidden" name="ro_num" value="${ro_num}">
    <input type="submit" value="리뷰 작성">
</form>

</body>
</html>