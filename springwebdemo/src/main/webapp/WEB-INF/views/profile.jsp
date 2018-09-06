<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
<h3><a href="editvendor">Edit</a></h3>
</body>
</html>