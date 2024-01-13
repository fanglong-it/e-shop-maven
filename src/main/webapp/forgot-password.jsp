<%--
  Created by IntelliJ IDEA.
  User: longpc
  Date: 1/14/24
  Time: 12:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forgot-password</title>
    <jsp:include page="components/head.jsp"></jsp:include>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h3 class="text-center">Forgot Password</h3>
            <form method="post" action="ForgotPassword" class="form-group">
                <input class="form-control" type="email" name="email" placeholder="Enter your email address">
                <input type="submit" class="btn btn-primary mt-2" value="Click here to reset your password">
            </form>
            <c:if test="${requestScope.MESSAGE != null}">
                <p class="text-danger">${requestScope.MESSAGE}</p>
            </c:if>
        </div>
    </div>
</div>
<jsp:include page="components/footer.jsp"></jsp:include>
</body>
</html>
