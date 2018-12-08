<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>    
    
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	
	<meta charset="UTF-8">
	<title>Edit Course</title>
</head>
<body>

	<div class="container">

	<h1>Edit <c:out value="${course.name }" /></h1>

	<p><form:errors path="course.*"/></p>

	<form:form action="/courses/${course.id }" method="post" modelAttribute="course">
		<input type="hidden" name="_method" value="put">
			
			<p>
            <form:label path="name">Name:</form:label>
            <form:input class="form-control" path="name"/>
        </p>
        
        <p>
            <form:label path="instructor">Instructor:</form:label>
            <form:input path="instructor" class="form-control"/>
        </p>
        
        <p>
            <form:label path="capacity">Capacity:</form:label>
            <form:input path="capacity" class="form-control"/>
        </p>
        
        <input class = "btn btn-primary" type="submit" value="Update"/>
			
			
	</form:form>
	
	</div>

</body>
</html>