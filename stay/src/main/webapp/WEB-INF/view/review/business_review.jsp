<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
/* 테이블 간격을 조정하기 위한 CSS */
table {
	border-spacing: 10px; /* 테이블의 셀 간격을 10px로 설정 */
}
</style>
</head>
<body>
    <%@include file="../business/main.jsp"%>




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

</body>
</html>
