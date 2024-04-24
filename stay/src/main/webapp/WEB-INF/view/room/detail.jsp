<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 목록</title>
</head>
<body>
	<h1>detail test...</h1>
    <table class="table table-bordered">
    <a href="/stay/room/list">목록으로</a>
        <thead>
            <tr>
                <th>#번호</th>
                <th>숙소 ID</th>
                <th>객실명</th>
                <th>기본 인원 수</th>
                <th>최대 인원 수</th>
                <th>객실 정보</th>
                <th>객실 수</th>
            </tr>
        </thead>
        
        <c:forEach items="${roomlist}" var="room">
            <tr>
                <td><a href="/stay/room/detail_of_detail?ac_id=${room.ac_id}&ro_type=${room.ro_type}"><c:out value="${room.ro_type}" /></a></td>
                <td><c:out value="${room.ac_id}" /></td>
                <td><c:out value="${room.ro_name}" /></td>
                <td><c:out value="${room.ro_basic_count}" /></td>
                <td><c:out value="${room.ro_max_count}" /></td>
                <td><c:out value="${room.ro_info}" /></td>
                <td><c:out value="${room.ro_count}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

