<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!DOCTYPE html>
<html lang="en">


<body class="bg-gradient-primary">

    <div class="container">


<!-- input의 name에 넣어야할 열이름은 각각 -->
<%-- (#{ro_type}, #{ac_id}, #{ro_name}, #{ro_basic_count}, #{ro_max_count}, #{ro_info}, #{ro_count}) --%>

		
		<a href="/stay/room/list">목록으로</a>

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-5">
                <div class="row">
                	<div class="col-lg-12">
                		<div class="panel panel-default">
                			<div class="panel-heading">Room Register</div>
                			<div class="panel-body">
                				<form role="form" action="/stay/room/insert" method="post">
                					<div class="form-group">
                						<label>ro_type</label> <input class="form-control" name='ro_type'>
                					</div>
                					
                					<div class="form-group">
                						<label>ac_id</label> <input class="form-control" name='ac_id'>
                					</div>
                					
                					
                					<div class="form-group">
                						<label>ro_name</label> <input class="form-control" name='ro_name'>
                					</div>
                					
                					
                					<div class="form-group">
                						<label>ro_basic_count</label> <input class="form-control" name='ro_basic_count'>
                					</div>
                					
                					<div class="form-group">
                						<label>ro_max_count</label> <input class="form-control" name='ro_max_count'>
                					</div>
                					
                					<div class="form-group">
                						<label>ro_info</label> <input class="form-control" name='ro_info'>
                					</div>
                					
                					<div class="form-group">
                						<label>ro_count</label> <input class="form-control" name='ro_count'>
                					</div>
                					
                					
                				
                					<button type="submit" class="btn btn-default">Submit
                						Button</button>
                					<button type="reset" class="btn btn-default">Reset
                						Button</button>
                				</form>
                			</div>
                		</div>
                	</div>
                </div>
            </div>
        </div>

<!--     </div> -->

<!-- </body> -->

<!-- </html>1111 -->