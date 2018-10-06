<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<c:set  value="${pageContext.request.contextPath }" var="contextPath"></c:set>
	<h1>this is cart.</h1>

	<table  class="table table-striped table-bordered ">
	<thead>
		<tr>
		    <th>Product</th>
			<th>Brand</th>
			<th>Model</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Increase/Decrease</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${product }" var="products" varStatus="status">
		<tr>
		<td>${name[status.index]}</td>
		<td>${products.product_brand }</td>
		<td>${products.product_model }</td>
		<td>${products.price*cartitem[status.index].getQuantity() }</td>
		<td>${cartitem[status.index].getQuantity() }</td>
		<td><a href="${contextPath }/customer/addoneproduct/${cartitem[status.index].cartItemsId}"><button>+1</button></a>
		<c:if test="${cartitem[status.index].getQuantity()>1 }">
		<a href="${contextPath }/customer/removeoneproduct/${cartitem[status.index].cartItemsId}"><button>-1</button></a>
		</c:if>
		</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
<a href="${contextPath }/customer/clearcart"><button type="button">ClearCart</button></a>
<a href="${contextPath }/index"><button type="button">Buy more</button></a>
</body>
</html>