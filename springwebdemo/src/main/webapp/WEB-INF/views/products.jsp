<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	
	  <script src="<c:url value="/resources/css/style.css"/>"></script>
  <script src="<c:url value="/resources/js/productgallery.js"/>"></script>
</head>
<body>


<!-- Grid row -->
<div class="gallery" id="gallery">

   <c:forEach items="${products }" var="products">
    <!-- Grid column -->
    <div class="mb-3 pics animation all 2">
        <img class="img-fluid" src="" alt="${products.product_brand }">
        <button class="btn btn-success"><a href="productdetails/${products.productId }">view</a></button>
    </div>
    <!-- Grid column -->
   </c:forEach>   
</div>
<!-- Grid row -->
</body>
</html>