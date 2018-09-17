<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
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
            <li class="nav-item"><a class="nav-link" href="${path }/profile">profile</a></li>
            <li class="nav-item"><a class="nav-link" href="${path }/editvendor">edit-profile</a></li>
            <li class="nav-item"><a class="nav-link" href="${path }/addproduct">add-products</a></li>
            <li class="nav-item"><a class="nav-link" href="${path }/products">view products</a></li>
           <li>
             <div class="dropdown " style="padding-top:10px">
              <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"><span class="caret"></span></button>             
              <div class="dropdown-menu dropdown-menu-right">
              <a class="dropdown-item" href="${path }/editvendor">edit</a>
              <a class="dropdown-item" href="${path }/addproduct">addProducts</a>
              <a class="dropdown-item" href="${path }/products">view products</a>
              <a class="dropdown-item" href="#">logout</a>
              </div>
            
            </div>
          </li>
             </div>
        </ul>
      
    </nav>
<div style="display:flex">
<div style="flex:2"></div>
<div style="width:500px;flex:2;">
<springform:form method="post" action="${path }/editmobiledetails"
		modelAttribute="mobile" enctype="multipart/form-data">
		<springform:input path="productId" type="hidden"
			 />
	    <springform:input path="subCategory.subCategory_id" type="hidden"
			 />
	    <springform:input path="vendor.vendor_id" type="hidden"
			 />

		<div class="form-group">
			<springform:input path="product_brand" class="form-control"
				placeholder="enter brand" type="text" />
		</div>
		<div class="form-group">
			<springform:input path="product_model" class="form-control"
				placeholder="enter model" type="text" />
		</div>
		<div class="form-group">
			<springform:input path="product_color" class="form-control"
				placeholder="enter color" type="text" />
		</div>
		<div class="form-group">
			<springform:input path="mobile_ram" class="form-control"
				placeholder="enter ram" type="number" />
		</div>
		<div class="form-group">
			<springform:input path="mobile_rom" class="form-control"
				placeholder="enter rom" type="number" />
		</div>
		<div class="form-group">4G/LTE:
			<springform:radiobutton path="mobile_lte" value="true" />True
			<springform:radiobutton path="mobile_lte" value="false" />False
		</div>
		<div class="form-group">
			<springform:input path="mobile_os" class="form-control"
				placeholder="enter os" type="text" />
		</div>
		<div class="form-group">
			<springform:input path="mobile_weight" class="form-control"
				placeholder="enter weight" type="number" />
		</div>
		<div class="form-group">
			<springform:input path="mobile_display_size" class="form-control"
				placeholder="enter size" type="number" />
		</div>
		<div class="form-group">
			<springform:input path="mobile_frontcam" class="form-control"
				placeholder="enter frontcam pixels" type="number" />
		</div>
		<div class="form-group">
			<springform:input path="mobile_rearcam" class="form-control"
				placeholder="enter rearcam pixels" type="number" />
		</div>
		<div class="form-group">
			<springform:input path="noOfProducts" class="form-control"
				placeholder="enter number of products" type="number" />
		</div>
		<div class="form-group">
			<springform:input path="mobile_description" class="form-control"
				placeholder="enter description" type="text" />
		</div>
		<div class="form-group">
			<springform:input path="warrantyInMonths" class="form-control"
				placeholder="enter warranty in months" type="text" />
		</div>
		
		<div class="form-group">
		  <springform:input path="image" type="file"/>
		</div>
		<input type="submit" value="Submit">
	</springform:form>

</div>
<div style="flex:2"></div>
</div>
</body>
</html>