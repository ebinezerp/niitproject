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


<!-- 	<div id="myCarousel" class="carousel slide" data-ride="carousel">

		indicators
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
		</ol>
		wrapper for slides
		<div class="carousel-inner" role="listbox">
			<div class="item-active">
				<img src="" alt="image-1" width="460" height="345">
				<div class="carousel-caption">
					<h3>hwdjwdcdkhjkja cxnm</h3>
					<p>hfdhwbdkjh iuhdb i d jdgyubs dhjdgytwd soiujd sdugsd
						skjdnskn</p>
				</div>
			</div>
            <div class="item">
				<img src="" alt="image-1" width="460" height="345">
				<div class="carousel-caption">
					<h3>hwdjwdcdkhjkja cxnm</h3>
					<p>hfdhwbdkjh iuhdb i d jdgyubs dhjdgytwd soiujd sdugsd
						skjdnskn</p>
				</div>
			</div>
			<div class="item">
				<img src="" alt="image-1" width="460" height="345">
				<div class="carousel-caption">
					<h3>hwdjwdcdkhjkja cxnm</h3>
					<p>hfdhwbdkjh iuhdb i d jdgyubs dhjdgytwd soiujd sdugsd
						skjdnskn</p>
				</div>
			</div>
			<div class="item">
				<img src="" alt="image-1" width="460" height="345">
				<div class="carousel-caption">
					<h3>hwdjwdcdkhjkja cxnm</h3>
					<p>hfdhwbdkjh iuhdb i d jdgyubs dhjdgytwd soiujd sdugsd
						skjdnskn</p>
				</div>
			</div>
			
			left and right controls
			
			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	 -->
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
      <img src='<spring:url value="/resources/images/laptop.jpeg"></spring:url>' style="width:300px;height:300px">
      <img src='<spring:url value="/resources/images/laptop1.jpg"></spring:url>' alt="Chicago" style="width:401px;height:300px">
       <img src='<spring:url value="/resources/images/laptop2.jpeg"></spring:url>' alt="New York" style="width:345px;height:300px">
    </div>
    <div class="carousel-item" style="background:white;">
        <img src='<spring:url value="/resources/images/watch.jpg"></spring:url>' style="width:450px;height:300px">
          <img src='<spring:url value="/resources/images/watch2.jpg"></spring:url>' alt="New York" style="width:300px;height:300px">
      <img src='<spring:url value="/resources/images/watch1.jpg"></spring:url>' alt="Chicago" style="width:300px;height:300px">
    </div>
    <div class="carousel-item" style="background:white;">
     <img src='<spring:url value="/resources/images/mobile1.jpeg"></spring:url>' alt="Chicago" style="width:420px;height:300px">
      <img src='<spring:url value="/resources/images/mobile.jpg"></spring:url>' style="width:300px;height:300px">
      <img src='<spring:url value="/resources/images/mobile2.jpg"></spring:url>' alt="New York" style="width:280px;height:300px">
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
				<div class="card" style="width: 12rem">
					<img class="card-img-top"
						src='<spring:url value="/resources/images/products/${product.productId }.jpg"></spring:url>'
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${product.product_brand }
							${product.product_model } ${product.product_color }</h5>
					</div>
				</div>
			</c:forEach>


		</div>
	</div>
</body>
</html>