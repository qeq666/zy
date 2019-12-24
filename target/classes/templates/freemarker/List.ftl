<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>众游项目展示</title>
    <link rel="stylesheet" href="css/layui.css" media="all">
</head>
<body>
<iframe  src="p_nav_title" scrolling="no" style=";overflow:scroll;width:100%;height: 80px;;" frameborder="0"></iframe>
<div class="layui-main">
    <div class="layui-container">
        <div class="layui-col-md12">
            <span class="layui-breadcrumb">
              <a href="">首页</a>
              <a href="">分类</a>
              <a><cite>枪战游戏</cite></a>
            </span>
        </div>
        <div class="layui-col-md12">
            <fieldset class="layui-elem-field layui-field-title site-title">
                <legend><a name="compatibility" style="">枪战游戏</a></legend>
            </fieldset>
        </div>
        <div class="layui-col-md12">
            <fieldset class="layui-elem-field">
                <legend style="font-size: 14px;font-weight: bold">关键词为2个字最精准</legend>
                <div class="layui-field-box">
                    <span class="layui-breadcrumb" lay-separator="|">
                      <a href="">皮皮</a>
                      <a href="">枪战</a>
                      <a href="">益恼</a>
                      <a href="">方格</a>
                        <button class="layui-btn btn" style="width: 100px;margin-bottom: 3px;margin-left: 50px" type="button" onclick="location.href='sendf'">发帖</button>
                    </span>
                </div>
            </fieldset>
        </div>
        <div class="layui-col-md9">
            <fieldset class="layui-elem-field">
                <legend style="font-size: 14px;font-weight: bold">项目列表</legend>
                <div class="layui-field-box">
                    <!--一个layui-col-md4一个项目-->
                    <#if Session["zy_invitations"]?exists>
                    <#else>
                        <#list zy_invitations as zy_invitations_item>
                            <div class="layui-col-md3" style="padding-top: 20px;">
                                <p style="font-weight: bold">${zy_invitations_item.itt_title}</p>
                                <img src="${zy_invitations_item.itt_img01}" style="width: 100px;height: 100px;cursor:pointer"" alt="" onclick="location.href='/gname/${zy_invitations_item.id}'">
                                <p style="font-size: 10px">状态:不可下载</p>
                                <p style="font-size: 10px">${zy_invitations_item.itt_createtime} &emsp;上传</p>
                                <p style="font-size: 12px">热度 &emsp;10</p>
                                <p style="margin-left: 30%">作者: <a href="#">章大拿</a></p>
                            </div>
                        </#list>
                    </#if>
                </div>
            </fieldset>
        </div>
        <div class="layui-col-6" >
            这里引用的右边最新信息和联系我们
        </div>
        <div class="layui-col-md12" >
            <div id="demo0"></div>
        </div>
        <div class="layui-col-md12" style="padding-left: 30%;">
            众游网络版权所有|2019~2022
        </div>
    </div>
</div>

<script src="js/jquery-1.8.0.min.js"></script>
<#--<script src="layui.js"></script>-->
<script src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
<script>
    layui.use(['layer', 'form', 'element','laypage'], function(){
        var carousel = layui.carousel
            , element = layui.element
            ,laypage = layui.laypage;
        //建造实例
        //完整功能
        //总页数低于页码总数
        laypage.render({
            elem: 'demo0'
            ,count: 50 //数据总数
        });

        //总页数大于页码总数
        laypage.render({
            elem: 'demo1'
            ,count: 70 //数据总数
            ,jump: function(obj){
                console.log(obj)
            }
        });

        //自定义样式
        laypage.render({
            elem: 'demo2'
            ,count: 100
            ,theme: '#1E9FFF'
        });
        laypage.render({
            elem: 'demo2-1'
            ,count: 100
            ,theme: '#FF5722'
        });
        laypage.render({
            elem: 'demo2-2'
            ,count: 100
            ,theme: '#FFB800'
        });

        //自定义首页、尾页、上一页、下一页文本
        laypage.render({
            elem: 'demo3'
            ,count: 100
            ,first: '首页'
            ,last: '尾页'
            ,prev: '<em>←</em>'
            ,next: '<em>→</em>'
        });

        //不显示首页尾页
        laypage.render({
            elem: 'demo4'
            ,count: 100
            ,first: false
            ,last: false
        });

    });
</script>
</body>
</html>