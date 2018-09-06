<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<springform:form action="signup" method="POST" modelAttribute="vendor">
<springform:input path="vendor_name"/>
<springform:input path="vendor_email"/>
<springform:input path="vendor_mobile"/>
<springform:input path="company_name"/>
<springform:input path="vendor_password"/>
<input type="submit" value="Submit">
</springform:form>
</body>
</html>