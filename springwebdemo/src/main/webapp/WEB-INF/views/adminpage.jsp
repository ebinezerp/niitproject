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
<!-- <h1>hiiiiiiiiiiiiiiiii</h1> -->

<table class="table">
 <thead>
  <tr>
   <th>Id</th>
   <th>Name</th>
   <th>Email</th>
   <th>Mobile</th>
   <th>Active</th>
   <th>Operation</th>
  </tr>
 </thead>
 <tbody>
   <c:forEach items="${vendorslist}" var="vendor">
  <tr >
   <td><c:out value="${vendor.vendor_id}"></c:out></td>
   <td><c:out value="${vendor.vendor_name}"></c:out></td>
   <td><c:out value="${vendor.vendor_email}"></c:out></td>
   <td><c:out value="${vendor.vendor_mobile}"></c:out></td>
   <td><c:out value="${vendor.vendor_active}"></c:out></td>
   <c:set var = "status" scope = "session" value = "${vendor.vendor_active}"/>
   <c:choose>
   <c:when test="${ status == false}">
   <td><a href="accept/${vendor.vendor_id }"><input type="button" value="Activate"></a></td>
   </c:when>
   <c:when test="${ status == true}">
    <td><a href="reject/${vendor.vendor_id }"><input type="button" value="Deactivate"></a></td>
   </c:when>
   </c:choose>
  </tr>
   </c:forEach>
 </tbody>
 </table>

</body>
</html>