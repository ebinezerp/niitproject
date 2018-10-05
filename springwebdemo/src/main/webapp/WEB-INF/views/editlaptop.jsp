<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

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
</head>
<body>
<c:set value="${pageContext.request.contextPath }"  var="contextPath"></c:set>
	<springform:form method="POST" action="${contextPath }/vendor/editlaptopdetails"
		modelAttribute="laptop"  enctype="multipart/form-data">
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
			<springform:input path="product_color" class="form-control"
				placeholder="enter color"  />
		</div>
		<div class="form-group">
			<springform:input path="price" class="form-control"
				placeholder="enter price"  />
		</div>
		<div class="form-group">
			<springform:input path="laptop_ram" class="form-control"
				placeholder="enter ram"  />
		</div>
		<div class="form-group">
			<springform:input path="laptop_rom" class="form-control"
				placeholder="enter rom"  />
		</div>
		<div class="form-group">
			<springform:input path="laptop_os" class="form-control"
				placeholder="enter os"  />
		</div>
		<div class="form-group">
			<springform:input path="laptop_graphic_card" class="form-control"
				placeholder="enter graphic card"  />
		</div>
		<div class="form-group">
			<springform:input path="laptop_processor" class="form-control"
				placeholder="enter processor"  />
		</div>
		<div class="form-group">
			<springform:input path="laptop_weight" class="form-control"
				placeholder="enter weight"  />
		</div>
		<div class="form-group">
			<springform:input path="laptop_size" class="form-control"
				placeholder="enter size"  />
		</div>
		<div class="form-group">
			<springform:input path="noOfProducts" class="form-control"
				placeholder="enter number of products"  />
		</div>
		<div class="form-group">
			<springform:input path="laptop_description" class="form-control"
				placeholder="enter description"  />
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

</body>
</html>