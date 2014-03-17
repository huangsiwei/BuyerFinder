<%--
  Created by IntelliJ IDEA.
  User: delljins
  Date: 14-3-15
  Time: 下午9:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:form action="showMovieFans" method="post">
    请输入豆瓣电影URL：<input name="url" placeholder="请输入短评起始页"/>
    <g:submitButton name="确定"/>
</g:form>
</body>
</html>