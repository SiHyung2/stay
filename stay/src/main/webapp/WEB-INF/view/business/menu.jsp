<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String sessionId = (String) session.getAttribute("sessionId");
	System.out.println("sessionId: " + sessionId); // 콘솔에 출력
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet"> 
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand text-dark" href="main">Stay</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ml-auto">
				<c:choose>
					<c:when test="${empty sessionScope.sessionId}">
						<li class="nav-item active"><a class="nav-link"
							href="#" style="margin-right: 5px; color: black;">회원가입</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="#" style="margin-right: 5px; color: black;">지도검색</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="#" style="margin-right: 5px; color: black;">로그인</a></li>
					</c:when>
					<c:otherwise>
						<c:if test="${sessionScope.sessionTypeCode eq '1'}">
							<li class="nav-item active"><a class="nav-link"
								href="#"
								style="margin-right: 5px; color: black;">예약 확인</a></li>
						</c:if>
											
						<c:if test="${sessionScope.sessionTypeCode eq '2'}">
							<li class="nav-item active"><a class="nav-link"
								href="#" style="margin-right: 5px; color: black;">사업자 정보</a></li>
						</c:if>
						
						<li style="padding-top: 7px; color: white">[${sessionScope.sessionId}님]</li>
						<li class="nav-item active"><a class="nav-link"
							href="#"
							style="margin-right: 5px; color: black;">로그아웃</a></li>
							
					</c:otherwise>
				</c:choose>
            </ul>
    </div>
  </div>
</nav>
</body>
</html>
