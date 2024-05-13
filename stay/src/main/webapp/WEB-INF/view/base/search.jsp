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
}

.image {
    width: 100%; 
    height: 350px; /* 높이를 자동으로 설정하여 이미지 비율을 유지합니다. */
    object-fit: cover; /* 이미지가 화면을 가득 채우도록 설정합니다. */
}

.container>* {
/*     border: 1px solid black; */
    align-items: center; /* 수직 가운데 정렬 */ 
    justify-content: center; /* 수평 가운데 정렬 */ 
    font-size: 20px; /* 글씨 크기 조정 */
}


.container {
    background-color: white;
/*     max-width: 1000px; */
/*     max-height: 500px; */
/*     height: auto; /* 컨테이너 높이를 자동으로 설정하여 내용에 맞게 조절됩니다. */ */
/*     grid-row-gap: 20px; */
    padding-top: 15px; /* 위쪽 공백 설정 */
    padding-bottom: 15px; /* 아래쪽 공백 설정 */
}

.input1, .input2, .input3, .input4 {
    display: flex;
    align-items: center; /* 수직 가운데 정렬 */
    justify-content: center; /* 수평 가운데 정렬 */
}
</style>


<!-- 라디오 버튼을 직사각형 탭 메뉴로 만드는 스타일시트 -->
<style>
    /* 라디오 버튼을 숨김 */
    .custom-radio input[type="radio"] {
        display: none;
    }
    /* 라디오 버튼을 나타내는 직사각형 스타일 */
    .custom-radio label {
        display: inline-block;
        width: 180px;
        height: 60px;
        padding: 10px;
        cursor: pointer;
        text-align: center;
        line-height: 40px;
    }
    /* 라디오 버튼이 선택되었을 때 label의 배경색을 변경 */
    .custom-radio input[type="radio"]:checked + label {
        background-color: darkgreen;
        color: #fff;
        font-weight:700;
        text-size:30px;
    }
</style>
<style>
.form_seach{
	align-items: center; /* 수직 가운데 정렬 */ 
    justify-content: center; /* 수평 가운데 정렬 */ 

}
.form_seach>div{
	display:flex;
}
</style>
</head>
<body>
    <div class="container-wrapper">
        <img src="../resources/img/main_bg.jpg" class="image" alt="Background Image">
        <div class="container">
                    
			
			<form role="form" class="form_seach" action="/stay/base/ac_list" method="GET">
				<div class="flex">
					<div class="custom-radio">
				        <input type="radio" id="hotel"  name="ac_type" value="1"  checked/>
				        <label for="hotel">호텔</label>
				    </div>
				    <div class="custom-radio">
				        <input type="radio" id="motel" name="ac_type" value="2"/>
				        <label for="motel">모텔</label>
				    </div>
				    <div class="custom-radio">
				        <input type="radio" id="pension"  name="ac_type" value="3"/>
				        <label for="pension">팬션</label>
				    </div>
				    <div class="custom-radio">
				        <input type="radio" id="resort" name="ac_type" value="4"/>
				        <label for="resort">리조트</label>
				    </div>
			    </div>
			    
			    <div>
		            <div class="input1">
		                <input type='date' id="checkin" min="${today }" value="${today }"
		                    class="main_checkin_1" name="checkin" onchange="dateChk()">
		            </div>
		            <div class="input2">
		                <input type='date' id="checkout" min="${tomorrow }"
		                    value="${tomorrow }" class="main_checkout_1" name="checkout"
		                    onchange="dateChk()">
		            </div>
		            <div class="input3">
		                <input type='search' class='main_search_text' placeholder='지역,숙소명' value=""
		                    name="ac_title">
		            </div>
		            <div class="input4">
		                <div class="input4">
		                    <button type='submit' class="btn btn-primary">STAY</button>
		                </div>
		            </div>
	            </div>
	         </form>
        </div>
    </div>
</body>
</html>
