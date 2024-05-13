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
                <form role="form" action="/stay/room/insert" method="post">
<!--                 	원래는 room_num이 트리거이므로 자동으로 넘어가야하지만  -->
<!--                 	디버깅용으로 room_num 입력창이 존재 -->
                    <div class="mb-3">
                        <label for="room_number" class="form-label">객실 번호</label>
                        <input type="text" class="form-control" id="room_number" name="room_num">
                    </div>
                    
                    <div>
                        <input type="hidden" class="form-control" id="ac_id" name="ac_id" value="${ac_id}" }>
                    </div>
                    
                    <div class="mb-3">
                        <label for="room_name" class="form-label">방 이름</label>
                        <input type="text" class="form-control" id="room_name" name="ro_name" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for=ro_basic_count class="form-label">최저 인원 수</label>
                        <input type="number" class="form-control" id="ro_basic_count" name="ro_basic_count" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for=ro_max_count class="form-label">최대 인원 수</label>
                        <input type="number" class="form-control" id="ro_max_count" name="ro_max_count" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for=""room_info"" class="form-label">방 설명</label>
                        <input type="text" class="form-control" id="room_info" name="ro_info" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="room_price" class="form-label">가격</label>
                        <input type="number" class="form-control" id="room_price" name="room_price" required>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">등록</button>
                </form>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    
    
    
    
    
    
    <!--             	<div class="col-lg-12"> -->
<!--             		<div class="panel panel-default"> -->
<!--             			<div class="panel-heading">Room Register</div> -->
<!--             			<div class="panel-body"> -->
<!--             				<form role="form" action="/stay/room/insert" method="post"> -->
<!--             					<div class="form-group"> -->
<!--             						<label>ro_type</label> <input class="form-control" name='ro_type'> -->
<!--             					</div> -->
            					
<!--             					<div class="form-group"> -->
<!--             						<label>ac_id</label> <input class="form-control" name='ac_id'> -->
<!--             					</div> -->
            					
            					
<!--             					<div class="form-group"> -->
<!--             						<label>ro_name</label> <input class="form-control" name='ro_name'> -->
<!--             					</div> -->
            					
            					
<!--             					<div class="form-group"> -->
<!--             						<label>ro_basic_count</label> <input class="form-control" name='ro_basic_count'> -->
<!--             					</div> -->
            					
<!--             					<div class="form-group"> -->
<!--             						<label>ro_max_count</label> <input class="form-control" name='ro_max_count'> -->
<!--             					</div> -->
            					
<!--             					<div class="form-group"> -->
<!--             						<label>ro_info</label> <input class="form-control" name='ro_info'> -->
<!--             					</div> -->
            					
<!--             					<div class="form-group"> -->
<!--             						<label>ro_count</label> <input class="form-control" name='ro_count'> -->
<!--             					</div> -->
            					
            					
            				
<!--             					<button type="submit" class="btn btn-default">Submit -->
<!--             						Button</button> -->
<!--             					<button type="reset" class="btn btn-default">Reset -->
<!--             						Button</button> -->
<!--             				</form> -->
<!--             			</div> -->
<!--             		</div> -->
<!--             	</div> -->   	
</body>
</html>
