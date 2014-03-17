<%--
  Created by IntelliJ IDEA.
  User: delljins
  Date: 14-3-16
  Time: 下午4:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>
<body>

<h1>${movieName}观众如下</h1>

<table border="2">
    <tr>
        <th>评论者</th>
        <th>个人主页</th>
        <th>分数</th>
        <th>评论时间</th>
    </tr>
    <g:each in="${movieReviewList}" var="moviewReview">
        <g:if test="${moviewReview.score == "力荐"}">
            <tr bgcolor="#FF9B73">
                <td>${moviewReview.userName}</td>
                <td>${moviewReview.homePage}</td>
                <td>${moviewReview.score}</td>
                <td><g:formatDate date="${moviewReview.reviewDate}" format="yyyy-MM-dd"/> </td>
            </tr>
        </g:if>
        <g:elseif test="${moviewReview.score=="推荐"}">
            <tr bgcolor="#FFE773">
                <td>${moviewReview.userName}</td>
                <td>${moviewReview.homePage}</td>
                <td>${moviewReview.score}</td>
                <td><g:formatDate date="${moviewReview.reviewDate}" format="yyyy-MM-dd"/></td>
            </tr>
        </g:elseif>
        <g:else>
            <tr>
                <td>${moviewReview.userName}</td>
                <td>${moviewReview.homePage}</td>
                <td>${moviewReview.score}</td>
                <td><g:formatDate date="${moviewReview.reviewDate}" format="yyyy-MM-dd"/></td>
            </tr>
        </g:else>
    </g:each>
</table>
</body>
</html>