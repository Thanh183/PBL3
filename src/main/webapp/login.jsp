<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="css/loginStyle.css">

</head>

<body>
			<%
				Object error = request.getAttribute("error");
				Object userId= request.getAttribute("userId");
				String notification="";
				String userIdr="";
				if (error != null) {
					notification=error.toString();
					userIdr=userId.toString();
				}
			%>
	<div class="container">
		<form action="loginControlUrl" method="POST">
			<h1>LOGIN</h1>

			<div class="form-control">
				<input type="text" id="userId" name="userId" placeholder="userId" value= "<%=userIdr%>">
			</div>
			<div class="form-control">
				<input type="password" id="password" name="password" placeholder="Password">
			</div>
			<div>
				<button type="submit" class="btn-submit">Log in</button>
			</div>
			<div class="text-center"><span class="red"><%= notification %></span></div>
			<div class="register_link">
				Create account ? <a href="register.jsp">Register</a>
			</div>
		</form>
	</div>

</body>

</html>

