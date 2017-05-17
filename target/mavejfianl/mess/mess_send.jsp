<%--
  Created by IntelliJ IDEA.
  User: 景探
  Date: 2017/5/16
  Time: 7:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div >
    <form action="/message/sendMessage/"+${userId} ,method="post">
        消息内容: <input id="messContent" type="text" name="messContent" />
        发送:<input type="submit">
    </form>
</div>
</body>
</html>
