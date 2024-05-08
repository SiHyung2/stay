<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


<body class="bg-gradient-primary">



    <div class="container">


		<h1> 방 정보 수정 및 삭제 창44</h1>
		<a href="/stay/room/list">목록으로</a>
<!-- input의 name에 넣어야할 열이름은 각각 -->
<%-- (#{ro_type}, #{ac_id}, #{ro_name}, #{ro_basic_count}, #{ro_max_count}, #{ro_info}, #{ro_count}) --%>

		

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-5">
                <div class="row">
                	<div class="col-lg-12">
                		<div class="panel panel-default">
                			<div class="panel-heading">Room Register</div>
                			<div class="panel-body">
                				<form role="form" method="post">
                					<div class="form-group">
                						<label>ro_type</label> <input class="form-control" name='room_num' value='${room.room_num }'>
                					</div>
                					
                					<div class="form-group">
                						<label>ac_id</label> <input class="form-control" name='ac_id' value='${room.ac_id }'>
                					</div>
                					
                					
                					<div class="form-group">
                						<label>ro_name</label> <input class="form-control" name='ro_name' value="${room.ro_name}">
                					</div>
                					
                					
                					<div class="form-group">
                						<label>ro_basic_count</label> <input class="form-control" name='ro_basic_count' value="${room.ro_basic_count}">
                					</div>
                					
                					<div class="form-group">
                						<label>ro_max_count</label> <input class="form-control" name='ro_max_count' value="${room.ro_max_count}">
                					</div>
                					
                					<div class="form-group">
                						<label>ro_info</label> <input class="form-control" name='ro_info' value="${room.ro_info}">
                					</div>
                					
                					<div class="form-group">
                						<label>ro_count</label> <input class="form-control" name='ro_count' value="${room.ro_count}">
                					</div>
                					
                					<br>
                				
                					<button id="modify" type="submit" class="btn btn-warning" onclick="javascript: form.action='/stay/room/modify';">수정</button>
                					<button id="delete" type="submit" class="btn btn-danger" onclick="javascript: form.action='/stay/room/delete';">삭제</button>
                				</form>
                			</div>
                		</div>
                	</div>
                </div>
            </div>
        </div>
        
        