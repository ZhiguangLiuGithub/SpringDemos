<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/5/3
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script >
        //页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //发送ajax请求
                        $.ajax(
                        {
//编写 json,设置属性和值
                            //请求路径
                            url:"user/testAjax",
                            contentType:"application/json;charset=UTF-8",
                            data:'{"username":"ohh","password":"123","age":30}',
                            dataType:"json",
                            type:"post",
                            success:function(data) {
                                //data是指服务器响应的json数据，需要对它进行解析
                           alert(data);
                           alert(data.username);
                           alert(data.password);
                           alert(data.age);
                            }
                    });
            });
        });
    </script>
</head>
<body>
<br>
<button id="btn">发送ajax的请求</button>
</body>
</html>
