<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

	<table>
		<thead>
			<tr>
				<th><c:out value="${name}"></c:out></th>
			</tr>
		</thead>
		<tbody>
		<tr>
		<td>Brand</td>
		<td><c:out value="${mobile.product_brand }"></c:out> </td>
		</tr>
		<tr>
		<td>Model</td>
		<td><c:out value="${mobile.product_model }"></c:out> </td>
		</tr>
		<tr>
		<td>Color</td>
		<td><c:out value="${mobile.product_color }"></c:out> </td>
		</tr>
		<tr>
		<td>Display Size</td>
		<td><c:out value="${mobile.mobile_display_size }"></c:out> </td>
		</tr>
		<tr>
		<td>Operating System</td>
		<td><c:out value="${mobile.mobile_os }"></c:out> </td>
		</tr>
		<tr>
		<td>4G/LTE</td>
		<td><c:out value="${mobile.mobile_lte }"></c:out> </td>
		</tr>
		<tr>
		<td>Ram</td>
		<td><c:out value="${mobile.mobile_ram }"></c:out> </td>
		</tr>
		<tr>
		<td>Internal memory</td>
		<td><c:out value="${mobile.mobile_rom }"></c:out> </td>
		</tr>
		<tr>
		<td>Front cam</td>
		<td><c:out value="${mobile.mobile_frontcam }"></c:out> </td>
		</tr>
		<tr>
		<td>Internal memory</td>
		<td><c:out value="${mobile.mobile_rearcam }"></c:out> </td>
		</tr>
		<tr>
		<td>Weight</td>
		<td><c:out value="${mobile.mobile_weight }"></c:out> </td>
		</tr>
		<tr>
		<td>Description</td>
		<td><c:out value="${mobile.mobile_description}"></c:out> </td>
		</tr>
		</tbody>

	</table>


</body>
</html>