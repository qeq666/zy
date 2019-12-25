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
<div class="layui-container" style="padding-top: 8px">
    <div class="row">
        <img src="img/lxwm.png" width="150" height="150" alt="" style="display: inline">

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