<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>3rd Exercise</title>
</head>
<body>
	<form action="laptopsInput" method="post">
		Brand: <input type="text" name="brand" /> <input type="submit"
			value="Submit" />
	</form>

	Brand's name : ${brand}
	<br> NO chars: ${count}
	<br> Parity: ${parity}
</body>
</html>