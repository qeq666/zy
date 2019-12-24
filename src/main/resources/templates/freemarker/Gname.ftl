<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>${gnamecontent.itt_title!'重试'}</title>
    <link rel="stylesheet" href="css/layui.css"/>
    <link rel="stylesheet" href="css/down.css"/>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<iframe  src="p_nav_title" scrolling="no" style=";overflow:scroll;width:100%;height: 80px;;" frameborder="0"></iframe>
<div class="layui-container">
    <div class="layui-row">
       <span class="layui-breadcrumb">
          <a href=""><span class="layui-icon layui-icon-home" style="color:#009688"></span>&ensp;首页</a>
          <a href="">枪战游戏</a>
          <a><cite>${gnamecontent.itt_title!'重试'}</cite></a>
    </span>
    </div>
<!--    标题-->
    <div class="layui-row" style="padding-top: 50px;padding-left: 30%"><h2 class="">${gnamecontent.itt_title!'重试'}</h2></div>
    <div class="layui-row" style="padding-top: 10px;padding-left: 20%"> <span class="layui-icon layui-icon-user" style="color:#009688"></span>&ensp;大拿 &ensp;<span class="layui-icon layui-icon-date" style="color:#009688"></span>&ensp;${gnamecontent.itt_createtime!'重试'}  &ensp;<span style="color:#009688" class="layui-icon layui-icon-app"></span>&ensp;${gnamecontent.type!'其他'}</div>
    <div class="layui-row" style="padding-top: 10px;"><hr class="layui-bg-blue"></div>
    <div class="layui-row" style="padding-top: 10px;">
        ${gnamecontent.itt_content!'重试'}
    </div>
    <div class="layui-row" style="padding-top: 10px;"><hr class="layui-bg-blue"></div>
    <div class="layui-row" style="padding-top: 10px;">
        <div id="fengexuxian">
        </div>
        <div class="page-content-intro main-article">
            <div class="down-url-wrap">
                <h3 class="tit">
                    <i class="ico"></i>文章附件
                </h3>
                <a href="#down" onclick="window.open('>/${gnamecontent.itt_downurl!'重试'}');return false;" class="sbtn" title=""><i class="ico"></i><i class="line"></i>百度网盘</a>  <a href="#down" onclick="window.open('${gnamecontent.itt_downurl!'重试'}'');return false;" class="sbtn" title=""><i class="ico"></i><i class="line"></i>蓝奏云</a>
            </div>
        </div>
    </div>
</div>
<div style="height: 500px;"></div>

<script src="js/jquery-1.8.0.min.js"></script>
<script src="layui.js"></script>
<script>
    layui.use("element",function () {
        var element = layui.element;
    })
</script>
</body>
</html>