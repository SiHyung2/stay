<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<style>
.container-wrapper {
    position: relative;
    width: 100%;
    height: auto; /* 높이를 자동으로 설정하여 이미지와 내용에 맞게 조절됩니다. */
}

.container {
    position: absolute; /* 이미지 위에 절대 위치로 배치됩니다. */
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%); /* 수직, 수평으로 가운데 정렬됩니다. */
    z-index: 1; /* 이미지 위에 나오도록 설정됩니다. */
    width: 100%;
    max-width: 500px; /* 최대 너비 설정 */
    border: 1px solid black;
}

.image {
    width: 100%; 
    height: 350px; /* 높이를 자동으로 설정하여 이미지 비율을 유지합니다. */
    object-fit: cover; /* 이미지가 화면을 가득 채우도록 설정합니다. */
}

.container>* {
/*     border: 1px solid black; */
    display: flex;
    align-items: center; /* 수직 가운데 정렬 */
    justify-content: center; /* 수평 가운데 정렬 */
    font-size: 20px; /* 글씨 크기 조정 */
}


.container {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr; /* 동일한 너비의 4개의 열 */
    grid-template-rows: auto auto; /* 자동으로 높이를 설정하여 내용에 맞게 조절됩니다. */
    background-color: white;
    max-width: 1000px;
    max-height: 500px;
    height: auto; /* 컨테이너 높이를 자동으로 설정하여 내용에 맞게 조절됩니다. */
    grid-row-gap: 20px;
    padding-top: 15px; /* 위쪽 공백 설정 */
    padding-bottom: 15px; /* 아래쪽 공백 설정 */
}

.input1, .input2, .input3, .input4 {
    display: flex;
    align-items: center; /* 수직 가운데 정렬 */
    justify-content: center; /* 수평 가운데 정렬 */
}
</style>
</head>
<body>
    <div class="container-wrapper">
        <img src="../resources/img/main_bg.jpg" class="image" alt="Background Image">
        <div class="container">
            <div style="font-size: 24px;">호텔</div>
            <div style="font-size: 24px;">모텔</div>
            <div style="font-size: 24px;">펜션</div>
            <div style="font-size: 24px;">리조트</div>
			
			<form role="form" action="/stay/base/ac_list" method="GET">
	            <div class="input1">
	                <input type='date' id="checkin" min="${today }" value="${today }"
	                    class="main_checkin_1" name="checkin" onchange="dateChk()" required>
	            </div>
	            <div class="input2">
	                <input type='date' id="checkout" min="${tomorrow }"
	                    value="${tomorrow }" class="main_checkout_1" name="checkout"
	                    onchange="dateChk()" required>
	            </div>
	            <div class="input3">
	                <input type='search' class='main_search_text' placeholder='지역,숙소명'
	                    name="ac_title" required>
	            </div>
	            <div class="input4">
	                <div class="input4">
	                    <button type='submit' class="btn btn-primary">STAY</button>
	                </div>
	            </div>
	         </form>
        </div>
    </div>
</body>
</html>
