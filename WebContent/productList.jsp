<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
<%@ page import= "java.util.* , com.accenture.lkm.entity.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

		<style>
		#products {
		    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
		    border-collapse: collapse;
		    width : 60%;
		}
		
		#products td, #products th {
		    border: 1px solid #ddd;
		    padding: 8px;
		}
		
		#products tr:nth-child(even){background-color: #f2f2f2;}
		
		#products tr:hover {background-color: #ddd;}
		
		#products th {
		    padding-top: 12px;
		    padding-bottom: 12px;
		    text-align: left;
		    background-color: #4CAF50;
		    color: white;
		}
		</style>

</head>

<body>

	<%
		//String greet = (String) request.getAttribute("greet");
		
		List<Product> products = (List<Product>) request.getAttribute("products");
	%>
	
	<table id="products"   align = "center" >
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Brand</th>
			<th>Price</th>
			<th>Description</th>
		</tr>
		
		<% for(Product product : products) { %>
			<tr>
				<td><%= product.getId() %></td>
				<td><%= product.getName() %></td>
				<td><%= product.getBrand() %></td>
				<td><%= product.getPrice() %></td>
				<td><%= product.getDescription() %>  </td>
			</tr>	
			
			
		<% } %>
	</table>
	
</body>
</html>