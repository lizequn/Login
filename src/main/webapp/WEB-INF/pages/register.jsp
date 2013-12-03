
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>register</h1>
<div>
    <f:form action="registerPro.do" method="post"  commandName="user">
        <div>
            <f:label for="username" path="username">Username:</f:label>
            <f:input path="username"></f:input>
            <f:errors path="username" cssClass="error"></f:errors>
        </div>
        <div>
            <f:label path="password" for="password">password:</f:label>
            <f:password path="password" ></f:password>
            <f:errors path="password" cssClass="error"></f:errors>
        </div>

        <input type="submit">
    </f:form>

</div>

</body>
</html>