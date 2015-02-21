<%--
  Created by IntelliJ IDEA.
  User: huangsiwei
  Date: 15/2/20
  Time: 下午4:40
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${resource(dir: "css",file: "bootstrap.css")}">
    <script src="${resource(dir: 'js/jquery', file: 'jquery-1.11.1.min.js')}"></script>
    <script src="${resource(dir: 'js/jquery', file: 'bootstrap.min.js')}"></script>
    <style type="text/css">
        .title {
            text-align: center;
        }
        .row {
            padding-top: 50px;
            padding-left: 250px;
            padding-right: 250px;
        }
        .group-query-container {
            padding-top: 50px;
            padding-left: 100px;
            padding-right: 100px;
            text-align: center;
        }

    </style>
</head>

<body>

<h1 class="title">推荐小组列表</h1>

%{-- 精选 文化 行摄 娱乐 时尚 生活 科技--}%

<div class="row">
    <div class="col-md-12">
        <div class="panel with-nav-tabs panel-default">
            <div class="panel-heading">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab1default" data-toggle="tab">精选</a></li>
                    <li class=""><a href="#tab2default" data-toggle="tab">文化</a></li>
                    <li class=""><a href="#tab3default" data-toggle="tab">行摄</a></li>
                    <li class=""><a href="#tab3default" data-toggle="tab">娱乐</a></li>
                    <li class=""><a href="#tab3default" data-toggle="tab">时尚</a></li>
                    <li class=""><a href="#tab3default" data-toggle="tab">生活</a></li>
                    <li class=""><a href="#tab3default" data-toggle="tab">科技</a></li>

                </ul>
            </div>
            <div class="panel-body">
                <div class="tab-content">
                    <div class="tab-pane fade active in" id="tab1default">Default 1</div>
                    <div class="tab-pane fade" id="tab2default">Default 2</div>
                    <div class="tab-pane fade" id="tab3default">Default 3</div>
                    <div class="tab-pane fade" id="tab4default">Default 4</div>
                    <div class="tab-pane fade" id="tab5default">Default 5</div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="group-query-container">
    <em>没有你要的？请输入小组名称或者id进行查找: <input name="queryKey" type="text"></em> <button class="btn btn-sm btn-info" onclick="queryMoreGroupInfo()">查询</button>
</div>

<div class="group-info-container">

</div>

<script>
    function queryMoreGroupInfo() {
        var queryKey = $("input[name=queryKey]").val();
        if (queryKey) {
            $.ajax({
                url:"${createLink(action: "queryMoreGroupInfo")}",
                data:queryKey,
                success: function () {
                    
                },
                error: function (error) {
                    console.log(error);
                }
            })
        }
    }
</script>

</body>
</html>