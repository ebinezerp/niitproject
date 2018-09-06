<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<springform:form  action="editvendor" method="post" modelAttribute="vendor">
<table>
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
  <tr> <td><springform:input path="vendor_id" type="hidden"/></td></tr>
  <tr> <td><springform:input path="vendor_password" type="hidden"/></td></tr>
  <tr><td><input type="submit" value="Update" name="Update"></td></tr>
</table>
</springform:form>

</body>
</html>