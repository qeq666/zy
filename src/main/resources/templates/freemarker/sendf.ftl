<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>发帖-众游网</title>
    <link rel="stylesheet" href="css/layui.css"/>
    <script type='text/javascript' src='plugins/textboxio/textboxio.js'></script>
    <link rel="stylesheet" type="text/css" href="plugins/example.css" />
    <link rel='icon' href="img/favicon.ico" type='image/x-ico' />

    <script>
        /*
        This function replaces all <textareas> on a page with
        instances of Textbox.io.
        */
        var instantiateTextbox = function () {
            textboxio.replaceAll('textarea', {
                paste: {
                    style: 'clean'
                },
                css: {
                    stylesheets: ['example.css']
                }
            });
        };

    </script>
    <script>
        /*
        This function gets the content from the instance of Textbox.io
        with the ID 'textbox'
        */
        var getEditorContent = function(){
            var editors = textboxio.get('#textbox');
            var editor = editors[0];
            return editor.content.get();
        };
    </script>
</head>
<body style="background-color:#F1F3F4;" onload="instantiateTextbox();">
<iframe  src="p_nav_title" scrolling="no" style=";overflow:scroll;width:100%;height: 80px;;" frameborder="0"></iframe>
<div class="layui-container" style="padding-top: 10px;;">
    <div class="layui-row">
        <!--这是路径导航-->
        <div class="layui-col-md12">
                <span class="layui-breadcrumb">
                    <a href="#">首页</a>
                    <a href="#">个人特权</a>
                    <a href="#"><cite>发帖</cite></a>
                </span>
        </div>
    </div>
</div>
<!--右下角导航-->
<div style="width:150px;height:300px;position: fixed;display: none;margin-top: 50px;top: 220px;right: 150px" id="leftli">
    <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item"> <!--layui-nav-itemed 展开函数-->
            <a href="javascript:;">注意事项</a>
            <dl class="layui-nav-child">
                <dd><a href="javascript:;">敏感字查询</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item ">
            <a href="javascript:;">审核时间</a>
            <dl class="layui-nav-child">
                <dd><a href="javascript:;">24小时~48小时</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item "><a href="javascript:;" onclick="a()">回到顶部&emsp;&emsp;&emsp;<span class="layui-icon layui-icon-up"></span></a></li>
    </ul>
</div>
<!--标题-->
<form action="upload" class="layui-form" method="post" enctype="multipart/form-data">
    <div class="layui-container" style="padding-top: 20px;margin-left: 17%">

        <div class="row" >
            <div class="layui-col-md-9" style="margin-left: 3%">
                <input type="text" name="title" id="title" style="width:300px;" placeholder="这里输入标题!" required lay-verify="required" autocomplete="off" class="layui-input"/>
            </div>
        </div>
        <div class="layui-btn-row">
            <div class="layui-col-md12" style="margin-left: 13px;margin-top: 3%">
                <label class="layui-form-label ">缩略图&nbsp;<span style="font-weight: bold">:</span>&nbsp;</label>
                <div class="layui-input-block">
                    <input  type="file" name="file" id="file" style="width: 190px;display: inline-block;padding-left: 20px">
                </div>
            </div>
        </div>
    </div>
    <div class="layui-container" style="padding-top: 50px;">
        <div class="layui-col-md6">

            <select id="type" name="type">
                <option value="0">选择分类</option>
                <#list types as item_type>
                    <option value="${item_type.t_id}">${item_type.t_type}</option>
                </#list>
            </select>
        </div>
        <div class="layui-col-md12">
            <textarea id="textbox" name="edit" style="width: 100%; height: 400px;"></textarea>
        </div>
        <div class="layui-col-md12" style="padding-top: 20px">
            <div class="layyi-card">
                <div class="layui-card-header" style="background-color: rgba(255,255,255,0.4)">
                    特权专区:&emsp;&emsp;<span class="layui-breadcrumb" lay-separator="|">
                    <a href="#">置顶</a>
                    <a href="#">火爆</a>
                    <a href="#">最新</a>
                             </span>&emsp;&emsp;
                    <span class="layui-breadcrumb" lay-separator="|">
                    <a href="#">
                        <input  type="checkbox" name="istop" id="istop" lay-skin="switch" lay-text="开启|关闭"/>
                    </a>
                    <a href="#">
                        <input type="checkbox" name="isHb" id="isHb" lay-skin="switch" lay-text="开启|关闭"/>
                    </a>
                    <a href="#">
                        <input type="checkbox" name="HfDown" id="HfDown" lay-skin="switch" lay-text="开启|关闭"/>
                    </a>
                        <a href="#">
                    </a>
                </span>
                </div>
                <div class="layui-card-body" style="background-color: rgba(255,255,255,0.4)">
                    <button class="layui-btn layui-btn" style="border-radius: 6px">发表</button>
                    附件地址<input type="text" name="downurl" id="downurl" style="width:300px;display: inline" placeholder="输入附件下载地址!" required lay-verify="required" autocomplete="off" class="layui-input"/>
                </div>
            </div>
        </div>

    </div>
</form>




<div style="height:200px;"></div>

<script src="js/jquery-1.8.0.min.js"></script>
<#--<script src="layui.js"></script>-->
<script src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
<script>
    layui.use(['element','layedit','form'],function(){
        var element = layui.element
            ,layedit = layui.layedit
            ,form = layui.form;
        layedit.build('demo')
    })
    console.log(document.documentElement.scrollTop||document.body.scrollTop)
    $(window).scroll(function(){
        var scrollTop = document.documentElement.scrollTop||document.body.scrollTop;
        if(scrollTop>0){
            console.log("显示")
            $("#leftli").css("display","block");
        }
        if(scrollTop==0){
            console.log("隐藏")
            $("#leftli").css("display","none");
        }
    })
    function a(){
        $('body,html').animate({scrollTop:0},800)
    }
</script>
</body>
</html>