<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<meta content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" 
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
		
	<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Product</h1>
			</div>
		</div>
	</section>	
	<section class="cotainer">
		<div class="row">
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Product code:</strong>
					<span class="label label-warning">
						${product.productId}
					</span>
				</p>
				<p>
					<strong>Manufacturer:</strong>
					${product.manufacturer }
				</p>
				<p>
					<strong>Category:</strong>
					${product.category }
				</p>
				<p>
					<strong>Units available:</strong>
					${product.unitsInStock }
				</p>
				<h4>
					${product.unitPrice }USD
				</h4>
				<p>
					<a href="<spring:url value='/products' />" class="btn btn-default">
						<span class="glyphicon glyphicon-hand-left"></span>Go back
					</a>
					<a href="#" class="btn btn-warning btn-large">
						<span class="glyphicon-shopping-cart glyphicon"></span>
						Order now
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>