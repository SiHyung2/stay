<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review List</title>
<style>
table {
	border-spacing: 10px;
}

input[type="submit"] {
	background-color: blue;
	color: white;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 5px;
}

input[type="submit"]:hover {
	background-color: darkblue;
}
</style>
</head>
<body>
	<%@ include file="../business/main.jsp"%>

	<!--     테스트용 -->
	<%--     ${replys.reply_Content} --%>
    <table align="center" width="50%">
        <c:forEach items="${reviews}" var="review">
            <tr>
                <td><c:out value="${review.email_Id}"/> - Room <c:out value="${review.room_Num}" /></td>
                <td></td>
                <td style="text-align: right;"><c:out value="${review.update_Date}" /></td>
            </tr>
            <tr>
                <td><strong><c:out value="${review.content}" /></strong></td>
            </tr>
            
<!--             for문 넣고  -->
<!--             0~마지막까지 rev_num을 조건문으로 비교하며 찾고 -->
<!--             찾은 인덱스의 content를 출력 -->
            
    <c:forEach items="${replys}" var="reply">
            <c:if test="${review.rev_Num == reply.rev_Num}">
                <tr>
                    <td style="padding-left: 20px;">
                        &#10145; <strong><c:out value="${reply.reply_Content}" /></strong>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
            
    
       
            
            <tr>
                <td colspan="3">
                    <form id="replyForm" action="/stay/review/add" method="POST">
                        <textarea name="reply_Content" rows="3" cols="50" placeholder="답글을 입력하세요..."></textarea>
                        <br>
                        <input type="hidden" name="rev_Num" value="${review.rev_Num}" />
                        <input type="submit" value="답글 달기">
                    </form>
                </td>
            </tr>
            <tr>
                <td colspan="2">&nbsp;</td>
            </tr>
        </c:forEach>
    </table>


	<script>
        document.addEventListener("DOMContentLoaded", () => {
            const replyForms = document.querySelectorAll('form[id^="replyForm"]');
            replyForms.forEach(form => {
                form.addEventListener('submit', (event) => {
                    event.preventDefault();
                    const replyContent = form.querySelector('textarea[name="replyContent"]').value;
                    const revNum = form.querySelector('input[name="revNum"]').value;
                    const xhr = new XMLHttpRequest();
                    xhr.open('POST', form.action);
                    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    xhr.onload = () => {
                        if (xhr.status === 200) {
                            alert('답글이 달렸습니다!');
                            window.location.reload();  // 페이지를 새로고침하여 변경 사항 반영
                        } else {
                            alert('답글 달기에 실패했습니다.');
                        }
                    };
                    xhr.send(`replyContent=${encodeURIComponent(replyContent)}&revNum=${revNum}`);
                });
            });
        });
    </script>
</body>

</html>
