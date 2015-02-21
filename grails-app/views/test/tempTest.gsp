<%--
  Created by IntelliJ IDEA.
  User: huangsiwei
  Date: 15/2/20
  Time: 上午1:13
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${resource(dir: "css",file: "bootstrap.css")}">
    <script src="${resource(dir: 'js/jquery', file: 'jquery-1.11.1.min.js')}"></script>
    <script src="${resource(dir: 'js/jquery', file: 'bootstrap.min.js')}"></script>
    <style type="text/css">
        .wrapper {
            display: inline-block;
            width: 310px;
            height: 100px;
            vertical-align: top;
            margin: 1em 1.5em 2em 0;
            cursor: pointer;
            position: relative;
            font-family: Tahoma, Arial;
            perspective: 4000px;
        }

        .item {
            height: 100px;
            transform-style: preserve-3d;
            transition: transform .6s;
        }

        .item img {
            display: block;
            position: absolute;
            top: 0;
            padding: 23px;
            border-radius: 3px;
            box-shadow: 0px 3px 8px rgba(0,0,0,0.3);
            background-color: rgba(49, 67, 49, 0.28);
            transform: translateZ(50px);
            transition: all .6s;
        }

        .item .information {
            display: block;
            position: absolute;
            top: 0;
            height: 100px;
            width: 280px;
            text-align: left;
            border-radius: 3px;
            padding: 23px;
            font-size: 16px;
            text-align: center;
            text-shadow: 1px 1px 1px rgba(255,255,255,0.5);
            box-shadow: none;
            background: linear-gradient(to bottombottom,rgba(236,241,244,1) 0%,rgba(190,202,217,1) 100%);
            background-color: #b99a80;
            transform: rotateX(-90deg) translateZ(50px);
            transition: all .6s;

        }

        .item:hover {
            transform: translateZ(-50px) rotateX(95deg);
        }

        .item:hover img {
            box-shadow: none;
            border-radius: 3px;
        }

        .item:hover .information {
            box-shadow: 0px 3px 8px rgba(0,0,0,0.3);
            border-radius: 3px;
            text-align: center;
        }

    </style>
</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <div class="wrapper">
                <div class="item">
                    <img src="../images/test/lg_book@2x.png">
                    <span class="information">
                        寻找对某一本书打高分的豆瓣er
                    </span>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="wrapper">
                <div class="item">
                    <img src="../images/test/lg_movie@2x.png">
                    <span class="information">
                        寻找对某一本书打高分的豆瓣er
                    </span>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="wrapper">
                <div class="item">
                    <img src="../images/test/lg_group_a11@2x.png">
                    <span class="information">
                        寻找对某一本书打高分的豆瓣er
                    </span>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>