<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>숙소 목록</title>
</head>
<body>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>숙소 ID11</th>
                <th>이메일 정보</th>
                <th>숙소 이름</th>
                <th>숙소 타입(카테고리)</th>
                <th>숙소 주소</th>
                <th>숙소 정보</th>
                <th>체크인 (Date 타입)(뭐지 이건?)</th>
                <th>체크아웃 (Date 타입)</th>
                <th>사업자 이름</th>
            </tr>
        </thead>

		<c:out value="1115" />
<%-- 		${page} --%>
        <c:forEach items="${accommodationlist}" var="accommodation">
            <tr>
                <td><c:out value="${accommodation.ac_id}" /></td>
<!--                 숙소 목록에서 한 숙소의 모든방을 보여주는 상세페이지로 이동한다 -->
<%--                 <td><a href="/stay/room/detail?ac_id=${accommodation.ac_id}"><c:out value="${accommodation.email_id}" /></a></td> --%>
                <td><c:out value="${accommodation.ac_title}" /></td>
                <td><c:out value="${accommodation.ac_type}" /></td>
                <td><c:out value="${accommodation.ac_address}" /></td>
                <td><c:out value="${accommodation.ac_info}" /></td>
                <td><c:out value="${accommodation.checkin}" /></td>
                <td><c:out value="${accommodation.checkout}" /></td>
                <td><c:out value="${accommodation.bu_name}" /></td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>














