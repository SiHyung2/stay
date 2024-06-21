<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>객실 등록</title>
<!--     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"> -->
</head>
<body>
	<%@include file="../menu.jsp"%>
    <div class="container">
        <h1 class="text-center mt-5">객실 등록</h1>
<!--         		post 매개변수 테스트 -->
<%-- 		${ ac_id }         --%>
                
        <div class="row justify-content-center mt-5">
            <div class="col-md-6">
<!--             	파일(사진) 업로드 관련 코드 : enctype="multipart/form-data" -->
                <form role="form" action="/stay/room/insert" method="post" enctype="multipart/form-data">
<!--                 	원래는 room_num이 트리거이므로 자동으로 넘어가야하지만  -->
<!--                 	디버깅용으로 room_num 입력창이 존재 -->
<!--                     <div class="mb-3"> -->
<!--                         <label for="room_number" class="form-label">객실 번호</label> -->
<!--                         <input type="text" class="form-control" id="room_number" name="room_num"> -->
<!--                     </div> -->
                    
                    <div>
                        <input type="hidden" class="form-control" id="ac_id" name="ac_id" value="${ac_id}">
                    </div>
                    
                    <div class="mb-3">
                        <label for="room_name" class="form-label">방 이름</label>
                        <input type="text" class="form-control" id="room_name" name="ro_name" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for=ro_basic_count class="form-label">기준 인원 수</label>
                        <input type="number" class="form-control" id="ro_basic_count" name="ro_basic_count" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for=ro_max_count class="form-label">최대 인원 수</label>
                        <input type="number" class="form-control" id="ro_max_count" name="ro_max_count" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="room_info" class="form-label">방 설명</label>
                        <input type="text" class="form-control" id="room_info" name="ro_info" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="room_price" class="form-label">가격</label>
                        <input type="number" class="form-control" id="room_price" name="room_price" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="room_img" class="form-label">사진</label>
                        <input type='file' class="form-control" id="room_img" name='room_img' onclick="img_valid_message()" multiple>
                    </div>
<!--                     16:9 비율의 사진을 업로드하지않을 시 깨질 수 있습니다! -->
                    
                    <button type="submit" class="btn btn-primary">등록</button>
                </form>
            </div>
        </div>
    </div>
	
	
<!-- 	파일 유효성 검사 스크립트 미구현됨  -->
	<script>
		function img_valid_message(){
			var extension = extension("(.*?)\.(png|jpeg|pdf|ai|tiff|emp|eps|svg)$");   //이미지 확장자만 업로드 가능
			var maxSize=5242880;   // 5MB까지 업로드 가능
			
			alert("16:9 비율의 사진을 업로드하지않을 시 깨질 수 있습니다!");
			
			if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			if(extension.test(fileName)){
				alert("다음의 이미지 파일만 업로드할 수 있습니다.");
				alert("허용되는 파일 : (png|jpeg|pdf|ai|tiff|emp|eps|svg)");
				return false;
			}
		}
	</script>
	
</body>
</html>
