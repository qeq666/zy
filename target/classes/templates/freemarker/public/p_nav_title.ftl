<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../css/layui.css"/>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .ul_li li{
            text-decoration: none;
            display: inline-block;
            margin-left: 8%;
            font-weight: bold;


        }
        ol li a:hover{
            color: red;
            border-bottom:4px darkorange solid ;

        }
        .fix{
            margin-top: 3%;
        }
        ol li a:link{
            color: rgb(66,154,181);
        }
    </style>
</head>
<body>
<div style=";padding-left: 72%;width: 100%;height: 28px;background-color: rgb(139,158,152)">
    <a style="position: relative;top: 6px;" href="javascript:;" >登录</a>
    <a style="position: relative;top: 6px;" href="">注册</a>
    <a style="position: relative;top: 6px;" href="">找回</a>
</div>
<div class="layui-main">
    <ol class="ul_li fix" style="margin-right:40%;left: 1%;height: 38px;;width: 80%;position: fixed;top: 0px" >
        <li style="padding-left: 18%"><a href="/index" target="_blank" style="position: relative;top: 10px;">首页</a></li>
        <li><a href="/projectlist01" target="_blank" style="position: relative;top: 10px;">项目展示</a></li>
        <li><a href="/zydwa" target="_blank" style="position: relative;top: 10px;">寻找周边</a></li>
        <li><a href="/lyfk" target="_blank" style="position: relative;top: 10px;">留言建议</a></li>
        <li><a href="/Gywm"  target="_blank" style="position: relative;top: 10px;">关于我们</a></li>
    </ol>
</div>

</body>
</html>