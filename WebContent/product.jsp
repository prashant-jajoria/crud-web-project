<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  

  
<c:set var = "contextRoot" value = "${pageContext.request.contextPath}" />
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="dateBean" class="com.accenture.lkm.beans.DateBean" scope = "session"></jsp:useBean>
	<jsp:useBean id="dateBean1" class="com.accenture.lkm.beans.DateBean" scope = "page"></jsp:useBean>
	
	<jsp:getProperty property="content" name="dateBean"/>
	<jsp:getProperty property="content" name="dateBean1"/>
	
	<%
		out.print("some value");
	%>

	<fieldset style = "width: 60%; margin : 0 auto;" >
		<legend>New Product Form</legend>
		
		<form action = "${contextRoot}/ProductController?action=save" method ="POST">
		<input type="hidden" name ="id" value = "${product.id}" />
		<table>
			
			<tr>
				<td>
					<label for "name" >Enter Product Name : </label>
				</td>
				<td>
					<input type = "text" name = "name" id = "name"  value = "${product.name}"  placeholder="Product Name"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<label for "name" >Enter Brand Name : </label>
				</td>
				<td>
					<input type = "text" name = "brand" id = "brand" value = "${product.brand}"  placeholder="Brand Name"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<label for = "id">Enter Price : </label>
				</td>
				<td>
					<input type = "number" name = "price"  id = "price" value = "${product.price}"  placeholder="Product Price"/>
				</td>
			</tr>
			
			
			<tr>
				<td>
					<label for = "id">Enter Description : </label>
				</td>
				<td>
					<textarea rows="4" cols="50"   name = "description"  id = "description" >${product.description}</textarea>
				</td>
			</tr>
		
			<tr>
				<td colspan = 2 >
					<input type = "submit" value= "Add Product" />				
				</td>
			</tr>
		</table>
	</fieldset>
	



</body>
</html>