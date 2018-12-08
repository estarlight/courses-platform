<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>Courses</title>

	<style>
		.inline {
			display:inline-block;
			margin: 30px;
			padding: 10px;
			vertical-align: middle;
		}
		
		.center {
			text-align: center;
			margin-top: 15px;
			margin-bottom: 15px;
			}
	</style>
</head>
<body>
	<div class="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="/courses">Courses</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    		<div class="navbar-nav">
      			<a class="nav-item nav-link" href="#">Low Sign Up</a>
		      <a class="nav-item nav-link" href="#">High Sign Up</a>
		      <a class="nav-item nav-link" href="/logout">Logout</a>
    		</div>
  		</div>
	</nav>
	
	<h3 class = "center">Welcome <c:out value="${student.name }" /></h3>
	
	
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Course</th>
				<th scope="col">Instructor</th>
				<th scope="col">Signups</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${courses }" var="course">
			<tr>
				<td><a href = "courses/${course.id}">${course.name }</a></td>
				<td>${course.instructor }</td>
				<td>${fn:length(course.students) }/${course.capacity }</td>
				<td><a href="/add/<c:out value="${course.id }"/>">Add</a></td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a class="btn btn-primary" href="/courses/new">Add a course</a>
	
	</div>

</body>
</html>