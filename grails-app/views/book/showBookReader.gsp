<%--
  Created by IntelliJ IDEA.
  User: delljins
  Date: 14-4-20
  Time: 下午3:52
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
    <g:each in="${favReaderDouMailList}" var="douMail">
        <tr>
            <td><a href="${douMail}">${douMail}</a></td>
        </tr>
    </g:each>
</table>
</body>
</html>