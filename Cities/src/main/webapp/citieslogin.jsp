<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login form</title>
</head>
<body>
<jsp:include page="/header.jsp" />
    <c:if test="${isAuthenticated}">
       <h2>You are already logged in</h2>
    </c:if>
    <c:if test="${!isAuthenticated}">
    <form method="post" action="userLogin">
        Email:<input type="text" name="email"/><br/>
        Password:<input type="password" name="pass"/><br/>
        <input type="submit" value="login"/>
    </form>
    </c:if>
<jsp:include page="/footer.jsp" />
</body>
</html>