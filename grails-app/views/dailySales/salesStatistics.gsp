<%--
  Created by IntelliJ IDEA.
  User: huangsiwei
  Date: 14-10-5
  Time: 上午11:57
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
        function alterTest() {
            var startDate = $(".startDate")
            var startHourAndMin = $(".startHourAndMin")
            var data = {"startDate": startDate, "startHourAndMin": startHourAndMin}
            $.ajax({
                type: "POST",
                url: "/DailySales/fetchSalesInfo",
                data: data
//            success: function (data) {
//                alert(data)
//            }
            })

        }

        $("#test").onClick(
                alert("hehe")
        )
    </script>
</head>

<r:require module="jQuery"/>
<body>
<g:form action="fetchSalesInfo" method="POST">

    请输入开始日期：
    <input type="date" name="startDate">
    <input type="time" name="startHourAndMin">
    <g:submitButton name="确定"/>
</g:form>
<input id="test" value="jquery">
<input type="button" value="click me!" id="test">

</body>

</html>