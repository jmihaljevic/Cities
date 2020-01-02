<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<link rel="stylesheet" type="text/css" href="/background.css" />
</head>
<div class="logo">
	<h1>Cities</h1>
</div>
<div class="links">
<a href='/citieslogin.jsp' class="button">Login</a>
<a href='/register.jsp' class="button">Register</a>
<a href='/cities/getAllCities' class="button">All cities</a>
<a href='/cities/sortedByDate' class="button">Cities sorted by created date</a>
<a href='/cities/sortedByMembers' class="button">Cities sorted by popularity</a>

<c:if test="${isAuthenticated}">
    <a href='/cities/createCity' class="button">Create city</a>
    <a href='/cities/addFavoriteCity' class="button">Add favorite city</a>
    <a href='/cities/removeFavoriteCity' class="button">Remove favorite city</a>
    <a href='/cities/userLogout' class="button">Sign out</a>
</c:if>

<div class="clearBoth"></div>
</div>
<div class="main">