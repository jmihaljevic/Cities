<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Remove favorite city:</title>
</head>
<body>
<jsp:include page="/header.jsp" />
<form method="post" action="removeFromFavorites">
    City name:<input type="text" name="removedCityName"/><br/>
    <input type="submit" value="remove"/>
</form>
<jsp:include page="/footer.jsp" />
</body>
</html>