<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/idx.css">
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        #list_nav li {
            margin-left: 25px;
            font-size: 16px;
        }
        #list_nav li a:link{
            color: #000000;
        }
        #list_nav li a:link{
            color: #000000;
        }
        #list_nav li a:hover{
            color: #005cf9;
        }
        #list_nav li a{
            text-decoration: none;
        }
        .list-inline li div{
            margin-top: 10px;
        }
        ul li{
            list-style: none;
            margin-top: 9px;
        }
        .link:link{
            color: #000000;
            font:  bold 18px 文鼎特粗黑簡;
            text-decoration: none;
        }
        .link:hover{
            color: #005cf9;
            transition: all .2s;
        }
        a:hover{
            color: #005cf9;
        }

        /* 设置二级菜单绝对定位，并隐藏 */
        .menuDiv > ul > li > ul {
            position: absolute;
            display: none;
        }
        /* 设置二级菜单的li的样式 */
        .menuDiv > ul > li > ul > li {
            float: none;
            transition: all .2s;
        }
        /* 鼠标放在一级菜单上，显示二级菜单 */
        .menuDiv > ul > li:hover ul {
            display: inline-block;
            width: 200px;
            height: auto;
            opacity: initial;

        }
        /* 在一级菜单中，第一个不设置左边框 */
        .menuDiv > ul > li:first-child > a {
            border-left: none;
            width:auto;
            height: auto;
            display: inline-block;
        }

        /* 在一级菜单中，鼠标放上去的样式 */
        .menuDiv > ul > li > a:hover {
            color: #f0f;
            background-color: #bcf;
            display: inline-block;
        }
        /* 在二级菜单中，第一个设置顶边框 */
        .menuDiv > ul > li > ul > li:first-child > a {
            border-top: 1px solid #ccc;

        }

        /* 在二级菜单中，鼠标放上去的样式 */
        .menuDiv > ul > li > ul > li > a:hover {
            color: #a4f;
            background-color: #cdf;
        }
        /* -------------菜单css代码----------end---------- */

    </style>
</head>
<body>
<div style="height: 80px;width: 100%">
    <!--这是网站Logo-->
    <div class="container">

        <div class="row">
            <div class="col-md-3 pull-right">
                <!--<a href="/login">你好陌生人,我是小众众,点击我登录!</a>-->
                <#if Session["uid"] ?exists>
                    欢迎您,${(Session["uid"])!'重新登陆'}!<a href="#" style="padding-left: 15px;font:13px/1.5 'Microsoft Yahei','Simsun'">消息</a><a href="/Cancellation" style="padding-left: 13px;font:13px/1.5 'Microsoft Yahei','Simsun'">退出</a>
                <#else >
                    <a href="/login" target="_blank">Ps:未登录状态无法发帖!</a>
                </#if>

            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <img src="img/xzz.png" alt="这是网站Logo" title="这是网站Logo" <#--style="height: 50px;width: 130px;position: absolute;margin-left: 260px;margin-top: 56px"-->>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8" style="margin-top: 30px">
                <ul class="list-inline" id="list_nav">
                    <li><a href="/index" target="_blank" >首页</a></li>
                    <li><a href="#">源码开源</a></li>
                    <li><a href="/projectlist" target="_blank">项目展示</a></li>
                    <li><a href="#">申请扶助</a></li>
                    <li>
                        <div class="menuDiv">
                            <ul>
                                <li>
                                    <a href="#"><span  class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;&nbsp;更多</a>
                                    <ul style="margin-left: -25px">
                                        <li><a href="personalData.html"><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;&nbsp;设置</a></li>
                                        <li><a href="/sendf"><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;&nbsp;发帖</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li style="border-left: #5e5e5e 1px solid">&nbsp;</li>
                    <li><a href="#" >关于我们</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#myModal">加入我们</a></li>
                </ul>
            </div>
            <div class="col-md-4 pull-right" style="margin-top: 25px">
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="减压游戏">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div>
        </div>
        <!--轮播图开始-->
    </div>


</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">加入我们</h4>
            </div>
            <div class="modal-body">
                <div class="container">
                    <div class="row">
                        <div class="col-md-11 pull-right">
                            <ul class="list-inline">
                                <li style="width: 200px;font-size: 16px"><a href="/rgt" target="_blank"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;&nbsp;普通注册</a></li>
                                <li style="width: 200px;font-size: 16px"><a href="/EmailReg" target="_blank"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;&nbsp;邮箱注册-第三方</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
    <#--关于我们-->
</div>
<script src="js/jquery-1.8.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>