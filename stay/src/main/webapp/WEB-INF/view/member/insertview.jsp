<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

			
								<form role="form" action="/stay/member/insert" method="post">
						
									
									<div class="form-group">
										<label>id</label> <input class="form-control" name='email_id'>
									</div>

									<div class="form-group">
										<label>password</label><input class="form-control" name='password'>
									</div>

									<div class="form-group">
										<label>name</label>
										<input class="form-control"  name='name'></input>
									</div>
 
									<div class="form-group">
										<label>tel</label> <input class="form-control"
											name='tel'></input>
									</div>
									
									<div class="form-group">
										<label>type_code</label> <input class="form-control"
											name='type_code'></input>
											
									</div>
									

								<button type="submit" class="btn btn-default">Submit
										Button</button>
								</form>

					


</body>
</html>