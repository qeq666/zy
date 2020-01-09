<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>众游-信息共享-发布-周边搜索</title>
    <link rel="stylesheet" href="css/layui.css">
    <link rel="stylesheet" href="https://a.amap.com/jsapi_demos/static/demo-center/css/demo-center.css"/>
    <link rel='icon' href="img/favicon.ico" type='image/x-ico' />
    <style>
        html, body, #container {
            height: 100%;
            width: 100%;
        }

        .content-window-card {
            position: relative;
            box-shadow: none;
            bottom: 0;
            left: 0;
            width: auto;
            padding: 0;
        }

        .content-window-card p {
            height: 2rem;
        }

        .custom-info {
            border: solid 1px silver;
        }

        div.info-top {
            position: relative;
            background: none repeat scroll 0 0 #F9F9F9;
            border-bottom: 1px solid #CCC;
            border-radius: 5px 5px 0 0;
        }

        div.info-top div {
            display: inline-block;
            color: #333333;
            font-size: 14px;
            font-weight: bold;
            line-height: 31px;
            padding: 0 10px;
        }

        div.info-top img {
            position: absolute;
            top: 10px;
            right: 10px;
            transition-duration: 0.25s;
        }

        div.info-top img:hover {
            box-shadow: 0px 0px 5px #000;
        }

        div.info-middle {
            font-size: 12px;
            padding: 10px 6px;
            line-height: 20px;
        }

        div.info-bottom {
            height: 0px;
            width: 100%;
            clear: both;
            text-align: center;
        }

        div.info-bottom img {
            position: relative;
            z-index: 104;
        }

        span {
            margin-left: 5px;
            font-size: 11px;
        }

        .info-middle img {
            float: left;
            margin-right: 6px;
        }

        .box {
            width: 280px;
            height: 40px;
            border: 1px silver solid
        }

        .da-na {
            width: 100%;
            height: 100%;
            display: inline-block
        }

        .box a:hover {
            background-color: rgba(76, 174, 76, 0.5);
        }
    </style>
</head>
<body style="background-color: rgba(198,243,255,0.4)">
<div class="layui-edge-right" style="margin-left: 50%;font-size: 18px">Hello!陌生人你好!发布信息走右边</div>
<ul style="width: 280px;position: absolute">
    <#if Session["shares"]?exists>
        <#list shares as item>
                <li class="box">
                    <a href="Byid/${item.id}" class="da-na">
                        <img src="${item.img}" width="38" height="35px" alt="" style="border-radius: 5px;margin-left: 15px">
                        <span class="layui-edge-right" style="margin-left: 20px">${item.title}</span>
                        <span class="layui-icon layui-icon-group" style="margin-left: 20%"></span>
                    </a>
                </li>
        </#list>

    <#else>
        <li class="box"><a href="" class="da-na">
                <img src="img/1.jpg" width="38" height="35px" alt="" style="border-radius: 5px;margin-left: 15px">
                <span class="layui-edge-right" style="margin-left: 20px">
            暂时没有什么动静! 小众众^_^
        </span>
                <span class="layui-icon layui-icon-group" style="margin-left: 20px"></span>
            </a>
        </li>
    </#if>
</ul>
<div id="container" style="width: 80%;height: 748px;float: right;"></div>
<div class="info">
    <a href="JumpShares">心动了!我也要来发布一份。</a>
</div>
<div class="layui-col-md8" style="padding-left: 42%">
    ${idxinfo.home_topinfo }
</div>
<#--<script src="layui.js"></script>-->
<script src="https://layui.hcwl520.com.cn/layui-v2.5.4/layui.js"></script>
<script type="text/javascript"
        src="https://webapi.amap.com/maps?v=1.4.15&key=bdc6b4745e57a3b82f107bb5ff53e59f"></script>
<script type="text/javascript">    //地图初始化时，在地图上添加一个marker标记,鼠标点击marker可弹出自定义的信息窗体
    var j = "${share.latitude}";
    var w = "${share.danadw}";
    if(j == null || w == null){
         j = "116.481181";
         w = "39.989792";
    }
    /*116.481181-39.989792*/
    var map = new AMap.Map("container", {
        resizeEnable: true,
        center: [j, w],
        zoom: 16
    });
    /*初始化地图以及定位信息地图*/
    danadw();
    function danadw() {
        addMarker(j, w);

    }

    //添加marker标记
    function addMarker(data1, data2) {
        map.clearMap();
        var marker = new AMap.Marker({
            map: map,
            position: [data1, data2]
        });
        //鼠标点击marker弹出自定义的信息窗体
        AMap.event.addListener(marker, 'click', function () {
            infoWindow.open(map, marker.getPosition());
        });
    }

    function add() {
        console.log('click')
        return 'click'
    }

    //实例化信息窗体
    var title = '众游-信息共享中心<span style="font-size:11px;color:#F00;">${share.title}</span>',
        content = [];
    content.push("<img src='${share.img}' width='80' height='70'>描述：${share.content}");
    content.push("共享日期：${share.createtime?string("yyyy-MM-dd")}");
    content.push("<a href='https://ditu.amap.com/detail/B000A8URXB?citycode=110105'>众游团队版权所有</a>");
    var infoWindow = new AMap.InfoWindow({
        isCustom: true,  //使用自定义窗体
        content: createInfoWindow(title, content.join("<br/>")),
        offset: new AMap.Pixel(16, -45)
    });

    //构建自定义信息窗体
    function createInfoWindow(title, content) {
        var info = document.createElement("div");
        info.className = "custom-info input-card content-window-card";

        //可以通过下面的方式修改自定义窗体的宽高
        //info.style.width = "400px";
        // 定义顶部标题
        var top = document.createElement("div");
        var titleD = document.createElement("div");
        var closeX = document.createElement("img");
        top.className = "info-top";
        titleD.innerHTML = title;
        closeX.src = "https://webapi.amap.com/images/close2.gif";
        closeX.onclick = closeInfoWindow;

        top.appendChild(titleD);
        top.appendChild(closeX);
        info.appendChild(top);

        // 定义中部内容
        var middle = document.createElement("div");
        middle.className = "info-middle";
        middle.style.backgroundColor = 'white';
        middle.innerHTML = content;
        info.appendChild(middle);

        // 定义底部内容
        var bottom = document.createElement("div");
        bottom.className = "info-bottom";
        bottom.style.position = 'relative';
        bottom.style.top = '0px';
        bottom.style.margin = '0 auto';
        var sharp = document.createElement("img");
        sharp.src = "https://webapi.amap.com/images/sharp.png";
        bottom.appendChild(sharp);
        info.appendChild(bottom);
        return info;
    }

    //关闭信息窗体
    function closeInfoWindow() {
        map.clearInfoWindow();
    }
</script>
</body>
</html>