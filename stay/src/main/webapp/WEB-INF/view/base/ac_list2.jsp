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
                <th>이름</th>
                <th>정보</th>
                <th>주소</th>
            </tr>
        </thead>

<%-- 		<c:out value="1115" /> --%>
		
        <c:forEach items="${accommodation_list}" var="accommodation">
            <tr>
            	<td><a href="/stay/accommodation/detail?ac_id=${accommodation.ac_id}"><c:out value="${accommodation.ac_title}" /></a></td>
            	<td><c:out value="${accommodation.ac_info}" /></td>
            	<td><c:out value="${accommodation.ac_address}" /></td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>

















