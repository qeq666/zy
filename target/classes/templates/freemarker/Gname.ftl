<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>${gnamecontent.itt_title!'重试'}</title>
    <link rel="stylesheet" href="css/layui.css"/>
    <link rel="stylesheet" href="css/down.css"/>
    <link rel='icon' href="img/favicon.ico" type='image/x-ico' />
    <style>
        *{
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body style="background-color: rgba(198,243,255,0.4)">
<iframe  src="p_nav_title" scrolling="no" style=";overflow:scroll;width:100%;height: 100px;padding-top: 10px;" frameborder="0"></iframe>
<div class="layui-container">
    <div class="layui-row">
       <span class="layui-breadcrumb">
          <a href=""><span class="layui-icon layui-icon-home" style="color:#009688"></span>&ensp;首页</a>
          <a href="">${gnamecontent.type!'其他'}</a>
          <a><cite>${gnamecontent.itt_title!'重试'}</cite></a>
    </span>
    </div>
<!--    标题-->
    <div class="layui-row" style="padding-top: 80px;padding-left: 15%"><h2 class="" style="margin-bottom: 5%">${gnamecontent.itt_title!'重试'}</h2></div>
    <div class="layui-row" style="padding-top: 10px;padding-left: 20%"> <span class="layui-icon layui-icon-user" style="color:#009688"></span>&ensp;大拿 &ensp;<span class="layui-icon layui-icon-date" style="color:#009688"></span>&ensp;${gnamecontent.itt_createtime?string("yyyy-MM-dd")!'重试'}  &ensp;<span style="color:#009688" class="layui-icon layui-icon-app"></span>&ensp;${gnamecontent.type!'其他'} &emsp;<span class="layui-icon layui-icon-read" style="color: #009688"></span>&emsp;热度&emsp;${gnamecontent.itt_Degreeofheat}</div>
    <div class="layui-row" style="padding-top: 10px;"><div class="layui-col-md9"><hr class="layui-bg-blue"></div></div>
    <div class="layui-row" style="padding-top: 10px;">
        <div class="layui-col-md9" >
            ${gnamecontent.itt_content!'重试'}
        </div>
        <div class="layui-col-md3"  >
            <img src="img/arrow-right.png" style="width: 22px;height: 21px;position: absolute;left: 92%;top: 1px;z-index: 1">
            <div class="layui-card">
                <div class="layui-card-header">一分钟了解</div>
                <div class="layui-card-body">
                    <img src="img/00.png" style="width: 250px;height: 210px;" alt="">
                </div>
            </div>
        </div>
        <div class="layui-col-md3" style="margin-top: 3%">
            <img src="img/arrow-right.png" style="width: 22px;height: 21px;position: absolute;left: 92%;top: 1px;z-index: 1">
            <div class="layui-card">
                <div class="layui-card-header">随机推荐</div>
                <div class="layui-card-body">
                    <#--最热信息展示-->
                    <#list hottest as item_hottest>
                        <a href="/gname/${item_hottest.id}">${item_hottest.itt_title}</a><br>
                    </#list>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-row" style="padding-top: 10px;"><div class="layui-col-md9"><hr class="layui-bg-blue"></div></div>
    <div class="layui-row" style="padding-top: 10px;">
        <div id="fengexuxian">
        </div>
        <div class="page-content-intro main-article">
            <div class="down-url-wrap">
                <h3 class="tit">
                    <i class="ico"></i>文章附件
                </h3>
                <a href="#down" onclick="window.open('${gnamecontent.itt_downurl!'重试'}');return false;" class="sbtn" title=""><i class="ico"></i><i class="line"></i>百度网盘</a>  <a href="#down" onclick="window.open('${gnamecontent.itt_downurl!'重试'}'');return false;" class="sbtn" title=""><i class="ico"></i><i class="line"></i>蓝奏云</a>
            </div>
        </div>
    </div>
</div>
<div class="layui-col-md8" style="padding-left: 50%">
    ${idxinfo.home_topinfo }
</div>
<script src="js/jquery-1.8.0.min.js"></script>
<script src="layui.js"></script>
<script>
    layui.use("element",function () {
        var element = layui.element;
    })
</script>
</body>
</html>