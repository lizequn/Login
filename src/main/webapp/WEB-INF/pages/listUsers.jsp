
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <thead>
    <th>username</th>
    <th>password</th>
    </thead>
<c:forEach items= "${list}" var="d">
    <tr>
        <td>${d.username}</td>
        <td>${d.password}</td>
    </tr>

</c:forEach>
</table>
</body>
</html>