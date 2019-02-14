<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration successful</title>
</head>
<body>
<!-- check if article attribute (passed by controller in Model) is not empty. If not get data stored in it-->
<c:if test="${not empty article}">
    <h1><c:out value="${article.title}"/></h1>
    <p>
        <c:out value="${article.content}"/>
    </p>
    <c:if test="${not empty article.tags}">
        <c:forEach var="tag" items="${article.tags}">
            <li><c:out value="${tag}"/></li>
        </c:forEach>
    </c:if>
</c:if>
</body>
</html>