<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>众游-有你的信息我们会做得更好</title>
    <link rel="stylesheet" href="css/layui.css">
    <link rel='icon' href="img/favicon.ico" type='image/x-ico' />
    <style>
        *{
            margin: 0;
            padding: 0;
        }
    </style>
</head style="background-color: rgba(198,243,255,0.4)">
<body>
<div style="width: 100%;height: 321px;background: url('img/lybj.jpg');background-size:100% " >
    <div>
        <div style="position: absolute;font-size: 42px;color: rgba(255,255,255,1);left: 42%;top: 7%;font-family: KaiTi">
            <span>众游网络-共享技术-寻找另一个你</span><br>
            <span style="display: inline-block;margin-left: 18%">有你的意见我们会做得更好</span>
            <span style="display: inline-block;margin-left: 65%;font-size: 28px">ZhongYou-众游</span>
        </div>
    </div>
</div>
<form action="addfeedb" method="post">
    <div class="layui-main" style="margin-top: 1%;margin-left: 30%">
        <div>
            <label class="layui-form-label">反馈标题</label>
            <input type="text" id="title" name="title" class="layui-input" placeholder="这里输入标题" style="width: 30%">
        </div>
        <div style="margin-top: 2%">
            <label class="layui-form-label">反馈描述</label>
            <textarea name="desc" id="desc" placeholder="请输入内容" class="layui-textarea" style="width: 30%;height: 200px;"></textarea>
        </div>
        <div style="margin-top: 2%">
            <label class="layui-form-label">联系方式</label>
            <input type="text" id="lxfs" name="lxfs" class="layui-input" placeholder="联系方式" style="width: 30%">
        </div>
        <div style="margin-top: 2%">
            <label class="layui-form-label">验证码</label>
            <input type="text" class="layui-input" id="code" name="code" placeholder="输入验证码" style="width: 30%">
            <img src="http://127.0.0.1/api/captcha" alt="" width="100" height="32" class="passcode" style="margin-top: 3%;margin-left: 13%;height:43px;cursor:pointer;" id="code" name="code">
            <button class="layui-btn btn-primary" style="margin-top: 3%;margin-left: 8%">提交反馈</button>
        </div>
    </div>
</form>

<div style="margin-top: 1%;margin-left: 24%">
    <table class="layui-table" style="width: 50%;">
        <colgroup>
            <col width="200">
            <col width="400">
            <col width="200">
            <col width="170">
            <col width="200">
        </colgroup>
        <thead>
        <tr>
            <th>反馈标题</th>
            <th>反馈内容</th>
            <th>反馈时间</th>
            <th>公益人士</th>
            <th>是否解决</th>
        </tr>
        </thead>
        <tbody>
        <#list lovese as item_v>
            <tr>
                <td>${item_v.title}</td>
                <td>${item_v.contents}</td>
                <td>${item_v.createtime?string("yyyy-MM-dd")}</td>
                <td>${item_v.contact}</td>
                <td>${item_v.isok}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<div class="layui-col-md8" style="padding-left: 50%">
    ${idxinfo.home_topinfo }
</div>
<script src="js/jquery-1.8.0.min.js"></script>
<script src="layui.js"></script>
<script>
    layui.use(['element', 'carousel', 'layer','form'], function () {
        var element = layui.element, carousel = layui.carousel, layer = layui.layer,form = layui.form;
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