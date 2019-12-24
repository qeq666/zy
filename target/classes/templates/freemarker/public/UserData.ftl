<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Title</title>
    <link rel="stylesheet" href="../css/layui.css">
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-main">
        <div class="layui-container">
            <div class="layui-row">
                <div class="layui-col-md12">
                    <label class="layui-form-label" style="padding-left: -0px">昵称</label>
                    <div class="layui-input-block">
                    <label class="layui-form-label">${user.user_realname}</label>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-form-item">
                        <label class="layui-form-label">真实姓名</label>
                        <div class="layui-input-block">
                            <div class="layui-col-md6">
                            <input type="text" name="title" value="${user.user_realname}" required lay-verify="required" style="width: 200px; "
                                   placeholder="请输入标题" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-col-md6">
                                <input type="checkbox" name="zzz" lay-skin="switch" lay-text="公开|私密">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-form-item">
                        <label class="layui-form-label">出生年月</label>
                        <div class="layui-input-block">
                            <div class="layui-col-md6">
                                <input type="text" name="boydata" value="${regteruser.rgt_createtime}" id="boydata" required lay-verify="required" style="width: 200px; "
                                       placeholder="请输入标题" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-col-md6">
                                <input type="checkbox" name="zzz" lay-skin="switch" lay-text="公开|私密">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-form-item">
                        <label class="layui-form-label">擅长技能</label>
                        <div class="layui-input-block">
                            <input type="text" name="type" value="暂时没有" id="type" required lay-verify="required" style="width: 200px; "
                                   placeholder="技能标签" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-form-item">
                        <button class="layui-btn layui-btn">保存</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>


<script src="../js/jquery-1.8.0.min.js"></script>
<script src="../layui.js"></script>
<script>
    layui.use(['element', 'carousel', 'layer','laydate','form'], function () {
        var element = layui.element, carousel = layui.carousel, layer = layui.layer,laydate  = layui.laydate,form = layui.form;
        //建造实例
        carousel.render({
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
        laydate.render({
            elem: '#test1' //指定元素
        });

    });
</script>
</body>
</html>