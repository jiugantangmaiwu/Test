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
    <title>用户信息页面</title>
</head>
<body>

<table id="userManagetable">
    <tr>
        <th>昵称</th>
        <th>性别</th>
        <th>电话</th>
        <th>地址</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${usertList}" var="user">
        <tr>
            <td>${user.nickname}</td>
            <td>${user.gender}</td>
            <td>${user.phone}</td>
            <td>${user.address}</td>
            <td><a href="/message/index/"+${user.userId}>查看消息</a>
            <td><a href="/message/showMessage/"+${user.userId}>发送消息</a>
        </tr>
    </c:forEach>
</table>

</body>
</html>
