<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
            <a href="#" class="navbar-brand">E-Commerce</a>
        </div>
        <ul class="navbar-nav" >
            <li class=" active nav-item"><a class="nav-link" href="profile">profile</a></li>
            <li class="nav-item"><a class="nav-link" href="editvendor">edit-profile</a></li>
            <li class="  nav-item"><a class="nav-link" href="addproduct">add-products</a></li>
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


<h1>Vendor Profile</h1>
   <table>
       <tr>
       <td>Name:</td><td>${vendor.vendor_name}</td>
       </tr>
        <tr>
       <td>Email:</td><td>${vendor.vendor_email}</td>
       </tr>
        <tr>
       <td>Mobile:</td><td>${vendor.vendor_mobile}</td>
       </tr>
        <tr>
       <td>Company:</td><td>${vendor.company_name}</td>
       </tr>
    </table>
<!-- <h3><a href="editvendor">Edit</a></h3>

<h3><a href="addproduct">addProducts</a></h3>

<h3><a href="products">view products</a></h3>
 -->
</body>
</html>