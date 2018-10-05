<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top" >
     <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">E-Commerce</a>
        </div>
      
        <ul class="navbar-nav" >
            <li class="nav-item"><a class="nav-link" href="${contextPath }/profile">profile</a></li>
            <li class="nav-item"><a class="nav-link" href="${contextPath }/editvendor">edit-profile</a></li>
            <li class="nav-item"><a class="nav-link" href="${contextPath }/addproduct">add-products</a></li>
            <li class="nav-item"><a class="nav-link" href="${contextPath }/products">view products</a></li>
           <li>
             <div class="dropdown " style="padding-top:10px">
              <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"><span class="caret"></span></button>             
              <div class="dropdown-menu dropdown-menu-right">
              <a class="dropdown-item"  href="${contextPath }/editvendor">edit</a>
              <a class="dropdown-item" href="${contextPath }/addproduct">addProducts</a>
              <a class="dropdown-item" href="${contextPath }/products">view products</a>
              <a class="dropdown-item" href="#">logout</a>
              </div>
            
            </div>
          </li>
             </div>
        </ul>
      
    </nav>
    <div style="display: flex;">
<div style="flex:2">
<img alt="image" style="width:500px" src='<spring:url value="/resources/images/products/${earphones.productId }.jpg"></spring:url>'>
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
				<td><c:out value="${earphones.product_brand }"></c:out></td>
			</tr>
			<tr>
				<td>Model</td>
				<td><c:out value="${earphones.product_model }"></c:out></td>
			</tr>
			<tr>
				<td>Color</td>
				<td><c:out value="${earphones.product_color }"></c:out></td>
			</tr>
			<tr>
				<td>wireless</td>
				<td><c:out value="${earphones.wireless }"></c:out></td>
			</tr>
			<tr>
				<td>microphone</td>
				<td><c:out value="${earphones.microphone }"></c:out></td>
			</tr>
			<tr>
				<td><a href="${contextPath }/vendor/editearphonesdetails/${earphones.productId }"><button
						class="btn btn-success">edit</button></a></td>
			
			<td><a href="${contextPath }/vendor/deleteproduct/${earphones.productId }"><button
						class="btn btn-danger">delete</button></a></td>	
			</tr>
		</tbody>

	</table>

</div>
<div style="flex:2"></div>
</div>

</body>
</html>