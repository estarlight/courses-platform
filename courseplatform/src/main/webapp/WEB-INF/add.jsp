<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add a Course</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
</head>
<body>

	<div class="container">

	<h1>Create a new course</h1>

	<p><form:errors path="course.*"/></p>
	
	    <form:form method="POST" action="/courses/new" modelAttribute="course">
        
       	<p>
            <form:label path="name">Name:</form:label>
            <form:input class="form-control" path="name"/>
        </p>
        
        <p>
            <form:label path="instructor">Instructor:</form:label>
            <form:input class="form-control" path="instructor"/>
        </p>
        
        <p>
            <form:label path="capacity">Capacity:</form:label>
            <form:input class="form-control" path="capacity"/>
        </p>
        
        <input class = "btn btn-primary" type="submit" value="Create"/>
        
        </form:form>

	</div>
</body>
</html>