
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title> 
</head>
<body>

<%@include file="../menu.jsp"%>
<%@include file="../business/business_menu.jsp"%>
<body id="page-top"> 


						<table class="table table-bordered" width="100%" cellspacing="0"> 
						<thead>
							<tr>
								<th>rev_Num</th>
								<th>bo_Num</th>
								<th>ac_Title</th>
								<th>room_Num</th>
								<th>content</th>
								<th>review_Date</th>
								<th>update_Date</th>
								
							</tr>
						</thead>
						<c:forEach items="${reviews}" var="review">
							<tr>
								<td><c:out value="${review.rev_Num}" /></td>

								<td>

									
									<a class='move' href='<c:out value="${review.rev_Num}"/>'>
										<c:out value="${review.bo_Num}" />
									</a>
								</td>

								<td><c:out value="${review.ac_Title}" /></td>
								<td><c:out value="${review.room_Num}" /></td>
								<td><c:out value="${review.content}" /></td>
								<td><c:out value="${review.review_Date}" /></td>
								<td><c:out value="${review.update_Date}" /></td>
							</tr>
						</c:forEach>
					</table>
</body>
</html>