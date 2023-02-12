<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link rel="stylesheet" href="css/registerStyle.css">
</head>
<body>
	<%
		Object error = request.getAttribute("error");
		String notification="";
		//Object firstName=request.getAttribute("firstName");
		//Object lastName=request.getAttribute("lastName");
		//Object age=request.getAttribute("age");
		//Object gender=request.getAttribute("gender");
		//Object address=request.getAttribute("address");
		//Object phone=request.getAttribute("phone");
		//String firstNamer="";
		//String lastNamer="";
		//String ager="";
		//String genderr="";
		//String addressr="";
		//String phoner="";
		if (error != null) {
			notification=error.toString();
			//firstNamer=firstName.toString();
			//lastNamer=lastName.toString();
			//age=age.toString();
			//genderr=gender.toString();
			//addressr=address.toString();
			//phoner=phoner.toString();
		}
	%>
	<div class ="container">
        <form action="registerControlUrl" method="Post">
            <h1>Please enter information</h1>
         	<div class="text-align"><span class="red"><%= notification %></span></div>
            <div class="form-control"> 
                <label for="userId">Enter userId</label>
                <input type="text" id="userId" name="userId" >
            </div>
            
            <div class="form-control">
                <label for="password">Enter password</label>
                <input type="password" id="password" name="password">
            </div>
            <div class="form-control">
                <label for="re_password">Confirm password</label>
                <input type="password" id="re_password" name="re_password">
            </div>
            <div class="form-control">
                <label for="firstName">Enter first name</label>
                <input type="text" id="firstName" name="firstName" >
            </div>
            <div class="form-control">
                <label for="lastName">Enter last name</label>
                <input type="text" id="lastName" name="lastName" >
            </div>
            <div class="form-control">
                <label for="age">Enter your age</label>
                <input type="number" id="age" name="age" >
            </div>
            <div class="form-control">
                <label for="gender">Gender</label>
                <div class="btn-gender">
                    <input type="radio" id="male" name="gender" value="male">
                    <label >Male</label>
                    <input type="radio" id="female" name="gender" value="female">
                    <span>Female</span>   
                </div>
            </div>
            <div class="form-control">
                <label for="address">Address</label>
                <input type="text" id="address" name="address" >
            </div>
            <div class="form-control">
                <label for="phone">Phone number</label>
                <input type="tel" id="phone" name="phone" >
            </div>
            
            <div class="form-control">
                <button type="submit" class="btn-submit">Submit</button>
            </div>
        </form>

    </div>
</body>
</html>