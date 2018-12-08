<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>Course Profile</title>
	<style>
		.padding {
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
	
	<h1 class="padding"><c:out value="${course.name }" /></h1>
	
	<p>Instructor: <c:out value="${course.instructor }" /> </p>
	<p>Sign Ups: <c:out value="${count }" /> </p>
	
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Sign Up Date</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${ connectList}" var="c">
				<tr>
					<td>${c.student.name }</td>
					<td>${c.course.createdAt }</td>
					<td><a href="">Remove</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a class="btn btn-primary" href="/courses/${course.id }/edit">Edit</a>
	<a class="btn btn-primary" href="/courses/${course.id }/delete">Delete</a>

	</div>
</body>
</html>