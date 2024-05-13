
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>





</head>
<body>

	<%@include file="../business/main.jsp"%>





	<table align="center" width="50%">
	 
	 
	 
	 

	
		<c:forEach items="${reviews}" var="review">
			
			
			<tr> 
			<td><c:out value="${review.ac_Title}" /></td>
			<td><c:out value="${review.room_Num}"/>호</td>
			</tr>
			<tr>
			<td><c:out value="${review.content}" /></td>
			<td><c:out value="${review.review_Date}" /></td>
						</tr>
						<tr></tr>
		</c:forEach>
	</table>
</body>
</html>