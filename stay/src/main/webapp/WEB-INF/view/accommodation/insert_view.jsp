<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous"> -->
<!DOCTYPE html>
<html lang="en">




<body class="bg-gradient-primary">
	<%@include file="../menu.jsp"%>

		
<!-- 		post 매개변수 테스트 -->
<%-- 		${ email_id } --%>
		
    <div class="container">
        <h1 class="text-center mt-5">숙소 등록</h1>
        <div class="row justify-content-center mt-5">
            <div class="col-md-6">
                <form name="form1" role="form" action="/stay/accommodation/insert" method="post" enctype="multipart/form-data">
               
<!--                		숙소 아이디는 트리거로 해야만함! (무결성 제약조건 위배될 가능성 있음)  -->
<!-- 						사실 여기서 입력하지않아도 트리거니까 넘어가야함. 아래의 ac_id 입력창은 디버깅용 코드임 -->
<!--                 	<div> -->
<!--                 		<label for="accommodation_id" class="form-label">숙소 아이디</label> -->
<!--                         <input type="text" class="form-control" id="accommodation_id" name="ac_id"> -->
<!--                     </div> -->
                    <div>
                        <input type="hidden" class="form-control" id="email_id" name="email_id" value="${email_id}">
                    </div>
                    
                    <div class="mb-3">
                        <label for="accommodationName" class="form-label required">숙소명</label>
                        <input type="text" class="form-control" id="accommodation_name" name="ac_title">
                    </div>
                    
                    <div class="mb-3">
                        <label for="accommodation_type" class="form-label">객실 유형</label>
                        <select class="form-control" id="accommodation_type" name="ac_type">
                            <option value="1" selected>호텔</option>
                            <option value="2">모텔</option>
                            <option value="3">펜션</option>
                            <option value="4">리조트</option>
                            <option value="5">홈&빌라</option>
                            <option value="6">게스트 하우스</option>
                            <option value="7">캠핑</option>
                        </select>
                    </div>
                    
                    <div class="mb-3">
                        <label for="accommodation_address" class="form-label">위치</label>
                        <input type="text" class="form-control" id="accommodation_address" name="ac_address" required>
                    </div>
                    
                   <div class="mb-3">
                        <label for="accommodation_info" class="form-label">숙소 정보</label>
                        <textarea class="form-control" id="accommodation_info" name="ac_info" rows="3" required></textarea>
                    </div>
                    
                    
<!--                     이거 date인 날짜가 아니라 시간으로 입력 가능하도록 바꿔야함... 대충 아무 날짜 넣고 시간 넣는 형식으로 만들자 -->
<!--                     뷰에서 input만 바뀌면 됨 -->
                    <div class="mb-3">
                        <label for="accommodation_checkin" class="form-label">체크인</label>
                        <input type="text" class="form-control" id="accommodation_checkin" name="checkin" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="accommodation_checkout" class="form-label">체크아웃</label>
                        <input type="text" class="form-control" id="accommodation_address" name="checkout" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="room_img" class="form-label">사진</label>
                        <input type='file' class="form-control" id="ac_img" name='ac_img' multiple>
                    </div>
                    
                    <button type="submit" class="btn btn-primary w-100">등록</button>
                </form>
            </div>
        </div>
    </div>



</body>

</html>