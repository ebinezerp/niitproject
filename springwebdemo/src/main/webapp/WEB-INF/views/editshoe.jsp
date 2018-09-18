<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

 <nav class="navbar navbar-inverse navbar-fixed-top" >
      <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">E-Commerce</a>
        </div>
       
        <ul class="nav navbar-nav" style="float: right;">
            <li><a href="profile">profile</a></li>
            <li ><a href="editvendor">edit-profile</a></li>
            <li><a href="addproduct">add-products</a></li>
            <li><a href="products">view products</a></li>
           <li>
             <div class="dropdown" style="padding-top:15px">
              <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"><span class="caret"></span></button>
              <ul class="dropdown-menu dropdown-menu-right" >
                <li><a href="editvendor">edit</a></li>
                <li><a href="addproduct">addProducts</a></li>
                <li><a href="products">view products</a></li>
                <li class="divider"></li>
                <li><a href="#">logout</a></li>
              </ul>
            </div>
          </li>
             </div>
        </ul>
      
    </nav>

<div style="margin-top:50px; width:500px">
	<springform:form method="post" action="editshoedetails"
		modelAttribute="shoe" enctype="multipart/form-data">
		<springform:input path="subCategory.subCategory_id" type="hidden"
			value="${subCategoryId}" />
				<springform:input path="productId" type="hidden"
			 />
	    <springform:input path="subCategory.subCategory_id" type="hidden"
			 />
	    <springform:input path="vendor.vendor_id" type="hidden"
			 />

		<div class="form-group">
			<springform:input path="product_brand" class="form-control"
				placeholder="enter brand"  />
		</div>
		<div class="form-group">
			<springform:input path="product_model" class="form-control"
				placeholder="enter model"  />
		</div>
		<div class="form-group">
			<springform:input path="price" class="form-control"
				placeholder="enter price"  />
		</div>
		<div class="form-group">
			<springform:input path="gender" class="form-control"
				placeholder="enter gender"  />
		</div>
		<div class="form-group">
			<springform:input path="shoetype" class="form-control"
				placeholder="enter shoe type"  />
		</div>
		<div class="form-group">
			<springform:input path="product_color" class="form-control"
				placeholder="enter color"  />
		</div>
		<div class="form-group">
			<springform:input path="noOfProducts" class="form-control"
				placeholder="enter number of products" type="number" />
		</div>
		
		<div class="form-group">
			<springform:input path="warrantyInMonths" class="form-control"
				placeholder="enter warranty in months"  />
		</div>
		
		<div class="form-group">
		  <springform:input path="image" type="file"/>
		</div>
		<input type="submit" value="Submit">
	</springform:form>
	</div>
</body>
</html>