<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.horizontal-divs {
	display: inline-block;
}

.image-container img {
	vertical-align: middle;
	max-width: 100%; /* 이미지의 최대 너비를 100%로 설정하여 부모 요소에 맞춥니다. */
	height: auto;
}
 
.image-text {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	padding: 10px; /* 텍스트 주변 여백 설정 */
	border-radius: 5px; /* 텍스트 상자 모서리를 둥글게 만듭니다. */
	color: black;
	font-size: 40px;
}

.image-container a {
	display: inline-block;
	position: relative;
	margin: 20px 0px; /* 이미지 간의 가로 방향 마진을 설정합니다. */
	margin-left: 120px;
}
}
</style>
</head>
<body>
	<%@include file="../menu.jsp"%>
	<%@include file="./search.jsp"%>




	<div class="main_box rounded mt-4">
		<h4 class="main_head_text">⚡️ 클릭해서 원하는 숙소를 찾아보세요!</h4>
		<div class="row">
			<div class="image-container">
				<a href="hotel.html"> <img src="../resources/img/main_test.jpg"
					alt="호텔" style="max-width: 650px; max-height: 200px;">
					<div class="image-text">호텔</div>
				</a>
			</div>

			<div class="image-container">
				<a href="motel.html"> <img src="../resources/img/main_test.jpg"
					alt="모텔" style="max-width: 650px; max-height: 200px;">
					<div class="image-text">모텔</div>
				</a>
			</div>

			<div class="image-container">
				<a href="resort.html"> <img src="../resources/img/main_test.jpg"
					alt="리조트" style="max-width: 650px; max-height: 200px;">
					<div class="image-text">리조트</div>
				</a>
			</div>

			<div class="image-container">
				<a href="pension.html"> <img
					src="../resources/img/main_test.jpg" alt="펜션" style="max-width: 650px; max-height: 200px;">
					<div class="image-text">펜션</div>
				</a>
			</div>
		</div>
	</div>

	</div>
	</div>
	</div>
</body>
</html>
