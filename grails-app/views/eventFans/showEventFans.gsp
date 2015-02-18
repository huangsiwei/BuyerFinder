<%--
  Created by IntelliJ IDEA.
  User: huangsiwei
  Date: 15/1/26
  Time: 上午1:43
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
    <g:each in="${eventFansDouMailList}" var="douMail">
        <tr>
            <td><a href="${douMail}">${douMail}</a></td>
        </tr>
    </g:each>
</table>

</body>
</html>