<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 목록</title>
</head>
<body>
	<h1>detail_of_detail test...</h1>
    <table class="table table-bordered">
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
                <td><c:out value="${room.ro_type}" /></td>
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

