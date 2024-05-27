<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">



<body class="bg-gradient-primary">

	<%@include file="../menu.jsp"%>

    <div class="container">


<!-- input의 name에 넣어야할 열이름은 각각 -->
<%-- (#{ro_type}, #{ac_id}, #{ro_name}, #{ro_basic_count}, #{ro_max_count}, #{ro_info}, #{ro_count}) --%>
	
		
	<div class="container">
        <h1 class="text-center mt-5">객실 수정2</h1>
<!--         		post 매개변수 테스트 -->
<%-- 		${ ac_id }         --%>
                
        <div class="row justify-content-center mt-5">
            <div class="col-md-6">
                <form role="form" method="post">
<!--                 	원래는 room_num이 트리거이므로 자동으로 넘어가야하지만  -->
<!--                 	디버깅용으로 room_num 입력창이 존재 -->
                    <div class="mb-3">
<!--                         <label for="room_number" class="form-label">객실 번호</label> -->
                        <input type="hidden" class="form-control" id="room_number" name="room_num" value="${room.room_num }">
                    </div>
                    
                    <div>
                        <input type="hidden" class="form-control" id="ac_id" name="ac_id" value="${room.ac_id}">
                    </div>
                    
                    <div class="mb-3">
                        <label for="room_name" class="form-label">방 이름</label>
                        <input type="text" class="form-control" id="room_name" name="ro_name" value="${ room.ro_name}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for=ro_basic_count class="form-label">최저 인원 수</label>
                        <input type="number" class="form-control" id="ro_basic_count" name="ro_basic_count" value="${ room.ro_basic_count}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for=ro_max_count class="form-label">최대 인원 수</label>
                        <input type="number" class="form-control" id="ro_max_count" name="ro_max_count" value="${ room.ro_max_count}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="room_info" class="form-label">방 설명</label>
                        <input type="text" class="form-control" id="room_info" name="ro_info" value="${ room.ro_info}" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="room_price" class="form-label">가격</label>
                        <input type="number" class="form-control" id="room_price" name="room_price" value="${ room.room_price}" required>
                    </div>
                    <button id="modify" type="submit" class="btn btn-warning" onclick="javascript: form.action='/stay/room/modify';">수정</button>
					<button id="delete" type="submit" class="btn btn-danger" onclick="javascript: form.action='/stay/room/delete';">삭제</button>
                </form>
            </div>
        </div>
    </div>

</div>

</body>

</html>



        
        