<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>숙소 목록</title>
</head>
<body>
    <%@include file="../menu.jsp"%>
    <%@include file="./business_menu.jsp"%>
    <div class="container">
     	<button id="addition_accommodation_link" class="btn btn-info btn-lg mb-5 mt-3">숙소 등록</button>
	    <table class="table table-bordered">
	        <thead>
	            <tr>
<!-- 	                <th>숙소 ID</th> -->
<!-- 	                <th>이메일</th> -->
	                <th>숙소 이름</th>
	                <th>카테고리</th>
	                <th>숙소 주소</th>
	                <th>숙소 정보</th>
	                <th>체크인</th>
	                <th>체크아웃</th>
	                <th>사업체 이름</th>
	                <th>숙소 수정</th>
	                <th>이동</th>
	            </tr>
	        </thead>
			
			
	        <c:forEach items="${accommodationlist}" var="accommodation">
	            <tr>
<%-- 	                <td><a id=""><c:out value="${accommodation.ac_id}" /></a></td> --%>
	<!--                 숙소 목록에서 한 숙소의 모든방을 보여주는 상세페이지로 이동한다 -->
<%-- 	                <td><c:out value="${accommodation.email_id}" /></td> --%>
	                <td><c:out value="${accommodation.ac_title}" /></td>
	                <td><c:out value="${accommodation.ac_type}" /></td>
	                <td><c:out value="${accommodation.ac_address}" /></td>
	                <td><c:out value="${accommodation.ac_info}" /></td>
	                <td><c:out value="${accommodation.checkin}" /></td>
	                <td><c:out value="${accommodation.checkout}" /></td>
	                <td><c:out value="${accommodation.bu_name}" /></td>
	                <td>
						<form action="/stay/accommodation/modify_and_delete_view" method="post">
					        <!-- 여기에 ac_id를 hidden으로 전달 -->
					        <input type="hidden" name="email_id" value="${accommodation.email_id}">
					        <input type="hidden" name="bu_name" value="${accommodation.bu_name}"> 
					        <input type="hidden" name="ac_id" value="${accommodation.ac_id}">
					        <button type="submit" class="btn btn-success btn-lg">수정</button>
					    </form>
					</td>
					<td>
						<button class="accommodation-button btn btn-primary btn-lg" 
			                        onclick="location.href='/stay/accommodation/detail?ac_id=${accommodation.ac_id}'">
			                    	숙소로
			             </button>
					</td>
	            </tr>
	        </c:forEach>
	    </table>
	</div>
    
    
<!--     반드시 business_menu에 제이쿼리를 넣어야한다 -->
<!--     아니면 에러가 나는 현상 발견 -->
<!-- 	숙소 등록(#addition_accommodation_link) 제이쿼리는 business_menu에 있다!!! -->
</body>
</html>














