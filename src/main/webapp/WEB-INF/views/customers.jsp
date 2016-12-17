<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html">
<html>
<head>
<meta content="text/html; charset=ISO-8859-1">
	<title>Customers Tab</title>
		<link rel="stylesheet" 
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
</head>
<body>
		
<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Customers</h1>
		</div>
	</div>
</section>	

<section>
	<div class="row">
		<c:forEach items="${customers}" var="customer">
			<div class="col-sm-4 col-xs-3">
				<div class="thumbnail">
					<div class="caption">
						<h3>${customer.firstName} ${customer.lastName}</h3>
						<p>${customer.address}</p>
						<p>orders made: ${customer.numberOfOrdersMade}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>
</body>
</html>