<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
<c:set value="${pageContext.request.contextPath }" var="contextPath"></c:set>
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
								href="${contextPath }/displayproducts/${electronic.subCategory_name }">${electronic.subCategory_name }</a>
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
								href="${contextPath }/displayproducts/${homeappliance.subCategory_name }">${homeappliance.subCategory_name }</a>
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
								href="${contextPath }/displayproducts/${accessory.subCategory_name }">${accessory.subCategory_name }</a>
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
								href="${contextPath }/displayproducts/${fashion.subCategory_name }">${fashion.subCategory_name }</a>
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
								href="${contextPath }/displayproducts/${allsubcategories.subCategory_name }">${allsubcategories.subCategory_name }</a>
						</c:forEach>
					</div>
				</div>
			</li>
			<li class="nav-item">
			<c:set var="user" scope="session" value="${userName}"/>
			<c:choose >
			<c:when test="${user=='admin' }">
			<a class="nav-link" href="${contextPath }/admin/logout">Logout</a>
			</c:when>
			<c:when test="${user=='vendor' }">
			<a class="nav-link" href="${contextPath }/vendor/logout">Logout</a>
			</c:when>
			<c:when test="${user=='customer' }">
			<a class="nav-link" href="${contextPath }/customer/logout">Logout</a>
			</c:when>			
			</c:choose>
			</li>
		</ul>
	</div>

	</nav>
    <div class="container" style="margin-top: 150px">
		<div class="row">

			<c:forEach items="${products }" var="product">
				<div class="card" style="width: 20rem">
					<img class="card-img-top"
						src='${contextPath}/resources/images/products/${product.productId }.jpg'
						alt="Card image cap" style="height:80%;width:80%">
					<div class="card-body">
						<h5 class="card-title">${product.product_brand }
							${product.product_model } ${product.product_color }</h5>
							<button type="button"><a href="${contextPath}/display/${product.productId }">Buy</a></button>
					</div>
				</div>
			</c:forEach>


		</div>
	</div>
    
    


</body>
</html>