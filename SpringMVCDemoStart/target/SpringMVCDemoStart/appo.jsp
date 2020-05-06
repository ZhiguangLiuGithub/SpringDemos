<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/2
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--常用的注解--%>
<a href="anno/testRequestParam?name=ohh">RequestParam</a>

<br>
<form action="anno/testModelAttribute" method ="post">
    用户姓名： <input type="text" name="username"/><br/>
    用户年龄：  <input type="text" name="age"/><br/>
    <input type="submit" value="提交" />
</form>

<%--a href="anno/testCookieValue">
    testCookieValue
</a--%>
<br>

<a href="anno/testSessionAttributes">SessionAttributes</a>
<a href="anno/getSessionAttributes">SessionAttributes</a>
</body>
</html>
