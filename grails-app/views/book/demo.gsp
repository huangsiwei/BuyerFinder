<%--
  Created by IntelliJ IDEA.
  User: delljins
  Date: 14-4-15
  Time: 下午8:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>
<body>
    <g:form action="showBookReader" method="POST">
        请输入书籍URL:<input type="text" name="bookId"/>
        <br>
        从<input type="text" name="startPage"/>到<input type="text" name="endPage"/>页
        <g:submitButton name="提交"></g:submitButton>
    </g:form>
</body>
</html>