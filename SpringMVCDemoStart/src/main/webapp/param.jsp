<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/1
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--请求参数绑定--%>>
<%--a href="param/testParam?username=jiajia">请求参数绑定</a--%>


<%--把数据封装到 Account，类中存在 List 和 Map 集合--%>

<%--form action="param/saveAccount" method ="post">
    姓名：<input type="text" name="username"/><br/>
    密码：<input type="text" name="password"/><br/>
    金额：<input type="text" name="money"/><br/>
    用户姓名： <input type="text" name="list[0].uname"/><br/>
    用户年龄：  <input type="text" name="list[0].age"/><br/>

    用户姓名： <input type="text" name="map['one'].uname"/><br/>
    用户年龄：  <input type="text" name="map['one'].age"/><br/>

    <input type="submit" value="提交" />
</form--%>


<%--自定义类型转换器--%>

<form action="param/saveUser" method ="post">
    用户姓名： <input type="text" name="uname"/><br/>
    用户年龄：  <input type="text" name="age"/><br/>
    用户生日：<input type="text" name="date"/><br/>
    <input type="submit" value="提交" />
</form>



<a href="/param/testServlet">
    Servlet  原生API
</a>

</body>
</html>
