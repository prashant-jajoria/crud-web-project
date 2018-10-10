<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "my" uri = "https://accenture.com/jsp/tlds/mycustomtags" %>  

<c:set var = "contextRoot" value = "${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product List</title>
	</head>

	<body>
		<jsp:useBean id="dateBean" class="com.accenture.lkm.beans.DateBean" scope="session"></jsp:useBean>
		
		<jsp:setProperty property="content" name="dateBean" value = "Set in Product List" />
		
		<h1>${contextRoot} - <jsp:getProperty property="date" name="dateBean"/> </h1>
		
		<table align = center border = 2 width = 60% >
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Price</th>
				
			</tr>

			<c:forEach  items = "${products}" var = "product" >
				<tr>
					<td> ${product.id} </td>
					<my:tdcolor color="#000fff" content="${product.name}"></my:tdcolor>
					<td> ${product.brand} </td>
					<my:tdcolor color="#fff000" content="${product.price}"></my:tdcolor>
					<td> ${product.description} </td>
					<td>
						<a href = "${contextRoot}/ProductController?action=edit&id=${product.id}">Edit</a>
						<a href = "${contextRoot}/ProductController?action=delete&id=${product.id}">Delete</a>
					</td>				
				</tr>
			</c:forEach>
		</table>
		
		<a href = "${contextRoot}/ProductController?action=add">Add New Product</a>
		
	</body>
</html>