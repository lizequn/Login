<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cmdadmin
  Date: 12/12/13
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<table>
    <thead>
    <th>User</th>
    <th>Info</th>
    </thead>
    <c:forEach items= "${info}" var="d">
        <tr>
            <td>${d.userInfo}</td>
            <td>${d.info}</td>
        </tr>
    </c:forEach>
</table>
<form action="/addInfo.do" method="post">
    <input type="text" name="addInfo">
    <input type="submit">
</form>
<a href="/logout.do">logout</a>

</body>
</html>