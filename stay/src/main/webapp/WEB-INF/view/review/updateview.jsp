<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>




	<form role="form" action="/review/update" method="post">


		<div class="form-group">
			<label>rev_Num</label> <input class="form-control" name='rev_Num'>
		</div>

		<div class="form-group">
			<label>bo_Num</label> <input class="form-control" name='bo_Num'>
		</div>


		<div class="form-group">
			<label>ac_Title</label><input class="form-control" name='ac_Title'>
		</div>

		<div class="form-group">
			<label>room_Num</label> <input class="form-control" name='room_Num'></input>
		</div>

		<div class="form-group">
			<label>content</label> <input class="form-control" name='content'></input>
		</div>


<!-- 		<div class="form-group"> -->
<!-- 			<label for="review_Date">Review Date</label> <input type="date" -->
<!-- 				class="form-control" id="review_Date" name="review_Date"> -->
<!-- 		</div> -->

<!-- 		<div class="form-group"> -->
<!-- 			<label for="update_Date">Update Date</label> <input type="date" -->
<!-- 				class="form-control" id="update_Date" name="update_Date"> -->
<!-- 		</div> -->


   <div class="form-group">
        <label for="review_Date">Review Date</label>
        <input type="datetime-local" class="form-control" id="review_Date" name="review_Date">
    </div>

    <div class="form-group">
        <label for="update_Date">Update Date</label>
        <input type="datetime-local" class="form-control" id="update_Date" name="update_Date">
    </div>










		<button type="submit" class="btn btn-default">Submit Button</button>
	</form>




</body>
</html>