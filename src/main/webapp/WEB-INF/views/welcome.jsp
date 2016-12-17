<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<link rel="stylesheet" 
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
		
	<title>Hello</title>
</head>
<body>
	
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${greeting }</h1>
				<p>${tagline }</p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
			</div>	
			
		</div>
	</section>	
	
</body>
</html>