<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>设置-个人中心</title>
    <link rel="stylesheet" href="../css/layui.css">
    <link rel='icon' href="img/favicon.ico" type='image/x-ico' />
</head>
<body style="background-color: rgba(198,243,255,0.4)">
    <div class="layui-main">
        <div class="layui-container">
            <div class="layui-row">
                <div class="layui-col-md7" >
                    <ul class="layui-nav" lay-filter="">
                        <li class="layui-nav-item layui-this"><a href="/index">首页</a></li>
                        <li class="layui-nav-item"><a href="">众游众源</a></li>
                        <li class="layui-nav-item">
                            <a href="javascript:;">在线工具</a>
                            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                                <dd><a href="https://s.tencent.com/">查询病毒</a></dd>
                                <dd><a href="https://imgchr.com/">上传文件</a></dd>
                                <dd><a href="http://www.kjson.com/jsonparser/">Json在线转换</a></dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item"><a href="">社区</a></li>
                    </ul>
                </div>
                <div class="layui-col-md5 " >
                    <ul class="layui-nav" >
                        <li class="layui-nav-item" >
                            <a href="">控制台<span class="layui-badge">9</span></a>
                        </li>
                        <li class="layui-nav-item">
                            <a href="">我的信息<span class="layui-badge-dot"></span></a>
                        </li>
                        <li class="layui-nav-item" >
                            <a href=""><img src="//t.cn/RCzsdCq" class="layui-nav-img">${user.user_realname}</a>
                            <dl class="layui-nav-child">
                                <dd><a href="javascript:;">修改信息</a></dd>
                                <dd><a href="javascript:;">安全管理</a></dd>
                                <dd><a href="Cancellation">退出登录</a></dd>
                            </dl>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--面包屑-->
    <div class="layui-main" style="margin-top: 20px">
        <div class="layui-container">
            <div class="layui-row">
                <div class="layui-col-md12">
                    <span class="layui-breadcrumb" lay-separator="-">
                          <a href="">首页</a>
                          <a href="">设置</a>
                        <a href=""><cite>个人中心</cite></a>
                    </span>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-container" style="margin-top: 20px">
        <div class="layui-row">
            <div class="laui-col-md12">
                <div class="layui-card" style="height: 600px;">
                    <div class="layui-card-header">设置</div>
                    <div class="layui-card-body">
                        <div class="layui-tab layui-tab-card" style="height: 400px">
                            <ul class="layui-tab-title">
                                <li class="layui-this">设置</li>
                                <li>资料审核</li>
                                <li>更改头像</li>
                            </ul>
                            <div class="layui-tab-content" style="height: 100px;">
                                <div class="layui-tab-item layui-show">
                                    <iframe  src="UserData" scrolling="no" style=";overflow:scroll;width:100%;height: 286px;" frameborder="0"></iframe>
                                </div>
                                <div class="layui-tab-item">
                                    <iframe  src="realName" scrolling="no" style=";overflow:scroll;width:100%;height: 286px;" frameborder="0"></iframe>
                                </div>
                                <div class="layui-tab-item">
                                    <iframe  src="uploadImg" scrolling="no" style=";overflow:scroll;width:100%;height: 400px;" frameborder="0"></iframe>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-col-md8" style="padding-left: 50%">
        ${idxinfo.home_topinfo }
    </div>
<script src="js/jquery-1.8.0.min.js"></script>
<#--<script src="/layui.js"></script>-->
    <script src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
    <script>
        layui.use("element",function () {
            var element = layui.element;
        })
    </script>
</body>
</html>