<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>周边发布-信息共享-众游</title>
    <link rel="stylesheet" href="css/layui.css">
    <style>
        .this{
            background-color: rgba(100,119,136,0.5);border-radius: 5px;border:  silver 1px solid
        }

    </style>
</head>
<body style="background-image:url('zhongy/images/bj.jpg');width: 100%;height: 100%;">


<div class="layui-main">
    <h2 class="layui-edge-right" style="color: rgba(100,119,136,0.8);margin-bottom: 4%;margin-top: 5%">有什么需要的跟我说吧!</h2>
    <form action="addShareMsg" method="post" class="layui-form">
        <div class="layui-form-item">
            <div class="layui-col-md6">
                <div class="layui-field-box" style="font-size: 18px;font-weight: bold;color: rgba(100,119,136,0.9)">
                    标题:
                </div>
                <input type="text" class="layui-input" id="title" name="title" style="width: 428px;" placeholder="这里输入团队名字,或者标题吧" required="required"/>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-col-md6">
                <div class="layui-field-box" style="font-size: 18px;font-weight: bold;color: rgba(100,119,136,0.9)">
                    主题描述:
                </div>
                <textarea class="layui-textarea" id="content" name="content" style="width: 428px;" placeholder="一句话介绍"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-col-md6">
                <div class="layui-field-box" style="font-size: 18px;font-weight: bold;color: rgba(100,119,136,0.9)">
                    初始化信息下面显示
                </div>
                <input type="text" class="layui-input " id="init" disabled="disabled" style="width: 428px;"  placeholder="这里输入团队名字,或者标题吧" required="required"/>
            </div>
        </div>
        <fieldset class="layui-elem-field" style="width: 428px">
            <legend style="font-size: 18px;font-weight: bold;color: rgba(100,119,136,0.9)">个性化头像</legend>
            <div class="layui-field-box" style="height: 70px;width: 428px;">
                <div class="layui-form-item">
                    <div class="layui-container">
                        <div class="layui-row" style="margin-top: 1%">
                            <div class="layui-col-md1">
                                <img src="img/mei.png" id="mei" name="mei" style="margin-left: 2%;" alt="" width="35" height="34" >
                                <img src="img/ces.png" id="ces" name="ces" style="margin-left: 8%" alt="" width="35" height="34">
                            </div>
                            <div class="layui-col-md1">
                                <img src="img/bc.png" alt="" id="bc" name="bc" style="margin-left: 8%" width="35" height="34">
                                <img src="img/ss.png" alt="ss" id="ss" name="" style="margin-left: 8%" width="35" height="34">
                            </div>
                            <div class="layui-col-md1" style="margin-left: 4%">
                                <select id="img_site" name="img_site" >
                                    <option value="0">请选择</option>
                                    <option value="1">美工</option>
                                    <option value="2">测试</option>
                                    <option value="3">编程</option>
                                    <option value="4">实施</option>
                                </select>
                            </div>
                            <button class="layui-btn btn-default" type="button"  onclick="addSha()">发送</button>
                        </div>
                    </div>
                </div>

            </div>
        </fieldset>
    </form>
    <div style="width: 540px;border: 1px rgba(100,119,136,0.2)  dashed;height: 425px;position: absolute;left: 43%;bottom: 0%">
        <div class="layui-edge-right" style="margin-left: 3%;margin-top: 2%;font-size: 20px;color: rgba(100,119,136,0.9);background-color: rgba(255,255,255,0.2)">
            <span style="padding-left: 2%">疑惑解答</span>
        </div>
        <div class="layui-card-body" style="color: rgba(12,107,207,0.8)">
            如果浏览器请求获取您的位置请选择是如果选择否的话,可能会导致初始化失败,初始化失败你可以刷新一下(F5,如果刷新了几次还是失败,初始化失败可能的原因是网络导致的,或者更换网络查看。
        </div>
    </div>
</div>
<div  style="top: 93%;position: absolute;left: 38%">
    <a href="" style="font-size: 18px">共享中心-信息中心-周边搜索</a><br>
    <a href="" style="font-size: 18px;margin-left: 15%">众游网络&copy;版权所有</a>
</div>


<script src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.10&key=bdc6b4745e57a3b82f107bb5ff53e59f"></script>
<script src="js/andbvis.js"></script>
<script src="https://layui.hcwl520.com.cn/layui-v2.5.4/layui.js"></script>
<#--<script src="layui.js"></script>-->
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

    setInterval(gxhtx,100)
    /*查出来图片地址写入option 拿弟*/

    function gxhtx() {
        var item = $("#img").val();
        if(item == "1"){
            $("#ss").removeClass("this");
            $("#bc").removeClass("this");
            $("#ces").removeClass("this");
            $("#mei").addClass("this");
        }else if(item == "2"){
            $("#ss").removeClass("this");
            $("#bc").removeClass("this");
            $("#ces").addClass("this");
            $("#mei").removeClass("this");
        }else if(item == "3"){
            $("#ss").removeClass("this");
            $("#bc").addClass("this");
            $("#ces").removeClass("this");
            $("#mei").removeClass("this");
            console.log("nc")
        }else if(item == "4"){
            $("#ss").addClass("this");
            $("#bc").removeClass("this");
            $("#ces").removeClass("this");
            $("#mei").removeClass("this");
        }
    }

</script>
</body>
</html>