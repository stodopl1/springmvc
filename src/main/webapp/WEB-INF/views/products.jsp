<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
				<h1>All products available in our shop</h1>
			</div>
		</div>
	</section>	
	<section class="cotainer">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<img src="<c:url value='/resource/images/${product.productId}.jpg'></c:url>" 
							alt="image" style="width:100%">
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p>${product.unitPrice}USD</p>
							<p>Units available: ${product.unitsInStock}</p>
							<p>
								<a href=" <spring:url value='/products/product?id=${product.productId}' />"
									class="btn btn-primary">
									<span class="glyphicon glyphicon-info-sign"></span>Details
								</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	
</body>
</html>




















