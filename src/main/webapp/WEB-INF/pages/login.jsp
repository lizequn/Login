
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>register</h1>
<div>
    <f:form action="register.do" method="post"  commandName="user">
        <f:input path="username"></f:input>
        <f:input path="password"></f:input>
        <input type="submit">
    </f:form>

</div>

</body>
</html>