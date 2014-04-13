<%--
  Created by IntelliJ IDEA.
  User: delljins
  Date: 14-4-13
  Time: 下午4:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>
<body>
<table border="1">
    <tr>
        <th>豆邮地址</th>
    </tr>
    <g:each in="${douMailList}" var="douMail">
        <tr>
            <td><a href="${douMail}">${douMail}</a></td>
        </tr>
    </g:each>
</table>
</body>
</html>