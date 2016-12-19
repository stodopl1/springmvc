<%@page pageEncoding="UTF-8" contentType="text/html; charset=ISO-8859-1" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta content="text/html; charset=ISO-8859-1">
	<title>Products</title>
		<link rel="stylesheet" 
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
</head>
<body>
	<section>
		<div class="container">
			<h1>Products</h1>
			<p>add products</p>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Log in</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error }">
							<div class="alert alert-danger">
								<spring:message code="AbstractUSerDetailsAuthenticationProvider.badCredentials" /><br />
							</div>
						</c:if>
						<form action="<c:url value="/j_spring_security_check"> </c:url>" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="user name" name="j_username" type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="password" name="j_password" value="">
								</div>
								<input class="btn btn-lg btn-success btn-block" type="submit" value="Log in">
							</fieldset>
						</form>						
					</div>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>





















