<%--
  Created by IntelliJ IDEA.
  User: huangsiwei
  Date: 15/2/19
  Time: 下午10:11
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${resource(dir: "css",file: "bootstrap.css")}">
    <script src="${resource(dir: 'js/jquery', file: 'jquery-1.11.1.min.js')}"></script>
    <script src="${resource(dir: 'js/jquery', file: 'bootstrap.min.js')}"></script>
    <style type="text/css">
        .intro-header {
            text-align: center;
            background-image: url("../images/intro-bg.jpg");
            background-size: cover;
        }
        .intro-message {
            padding-top: 228px;
            padding-bottom: 228px;
        }
        .intro-message h1 {
            text-align: center;
            font-size: 70px;
            text-shadow: rgba(27, 22, 86, 0.29) 2px 2px 3px;
            color: #ffffff;
        }
        .intro-message h3 {
            text-align: center;
            font-size: 40px;
            color: #ffffff;
        }
        .intro-divider {
            margin-left: 370px;
            margin-right: 370px;
            width: 400px;
            height: 3px;
            color: #180000;
        }
        .list-inline {
            text-align: center;
        }
        .list-inline li {
            text-align: center;
        }
    </style>
</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
    <div class="container topnav">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand topnav" href="#">Start Bootstrap</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#about">About</a>
                </li>
                <li>
                    <a href="#services">Services</a>
                </li>
                <li>
                    <a href="#contact">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<div class="intro-header">
    <div class="container">
        <div class="row">
            <div class="intro-message">
                <h1>Find Doubaner</h1>
                <h3>A Template by Start Bootstrap</h3>
                <hr class="intro-divider">
                <ul class="list-inline">
                    <li>
                        <a href="" class="btn btn-lg btn-info">
                            <i></i>
                            <span>试用一下</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>