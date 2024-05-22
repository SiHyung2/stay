<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>


	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">


			<c:choose>
				<c:when test="${empty sessionScope.LoginVO.email_id}">
					<a class="navbar-brand text-dark" href="/stay/base/main">Stay</a>
				</c:when>

				<c:otherwise>
					<c:if test="${sessionScope.LoginVO.type_code eq '1'}">
						<a class="navbar-brand text-dark" href="/stay/base/main">Stay</a>
					</c:if>
					<c:if test="${sessionScope.LoginVO.type_code eq '2'}">

						<a class="navbar-brand text-dark" href="/stay/business/main">Stay</a>
					</c:if>
				</c:otherwise>
			</c:choose>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<c:choose>
						<c:when test="${empty sessionScope.LoginVO.email_id}">
							<li class="nav-item active"><a class="nav-link"
								href="/stay/member/joinview"
								style="margin-right: 5px; color: black;">회원가입</a></li>
							<li class="nav-item active"><a class="nav-link" href="#"
								style="margin-right: 5px; color: black;">지도검색</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="/stay/member/loginview"
								style="margin-right: 5px; color: black;">로그인</a></li>
						</c:when>

						<c:otherwise>
							<c:if test="${sessionScope.LoginVO.type_code eq '1'}">

								<form action="/stay/booking/check" method="post">
									<input type="hidden" name="email_id"
										value="${sessionScope.LoginVO.email_id}">
									<button type="submit" class="nav-link"
										style="color: black; font-size: 15px; margin-right: 22px; background: none; border: none; padding: 0;">예약
										확인</button>
								</form>
								
								<form action="" method="post">
									<input type="hidden" name="email_id"
										value="${sessionScope.LoginVO.email_id}">
									<button type="submit" class="nav-link"
										style="color: black; font-size: 15px; margin-right: 22px; background: none; border: none; padding: 0;">지도 검색</button>
								</form>

							</c:if>

							<c:if test="${sessionScope.LoginVO.type_code eq '2'}">
								<form action="" method="post">
									<input type="hidden" name="email_id"
										value="${sessionScope.LoginVO.email_id}">
									<button type="submit" class="nav-link"
										style="color: black; font-size: 15px; margin-right: 22px; background: none; border: none; padding: 0;">사업자 정보</button>
								</form>
							</c:if>

							
							<form action="/stay/member/logout" method="post">
									<input type="hidden" name="email_id"
										value="${sessionScope.LoginVO.email_id}">
									<button type="submit" class="nav-link"
										style="color: black; font-size: 15px; background: none; border: none; padding: 0;">로그아웃</button>
								</form>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>
