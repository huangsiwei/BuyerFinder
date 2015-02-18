<%--
  Created by IntelliJ IDEA.
  User: huangsiwei
  Date: 15/2/16
  Time: 上午12:42
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:form action="showGroupMember" method="POST">
    请输入小组URL:<input type="text" name="groupId"/>
    <br>
    <g:submitButton name="提交"></g:submitButton>
</g:form>
</body>
</html>