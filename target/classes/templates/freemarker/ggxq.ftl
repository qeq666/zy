<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>公告详情</title>
    <link rel="stylesheet" href="css/layui.css">
</head>
<body>
<div class="layui-main" style="padding-top: 12%;padding-left: 18%;">
    <div class="layui-edge-right" style="margin-bottom: 1%;font-size: 24px;padding-left: 1%;color: rgba(255,142,0,0.7)">${decsg.comntent}</div>
    <span style="font-size: 16px;color: #8a6d3b">${decsg.title}</span><br>
    <span style="font-size: 16px;color: #8a6d3b;margin-left: 57%">来自:${decsg.senduser}-${decsg.createtime?string("yyyy-MM-dd")}</span>
</div>
<html>
<head>
<body>
<script language="JavaScript">
    <!--

    if (window.Event)
        document.captureEvents(Event.MOUSEUP);

    function nocontextmenu()
    {
        event.cancelBubble = true
        event.returnValue = false;

        return false;
    }

    function norightclick(e)
    {
        if (window.Event)
        {
            if (e.which == 2 || e.which == 3)
                return false;
        }
        else
        if (event.button == 2 || event.button == 3)
        {
            event.cancelBubble = true
            event.returnValue = false;
            return false;
        }

    }

    document.oncontextmenu = nocontextmenu;  // for IE5+
    document.onmousedown = norightclick;  // for all others
    //-->
</script>
<style type="text/css">#side_left_menu .side_list li:nth-child(6n+1) {
    border-right:5px solid orange;
}
#side_left_menu .side_list li:nth-child(6n+2) {
    border-right:5px solid orange;
}
#side_left_menu .side_list li:nth-child(6n+3) {
    border-right:5px solid #39FF00;
}
#side_left_menu .side_list li:nth-child(6n+4) {
    border-right:5px solid #39FF00;
}
#side_left_menu .side_list li:nth-child(6n+5){
    border-right:5px solid #FF2600;
}
#side_left_menu .side_list li:nth-child(6n+6) {
    border-right:5px solid #FF2600;
}



#side_left_menu{width:130px; height:2000px; float:left; position:fixed; top:30%;z-index: 10;}#side_left_menu .side_list{width:100%;height:auto; }#side_left_menu .side_list li{width:150px; text-align:center;margin:0 auto;height:60px;margin-bottom:10px;box-shadow:2px 2px 4px rgba(0, 0, 0, 0.2);-webkit-transition:0.3s all ease;-moz-transition:0.3s all ease;-ms-transition:0.3s all ease;-o-transition:0.3s all ease;transition:0.3s all ease;overflow:hidden;position:relative; }#side_left_menu .side_list li:hover{background:#009999;box-shadow:2px 2px 4px rgba(0, 0, 0, 0.4);border-right:5px solid #fff;}#side_left_menu .side_text h2,#side_left_menu .side_text a{font-family:"Microsoft YaHei";color:#333;text-shadow:1px 2px 4px #999;font-size:16px;font-weight:normal;-webkit-transition:0.3s all ease;-moz-transition:0.3s all ease;-ms-transition:0.3s all ease;-o-transition:0.3s all ease; line-height: 55px; padding: 0px; margin: 0px; text-align: center; float: none;}#side_left_menu .side_text h3{font-family:Verdana;font-size:14px;color:#666;font-weight:normal;-webkit-transition:0.3s all ease;-moz-transition:0.3s all ease;-ms-transition:0.3s all ease;-o-transition:0.3s all ease;}#side_left_menu .side_list li:hover h2,#side_left_menu .side_list li:hover  a{color:#FFF;font-size:16px;text-shadow:1px 2px 4px #333;}#side_left_menu .side_list li:hover .side_text h3{color:#F60;font-size:16px;}#side_left_menu .side_list li:hover .icon{color:#F90;font-size:50px;}#side_left_menu .side_list li:hover .side_text{-webkit-animation-name:shake;-moz-animation-name:shake;}#side_left_menu .side_text{width:125px;height:auto;float:left;height:50px;-webkit-animation:.5s .2s ease both;-moz-animation:1s .2s ease both;}</style>
<div id="side_left_menu">
    <ul class="side_list">
        <li>
            <div class="side_text">
                <h2>
                    <a href="/index">返回首页</a>
                </h2>
            </div>
        </li>
        <li>
            <div class="side_text">
                <h2>
                    <a href="http://wpa.qq.com/msgrd?v=3&uin=944358609&site=qq&menu=yes">联系站长</a>
                </h2>
            </div>
        </li>
    </ul>
</div>



<script src="js/jquery-1.8.0.min.js"></script>
<script src="layui.js"></script>
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