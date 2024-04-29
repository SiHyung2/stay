<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
					<table class="table table-bordered" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>#번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
							</tr>
						</thead>
						
						<c:forEach items="${bookings}" var="booking">
							<tr>
								<td><c:out value="${booking.bo_num}" /></td>
								
								<td>
<%-- 									<a href='/board/get?bno=<c:out value="${board.bno}"/>'> --%>
<%-- 										<c:out value="${board.title}" /> --%>
									<a class='move' href='<c:out value="${booking.bo_num}"/>'>
										<c:out value="${booking.ro_type}" />
									</a>
								</td>

								<td><c:out value="${booking.status}" /></td>
<%-- 								<td><fmt:formatDate pattern="yyyy-MM-dd" --%>
<%-- 										value="${booking.checkout_day}" /></td> --%>
<%-- 								<td><fmt:formatDate pattern="yyyy-MM-dd" --%>
<%-- 										value="${booking.reg_date}" /></td> --%>
							</tr>
						</c:forEach>
					</table>  
</body>
</html>