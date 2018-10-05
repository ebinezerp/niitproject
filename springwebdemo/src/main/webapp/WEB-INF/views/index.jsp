<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
			<li>
				<div class="dropdown " style="padding-top: 10px">
					<button class="btn btn-default dropdown-toggle" type="button"
						data-toggle="dropdown">
						<span class="caret">HomeAppliances</span>
					</button>
					<div class="dropdown-menu dropdown-menu-right">
						<c:forEach items="${homeappliances }" var="homeappliance">
							<a class="dropdown-item"
								href="displayproducts/${homeappliance.subCategory_name }">${homeappliance.subCategory_name }</a>
						</c:forEach>
					</div>
				</div>
			</li>
			<li>
				<div class="dropdown " style="padding-top: 10px">
					<button class="btn btn-default dropdown-toggle" type="button"
						data-toggle="dropdown">
						<span class="caret">Accessories</span>
					</button>
					<div class="dropdown-menu dropdown-menu-right">
						<c:forEach items="${accessories }" var="accessory">
							<a class="dropdown-item"
								href="displayproducts/${accessory.subCategory_name }">${accessory.subCategory_name }</a>
						</c:forEach>
					</div>
				</div>
			</li>
			<li>
				<div class="dropdown " style="padding-top: 10px">
					<button class="btn btn-default dropdown-toggle" type="button"
						data-toggle="dropdown">
						<span class="caret">Fashion</span>
					</button>
					<div class="dropdown-menu dropdown-menu-right">
						<c:forEach items="${fashion }" var="fashion">
							<a class="dropdown-item"
								href="displayproducts/${fashion.subCategory_name }">${fashion.subCategory_name }</a>
						</c:forEach>
					</div>
				</div>
			</li>
			<li>
				<div class="dropdown " style="padding-top: 10px">
					<button class="btn btn-default dropdown-toggle" type="button"
						data-toggle="dropdown">
						<span class="caret">All</span>
					</button>
					<div class="dropdown-menu dropdown-menu-right">
						<c:forEach items="${allsubcategories }" var="allsubcategories">
							<a class="dropdown-item"
								href="displayproducts/${allsubcategories.subCategory_name }">${allsubcategories.subCategory_name }</a>
						</c:forEach>
					</div>
				</div>
			</li>
			<li class="nav-item">
			</li>
		</ul>
	</div>

	</nav>


	<div style="display: flex;margin-top: 65px;background-color: white">
	<div style="flex:2"   >
	
	</div>
	
	<div id="demo1" class="carousel slide" data-ride="carousel" style="flex:6" >

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo1" data-slide-to="0" class="active"></li>
    <li data-target="#demo1" data-slide-to="1"></li>
    <li data-target="#demo1" data-slide-to="2"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active" style="background:white;">
      <img src='${contextPath}/resources/images/laptop.jpeg' style="width:300px;height:300px">
      <img src='${contextPath}/resources/images/laptop1.jpg' alt="Chicago" style="width:401px;height:300px">
       <img src='${contextPath}/resources/images/laptop2.jpeg' alt="New York" style="width:345px;height:300px">
    </div>
    <div class="carousel-item" style="background:white;">
        <img src='${contextPath}/resources/images/watch.jpg' style="width:400px;height:300px">
          <img src='${contextPath}/resources/images/watch2.jpg' alt="New York" style="width:300px;height:300px">
      <img src='${contextPath}/resources/images/watch1.jpg' alt="Chicago" style="width:300px;height:300px">
    </div>
    <div class="carousel-item" style="background:white;">
     <img src='${contextPath}/resources/images/mobile1.jpeg' alt="Chicago" style="width:420px;height:300px">
      <img src='${contextPath}/resources/images/mobile.jpg' style="width:300px;height:300px">
      <img src='${contextPath}/resources/images/mobile2.jpg' alt="New York" style="width:280px;height:300px">
    </div>
  </div>
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo1" data-slide="prev">
    <span class="carousel-control-prev-icon" ><</span>
  </a>
  <a class="carousel-control-next" href="#demo1" data-slide="next">
    <span class="carousel-control-next-icon">></span>
  </a>
</div>
<div style="flex:2" >
	</div>
</div>
	<div class="container" style="margin-top: 150px">
		<div class="row">

			<c:forEach items="${tenproducts }" var="product">
				<div class="card" style="width: 20rem">
					<img class="card-img-top"
						src='${contextPath}/resources/images/products/${product.productId }.jpg'
						alt="Card image cap" style="height:80%;width:80%">
					<div class="card-body">
						<h5 class="card-title">${product.product_brand }
							${product.product_model } ${product.product_color }</h5>
							<button type="button"><a href="display/${product.productId }">Buy</a></button>
					</div>
				</div>
			</c:forEach>


		</div>
	</div>
</body>
</html>