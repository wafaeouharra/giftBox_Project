<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Our users :</h1>
<ul>
    <c:forEach items="${ msg }" var="usr" varStatus="status">
        <p>Id : <c:out value="${ usr.idUser }" /> : <c:out value="${ usr.nomUser }" /></p>
    </c:forEach>
</ul>
<h1>${msg.get(0).nomUser}</h1>
</body>
</html>