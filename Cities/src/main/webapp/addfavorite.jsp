<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add favorite city:</title>
</head>
<body>
<jsp:include page="/header.jsp" />
<form method="post" action="addCityToFavorites">
    City name:<input type="text" name="cityName"/><br/>
    <input type="submit" value="add"/>
</form>
<jsp:include page="/footer.jsp" />
</body>
</html>