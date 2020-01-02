<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<jsp:include page="/header.jsp" />
        <h2>List of all cities:</h2>

		<ul>
			<c:forEach items="${cities}" var="city"  >
				<li>${city}</li>
			</c:forEach>

		</ul>

		<jsp:include page="/footer.jsp" />
	</body>
</html>