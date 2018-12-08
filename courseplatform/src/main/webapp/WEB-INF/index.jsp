<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>

	<style>
		.row {
    		display: flex;
		}
		
		.column {
		    flex: 50%;
		}
	</style>
</head>
<body>

	<div class="row">
	
  <div class="column">
  	<h1>Register</h1>
  	
  	<p><form:errors path="student.*"/></p>
    
    <form:form method="POST" action="/register" modelAttribute="student">
        
          <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register"/>
        
    </form:form>
  	
  	
  </div>
  
  
  <div class="column">
  
  	<h1>Login</h1>
  	
  	<p><c:out value="${error}" /></p>
  	<form:form method="POST" action="/login" modelAttribute="student">
        <p>
            <form:label path="email" for="email">Email</form:label>
            <form:input type="email" id="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password</form:label>
            <form:password path="password"/>
        </p>
        <input type="submit" value="Login"/>
    </form:form> 
  	
  	
  </div>
</div>

</body>
</html>