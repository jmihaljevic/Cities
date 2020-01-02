<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<jsp:include page="/header.jsp" />
        <c:if test="${!isAuthenticated}">
            <h2>Wellcome, for more options please log in</h2>
        </c:if>
        <c:if test="${isAuthenticated}">
            <h2>Wellcome, ${name}</h2>
        </c:if>

		<jsp:include page="/footer.jsp" />
	</body>
</html>