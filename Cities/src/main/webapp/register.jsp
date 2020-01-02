<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register form</title>
</head>
<body>
    <jsp:include page="/header.jsp" />
    <c:if test="${isAuthenticated}">
       <h2>You are already logged in</h2>
    </c:if>
    <c:if test="${!isAuthenticated}">
    <form method="post" action="register">
        Name:<input type="text" name="name"/><br/>
        Email:<input type="text" name="email"/><br/>
        Password:<input type="text" name="pass"/><br/>
        <input type="submit" value="register"/>
    </form>
    </c:if>
    <jsp:include page="/footer.jsp" />
</body>
</html>