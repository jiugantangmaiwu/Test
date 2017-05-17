<%--
  Created by IntelliJ IDEA.
  User: 景探
  Date: 2017/5/15
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>消息页面</title>
</head>
<body>

<table id="userManagetable">
    <tr>
        <th>消息类型</th>
        <th>消息内容</th>
        <th>消息发送时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${messtList}" var="mess">
        <tr>
            <td>${mess.TypeName}</td>
            <td>${user.MessageInfo}</td>
            <td>${user.SendTime}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
