<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
	<div class="container">
		<form>
			<div class="form-group">
				<label for="username">Username</label> <input type="text" class="form-control" placeholder="Enter username" id="username">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
			</div>
		</form>
		<button id="btn-save" class="btn btn-primary">회원가입완료</button>
	</div>
	<script src="/eplaton/js/ajaxtunnelling/ajaxtest.js"></script>

</body>
</html>