<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
	<link rel="stylesheet"
	href='<spring:url value="/resources/css/style.css"></spring:url>'>
</head>
<body style="background-color:threedlightshadow;">

	<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a href="${contextPath}/index" class="navbar-brand">E-Commerce</a>
		</div>

		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">profile</a></li>
			<li class="nav-item"><a class="nav-link" href="#">edit-profile</a></li>
			<li class="nav-item"><a class="nav-link" href="#">add-products</a></li>
			<li class="nav-item"><a class="nav-link" href="${contextPath}/vendorlogin">sell</a></li>
			<li>
				<div class="dropdown " style="padding-top: 10px">
					<button class="btn btn-default dropdown-toggle" type="button"
						data-toggle="dropdown">
						<span class="caret">Electronics</span>
					</button>
					<div class="dropdown-menu dropdown-menu-right">
						<c:forEach items="${electronics }" var="electronic">
							<a class="dropdown-item"
								href="displayproducts/${electronic.subCategory_name }">${electronic.subCategory_name }</a>
						</c:forEach>
					</div>
				</div>
			</li>
		</ul>
	</div>

	</nav>
<div style="display: flex;">
<div style="flex:2">
<img alt="image" style="width:500px" src='<spring:url value="/resources/images/products/${mobile.productId }.jpg"></spring:url>'>
</div>
<div style="width:500px;flex:2">
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th colspan="2"><h4 style="margin-left: 250px;"><c:out value="${name}"></c:out></h4></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Brand</td>
				<td><c:out value="${mobile.product_brand }"></c:out></td>
			</tr>
			<tr>
				<td>Model</td>
				<td><c:out value="${mobile.product_model }"></c:out></td>
			</tr>
			<tr>
				<td>Color</td>
				<td><c:out value="${mobile.product_color }"></c:out></td>
			</tr>
			<tr>
				<td>Display Size</td>
				<td><c:out value="${mobile.mobile_display_size }"></c:out></td>
			</tr>
			<tr>
				<td>Operating System</td>
				<td><c:out value="${mobile.mobile_os }"></c:out></td>
			</tr>
			<tr>
				<td>4G/LTE</td>
				<td><c:out value="${mobile.mobile_lte }"></c:out></td>
			</tr>
			<tr>
				<td>Ram</td>
				<td><c:out value="${mobile.mobile_ram }"></c:out></td>
			</tr>
			<tr>
				<td>Internal memory</td>
				<td><c:out value="${mobile.mobile_rom }"></c:out></td>
			</tr>
			<tr>
				<td>Front cam</td>
				<td><c:out value="${mobile.mobile_frontcam }"></c:out></td>
			</tr>
			<tr>
				<td>Internal memory</td>
				<td><c:out value="${mobile.mobile_rearcam }"></c:out></td>
			</tr>
			<tr>
				<td>Weight</td>
				<td><c:out value="${mobile.mobile_weight }"></c:out></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><c:out value="${mobile.mobile_description}"></c:out></td>
			</tr>
			
			<form action="${contextPath }/customer/addtocart" method="get">
			<tr>
			<td>Enter number of products</td>
			<td><input type="number" name="numberOfProducts"></td>
			<input type="hidden" name="productId" value="${mobile.productId }">
			</tr>			
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
			</form>
		</tbody>

	</table>

</div>
<div style="flex:2"></div>
</div>
</body>
</html>