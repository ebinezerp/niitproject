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
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top" >
     <div class="container-fluid">
        <div class="navbar-header">
            <a href="index" class="navbar-brand">E-Commerce</a>
        </div>
      
        <ul class="navbar-nav" >
            <li class="nav-item"><a class="nav-link" href="#">profile</a></li>
            <li class="nav-item"><a class="nav-link" href="#">edit-profile</a></li>
            <li class="nav-item"><a class="nav-link" href="#">add-products</a></li>
            <li class="nav-item"><a class="nav-link" href="vendorlogin">sell</a></li>
           <li>
             <div class="dropdown " style="padding-top:10px">
              <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"><span class="caret">Electronics</span></button>             
              <div class="dropdown-menu dropdown-menu-right">
              <c:forEach items="${electronics }" var="electronic">
              <a class="dropdown-item" href="displayproducts/${electronic.subCategory_name }">${electronic.subCategory_name }</a>
              </c:forEach>
              </div>            
            </div>
          </li>       
        </ul>
      </div>
      
    </nav>
    
    <div class="container" style="margin-top:150px">
		<div class="row">

			<c:forEach items="${mobiles }" var="mobile">
		
				   <div class="card" style="width: 12rem">
				    <img class="card-img-top" src='<spring:url value="/resources/images/products/${mobile.productId }.jpg"></spring:url>' alt="Card image cap">
				     <div class="card-body" >
				       <h5 class="card-title">${mobile.product_brand } ${mobile.product_model } ${mobile.product_color }</h5>
				     </div>
				    </div>
				
				
				
			</c:forEach>


		</div>
	</div>
    
    


</body>
</html>