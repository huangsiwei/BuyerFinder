<%--
  Created by IntelliJ IDEA.
  User: huangsiwei
  Date: 15/1/26
  Time: 上午12:32
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:form action="showEventFans" method="POST">
    请输入书籍URL:<input type="text" name="eventId"/>
    <br>
    <g:submitButton name="提交"></g:submitButton>
</g:form>
</body>
</html>