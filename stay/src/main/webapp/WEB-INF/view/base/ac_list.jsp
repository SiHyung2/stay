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
                <th>111</th>
            </tr>
        </thead>

		<c:out value="1115" />
		
        <c:forEach items="${accommodation_list}" var="accommodation">
            <tr>
            	<td><c:out value="${accommodation}" /></td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>














