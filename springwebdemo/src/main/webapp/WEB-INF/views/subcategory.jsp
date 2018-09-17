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
 <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top"  >
     <div class="container-fluid">
        <div class="navbar-header">
            <a href="index" class="navbar-brand">E-Commerce</a>
        </div>
      
        <ul class="navbar-nav" >
            <li class="nav-item"><a class="nav-link" href="profile">profile</a></li>
            <li class="nav-item"><a class="nav-link" href="editvendor">edit-profile</a></li>
            <li class=" active nav-item"><a class="nav-link" href="addproduct">add-products</a></li>
            <li class=" nav-item"><a class="nav-link" href="products">view products</a></li>
           <li>
             <div class="dropdown " style="padding-top:10px">
              <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"><span class="caret"></span></button>             
              <div class="dropdown-menu dropdown-menu-right">
              <a class="dropdown-item" href="editvendor">edit</a>
              <a class="dropdown-item" href="addproduct">addProducts</a>
              <a class="dropdown-item" href="products">view products</a>
              <a class="dropdown-item" href="#">logout</a>
              </div>
            
            </div>
          </li>
             </div>
        </ul>
      
    </nav>

<div style="width:200px;margin-top:100px">
<form method="post" action="getproductmodel">
<div class="form-group">
  <label for="sel1">Select list:</label>
  <select class="form-control" id="sel1" name="subcategory">
   <c:forEach items="${subcategorieslist}" var="subCategory">
   <option value="${subCategory.subCategory_id}" >${subCategory.subCategory_name}</option>
   </c:forEach>
  </select>
  <input type="submit" value="Submit">
</div>
</form>
</div>
</body>
</html>