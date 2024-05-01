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
    width: 200px;
    height: 150px;
}
</style>
</head>
<body>
	<%@include file="./menu.jsp"%>
	<div style="padding: 10px;"></div>
	<%@include file="./search.jsp"%>  
				
				
				
				
				<div class="main_box rounded mt-3">
				<h4 class="main_head_text">⚡️ 클릭해서 원하는 숙소를 찾아보세요!</h4>
					<div class="row">
						<div class="image-container">
							<a href="hotel.html"> <img src="../resources/img/main_test.jpg" alt="호텔">
								<div class="image-text">호텔</div>
							</a>
						</div>

						<div class="image-container">
							<a href="motel.html"> <img src="../resources/img/main_test.jpg" alt="모텔">
								<div class="image-text">모텔</div>
							</a>
						</div>

						<div class="image-container">
							<a href="resort.html"> <img src="../resources/img/main_test.jpg" alt="리조트">
								<div class="image-text">리조트</div>
							</a>
						</div>

						<div class="image-container">
							<a href="pension.html"> <img src="../resources/img/main_test.jpg" alt="펜션">
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
