<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/5
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <title>Title</title>
</head>
<body>
查询所有账户信息
<c:forEach items="${list}" var="account">
  ${account.name}
</c:forEach>
</body>
</html>
