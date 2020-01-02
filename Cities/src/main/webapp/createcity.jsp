<html>
	<head>
		<title>Creating city</title>
	</head>
	<body>
	<jsp:include page="/header.jsp" />
		<form action="addNewCity" method="POST">
			City name: <input type="text" name="cityname" />
			Description: <input type="text" name="description" />
			Population: <input type="text" name="population" />
			<input type="submit" value="create" />
		</form>
	<jsp:include page="/footer.jsp" />
	</body>
</html>