<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div class="container">
<springform:form action="signup" method="POST" modelAttribute="vendor">
 <div class="form-group">
      <springform:input path="vendor_name" class="form-control" placeholder="enter name" type="text"/>
      <springform:errors path="vendor_name"></springform:errors>
    </div>
    
    <div class="form-group">
      <springform:input path="vendor_email" class="form-control" placeholder="enter email" type="email"/>
      <springform:errors path="vendor_email"></springform:errors>
    </div>
    
     <div class="form-group">
      <springform:input path="vendor_mobile" class="form-control" placeholder="enter mobile"/>
      <springform:errors path="vendor_mobile"></springform:errors>
    </div>
    
     <div class="form-group">
      <springform:input path="company_name" class="form-control" placeholder="enter company name"/>
      <springform:errors path="company_name"></springform:errors>
    </div>
    
     <div class="form-group">
      <springform:input path="vendor_password" class="form-control" placeholder="enter password" type="password"/>
      <springform:errors path="vendor_password"></springform:errors>
    </div>
    
    <input type="submit" value="Submit" class="btn btn-default">
</springform:form>
</div>
</body>
</html>