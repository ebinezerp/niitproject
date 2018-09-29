<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a href="index" class="navbar-brand">E-Commerce</a>
		</div>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">profile</a></li>
			<li class="nav-item"><a class="nav-link" href="#">edit-profile</a></li>
			<li class="  nav-item"><a class="nav-link" href="#">add-products</a></li>
			<li class=" nav-item"><a class="nav-link" href="#">view
					products</a></li>
			<li>
				<div class="dropdown " style="padding-top: 10px">
					<button class="btn btn-default dropdown-toggle" type="button"
						data-toggle="dropdown">
						<span class="caret">Electronics</span>
					</button>
					<div class="dropdown-menu dropdown-menu-right">
						<a class="dropdown-item" href="#">edit</a> <a
							class="dropdown-item" href="#">addProducts</a> <a
							class="dropdown-item" href="#">view products</a> <a
							class="dropdown-item" href="#">logout</a>
					</div>

				</div>
			</li>
		</ul>
	</div>


	</nav>

	This is customer Login Page.


	<div style="display: flex; margin-top: 100px">
		<div style="flex: 2"></div>
		<div style="flex: 2; border: 2px solid black; padding: 20px">
			<form action="${contextPath }/customer/customerlogin" class="form" method="POST">
				<div style="display: flex">
					<div style="flex: 1"></div>
					<div style="flex: 1">

						<div style="margin: 5px">
							<input type="email" name="customer_email" placeholder="enter email" />
						</div>
						<div style="margin: 5px">
							<input type="password" placeholder="enter password"
								name="customer_password" />
						</div>

						<div style="margin: 10px; padding-left: 45px">
							<input class="btn btn-info" type="submit" value="login">
						</div>

						<h5>
							<pre> not a customer yet  ?</pre>
						</h5>
						<div style="margin: 10px; padding-left: 45px">
							<a href="customersignup"><input type="button"
								class="btn btn-success" value="signup"></a>
						</div>
					</div>
					<div style="flex: 1"></div>
				</div>

			</form>
		</div>
		<div style="flex: 2"></div>
	</div>








	<div style="margin-top: 50px"></div>
</body>
</html>