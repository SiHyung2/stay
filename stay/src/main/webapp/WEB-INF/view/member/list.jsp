<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

<%@include file="../menu.jsp"%>

<body id="page-top"> 

						<table class="table table-bordered" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>member.email_Id</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
							</tr>
						</thead>
						<c:forEach items="${members}" var="member">
							<tr>
								<td><c:out value="${member.email_id}" /></td> 

								<td>

									
									<a class='move' href='<c:out value="${member.email_id}"/>'>
										<c:out value="${member.password}" />
									</a>
								</td>

								<td><c:out value="${member.name}" /></td>
								<td><c:out value="${member.tel}" /></td>
								<td><c:out value="${member.type_code}" /></td>
							</tr>
						</c:forEach>
					</table>

</body>
</html>







