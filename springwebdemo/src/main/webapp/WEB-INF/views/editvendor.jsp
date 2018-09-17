<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
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

 <nav class="navbar navbar-expand-sm bg-dark navbar-dark" >
     <div class="container-fluid">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">E-Commerce</a>
        </div>
      
        <ul class="navbar-nav" >
            <li class="nav-item"><a class="nav-link" href="profile">profile</a></li>
            <li class=" active nav-item"><a class="nav-link" href="editvendor">edit-profile</a></li>
            <li class="nav-item"><a class="nav-link" href="addproduct">add-products</a></li>
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
<div class="table-responsive">
<springform:form  action="editvendor" method="post" modelAttribute="vendor">
<table class="table table-striped table-bordered " style="width:300px">
 <%--  <tr>
     <td><springform:input path="accountDetails.account" type="hidden"/></td>
  </tr>
  <tr>
     <td><springform:input path="addresses" type="hidden"/></td>
  </tr> --%>
  <tr>
     <td><label>Company Name</label></td>
     <td><springform:input path="company_name"/></td>
  </tr>
  <tr>
      <td><label>Name</label></td>
     <td><springform:input path="vendor_name"/></td>
  </tr>
  <tr>
       <td><label>email</label></td>
     <td><springform:input path="vendor_email"/></td>
  </tr>
  <tr>
        <td><label>mobile</label></td>
     <td><springform:input path="vendor_mobile"/></td>
  </tr>
  <springform:input path="vendor_id" type="hidden"/>
 <springform:input path="vendor_password" type="hidden"/>
  <tr><td><input type="submit" value="Update" name="Update"></td></tr>
</table>
</springform:form>
</div>
</body>
</html>