<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<jsp:include page="/header.jsp" />
        <h2>Cities sorted by popularity:</h2>
		<ul>
			<c:forEach items="${sortedCities}" var="city"  >
				<li>${city.cityName} - ${city.count}</li>
			</c:forEach>

		</ul>

		<jsp:include page="/footer.jsp" />
	</body>
</html>