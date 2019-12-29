<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Title</title>
    <link rel="stylesheet" href="css/layui.css">
    <style>
        .row a {
            padding-left: 2.5%;

        }

        .row span {
            cursor: pointer;
        }
    </style>
</head>
<body>

<div style="width: 288px;height: auto;">
    <div class="layui-container" style="padding-top: 0px">
        <#if Notices?exists>

            <#list Notices as item>
                <div class="row" style="padding-top: 15px">
                    <span class="layui-badge"><#if item.kind == 2>置顶<#else>最新</#if></span><a href="ggdesc/${item.id}" target="_blank">${item.title}</a><br>
                </div>
            </#list>
        <#else>
            <div class="row">
                <span class="layui-badge">置顶</span><a href="javascript::void;">暂时没有公告</a><br>
            </div>

        </#if>
    </div>
</div>


<script src="js/jquery-1.8.0.min.js"></script>
<#--<script src="layui.js"></script>-->
<script src="https://layui.hcwl520.com.cn/layui-v2.5.4/layui.js"></script>
<script>
    layui.use(['element', 'carousel', 'layer'], function () {
        var element = layui.element, carousel = layui.carousel, layer = layui.layer;
        //建造实例
        carousel.render({
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });

    });
</script>
</body>
</html>