<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${idxinfo.home_title}</title>
    <link rel="stylesheet" href="css/layui.css"/>
    <link rel='icon' href="img/favicon.ico" type='image/x-ico' />
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .btnbutto a{
            margin-left: 3%;
        }
        .ul_li li{
            text-decoration: none;
            display: inline-block;
            margin-left: 3%;
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
<body style="background-color: rgba(198,243,255,0.4)">
<!--登录注册-->
<div style="background-color: #697a8a;width:100%;height: 37px;">
     <span class="btnbutto" style="position: relative;margin-left: 66%;padding-top: 3%;top: 6px;" lay-separator="|">
                <#if Session["uid"]?exists>
                    <a href="OnData">欢迎您${Session.uid!'登陆成功'}</a>
                    <a href="OnData">个人资料</a>
                    <a href="/Cancellation">注销</a>
                    <#else>
                    <a href="/login">登录</a>
                    <a href="rgt">注册</a>
                    <a href="">找回</a>
                </#if>
            </span>
</div>
    <ol class="ul_li fix" style="display: none;height: 38px;;width: 100%;position: fixed;top: 0px" >
        <li style="padding-left: 16%"><a href="/index" style="position: relative;top: 10px;"">首页</a></li>
        <li><a href="projectlist01" style="position: relative;top: 10px;">项目展示</a></li>
        <li><a href="/zydwa" style="position: relative;top: 10px;">寻找周边</a></li>
        <li><a href="lyfk" style="position: relative;top: 10px;">留言建议</a></li>
        <li><a href="/Gywm" style="position: relative;top: 10px;">关于我们</a></li>
    </ol>

<div class="layui-container">
    <!--搜索start-->
    <form action="/search"  method="post" class="layui-form layui-form-pane">
        <div class="layui-row" style="float: right;width: 350px;padding-top: 4%">
                <div class="layui-col-md4">
                    <div class="layui-form-item" pane style="width:240px;">
                        <div class="layui-form-label">思考一下</div>
                        <div class="layui-input-block">
                            <input type="text" id="search_title" name="search_title" required class="layui-input" style="width:240px;"/>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md2" style="margin-left: 168px">
                    <button class="layui-btn layui-btn-normal" >搜索</button>
                </div>
        </div>


    </form>
    <!--搜索stop-->
    <div class="layui-col-md8" style="padding-top: 25px;"><#--29-->
        <ul class="layui-nav layui-bg-green" lay-filter="" >
            <li class="layui-nav-item" style="margin-left: 20px"><a href="#">首页</a></li>
            <li class="layui-nav-item"><a href="projectlist01">项目展示</a></li>
            <li class="layui-nav-item"><a href="javascript:void(0)" onclick="Login()">申请扶助[暂未开放</a></li>
            <li class="layui-nav-item"><a href="/zydwa" target="_blank">寻找周边</a></li>
            <li class="layui-nav-item"><a href="lyfk" target="_blank">留言建议</a></li>
            <li class="layui-nav-item"><a href="Gywm">关于我们</a></li>
            <!--下面是带二级菜单的_大拿因为某种原因不使用-->
            <!--<li class="layui-nav-item"><a href="#">首页</a></li>
            <li class="layui-nav-item"><a href="#">项目展示</a></li>
            <li class="layui-nav-item"><a href="#">申请扶助</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">更多</a>
                &lt;!&ndash;二级菜单&ndash;&gt;
                <dl class="layui-nav-child">
                    <dd><a href="#">投稿</a></dd>
                    <dd><a href="#">留言</a></dd>
                    <dd><a href="#">反馈</a></dd>
                </dl>
            </li>
        </ul>-->
        </ul>
    </div>
    <!--轮播图-->
    <div class="layui-col-md12" style="width:100%;height:270px;margin-top: 20px">
        <!--<h1 style="text-align: center">这是轮播图</h1>-->
        <div class="layui-carousel" id="test1">
            <div carousel-item>
                <#list imgs as item>
                    <div><img src="${item.wl_img}" alt="${item.wl_describe}" style="width: 100%;height: 100%;"></div>
                </#list>
            </div>
        </div>
    <!--推荐分类-->
    <div class="layui-col-md12" style="width:100%;height:150px
    ;margin-top: 20px">
        <#if Session["apls"]?exists!'不存在'>
        <h3>暂时没有什么内容!</h3>
        <#else >
        <#list apls as type_is>
        <div class="layui-col-md2">
            <div class="layui-anim layui-anim-up layui-anim-up" style="text-align: center">
                <div ><img src="img/tico/ic${type_is_index+1}.png" alt="" width="80" height="80"  style="border-radius:15px ;padding-top: 15px;display: inline-block"/></div>
                <div >
                    <ul class="layui-upload-list">
                        <li><a href="#">${type_is.t_back!'空'}</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </#list>
    </#if>



    </div>
    <!--项目展示-->
    <div class="layui-row" style="margin-top: 30px">
        <div class="layui-col-md8">
            <fieldset class="layui-elem-field layui-field-title" style="margin-top: 36px">
                <legend>今日更新</legend>
            </fieldset>
        </div>
        <div class="layui-col-md3" style="padding-left:3%">
            <div class="layui-tab">
                <ul class="layui-tab-title">
                    <li class="layui-this">最新公告</li>
                    <li >联系我们</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe  src="standesc" scrolling="no" style=";overflow:hidden;width:100%;height: auto;;" frameborder="0"></iframe>
                    </div>
                    <div class="layui-tab-item ">
                        <iframe  src="lxwm" scrolling="no" style=";overflow:hidden;width:100%;height: auto" frameborder="0"></iframe>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-md9">
            <img src="img/11111.png" alt="" style="position: absolute;bottom: 50px">
        </div>
        <div class="layui-col-md9">

            <#list itts!'没有内容' as item >
            <div class="layui-row" style="padding-top: 50px">
                <div class="layui-tab-item layui-show">
                    <div class="layui-col-md3">
                        <img src="img/slt.jpg" alt="" style="width: 170px;height: 160px;border-radius: 5px">
                    </div>
                    <div class="layui-col-md7">
                        <a href="/gname/${item.id}" target="_blank" class="layui-edge-right" style="color: #009688">${item.itt_title!'没有内容'}</a>
                        <#if item.itt_kind == 2><span class="layui-badge" style="margin-left: 3%">置顶</span></#if>
                    </div>
                    <div class="layui-col-md6" style="padding-top: 5px">
                        <span class="layui-icon layui-icon-username" style="color: #009688"></span>作者&nbsp;<span style="font-weight: bold">:</span>&nbsp;<a href="#">${item.itt_createid!'佚名'}</a>
                        &nbsp;&nbsp;&nbsp;<span class="layui-icon layui-icon-notice" style="color: #009688"></span>时间 <span style="font-weight: bold">:</span>&nbsp;<a
                            href="#">${item.itt_createtime?string("yyyy-MM-dd")!'没有内容'}</a>
                        &nbsp;<span class="layui-icon layui-icon-rate" style="color: #009688"></span>&nbsp;<a
                                href="#">${item.type!'没有内容'}</a>
                    </div>
                    <div class="layui-col-md5" style="padding-top: 5px">
                        <#if (item.itt_content?? && item.itt_content?length>30)>
                                         ${item.itt_content?substring(0,10)}...
                                  <#else>
                                         ${item.itt_content!'没有内容'}
                                  </#if>
                    </div>
                    <div class="layui-col-md2" style="padding-top: 27px;padding-left: 530px"><button class="layui-btn " onclick="location.href='/gname/${item.id}'">阅读全文</button></div>
                </div>
            </div>
        </#list>

        </div>
<#--        <div class="layui-col-md12" style="margin-left: 80%">
            <#if Session["sehmsg"]?exists>
                存在的值
            </#if>
            <h3>${sehmsg!' '}</h3>
        </div>-->
        <!--平台公告-联系我们-->
        <div class="layui-col-md4" style="padding-top: 50px;padding-left: 30px;">
            <div class="layui-col-md6 layui-tab-content" >
                <h4 style="padding-left: 39px"><a href="#" class="layui-tab-content"></a></h4>

            </div>
            <div class="layui-col-md6 layui-tab-content" >
                <div class="layui-col-md12">
                    <h4 style="padding-left: 39px"><a href="#" class="layui-tab-content"></a></h4>
                </div>

            </div>
        </div>

    </div>
        <div class="layui-col-md12" style="padding-left: 50%">
            ${idxinfo.home_topinfo }
        </div>
        <#--<div class="layui-col-md10" style="padding-left: 42%">
            <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? "https://" : "http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1278521370'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s4.cnzz.com/z_stat.php%3Fid%3D1278521370%26online%3D1%26show%3Dline' type='text/javascript'%3E%3C/script%3E"));</script>
        </div>-->
</div>
</div>
<#--<script src="js/layui.js"></script>-->
<script src="https://layui.hcwl520.com.cn/layui-v2.5.4/layui.js"></script>
<script src="js/jquery-1.8.0.min.js"></script>
<script>
    layui.use(['carousel','layer'], function(){
        var element = layui.element,carousel=layui.carousel,layer=layui.layer;
        //建造实例
        carousel.render({
            elem: '#test1'
            ,width: '100%' //设置容器宽度
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });

    });

    function f() {

    }
    function Login() {
        layer.msg('该功能暂未开放!');
    }
    $(window).scroll(function(){
        var scrollTop = document.documentElement.scrollTop||document.body.scrollTop;
        if(scrollTop>0){
            console.log("显示")
            /*top*/
            $(" ol").css({"display":"block","position":"fixed","z-index":"999","top":"-57px","background-color":"rgb(66,154,181)"})
        }
        if(scrollTop==0){
            console.log("隐藏")
            $(" ol").css({"display":"none","position":"fixed","z-index":"999","top":"0px","background-color":"transparent"})
        }
    })
</script>
</div>
</body>
</html>