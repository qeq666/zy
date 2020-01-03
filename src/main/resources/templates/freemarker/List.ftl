<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>众游项目展示</title>
    <link rel="stylesheet" href="../css/layui.css" media="all">
    <link rel='icon' href="img/favicon.ico" type='image/x-ico' />
    <style>
        a{ text-decoration:none}
        #n{margin:10px auto; width:920px; border:1px solid #CCC;font-size:12px; line-height:30px;}
        #n a{ padding:0 4px; color:#333}
        /* 以上CSS与模块无关 */
        .ep-pages{padding:10px 12px;clear:both;text-align:center;font-family:Arial, "\5B8B\4F53", sans-serif;font-size:14px;vertical-align:top}
        .ep-pages a, .ep-pages span{display:inline-block;height:23px;line-height:23px;padding:0 8px;margin:5px 1px 0 0;background:#fff;border:1px solid #e5e5e5;overflow:hidden;vertical-align:top}
        .ep-pages a:hover{background:#cc1b1b;border:1px solid #cc1b1b;text-decoration:none}
        .ep-pages a, .ep-pages a:visited{color:#252525}
        .ep-pages a:hover, .ep-pages a:active{color:#ffffff}
        .ep-pages .current{background:#cc1b1b;border:1px solid #cc1b1b;color:#fff}
        .ep-pages a.current, .ep-pages a.current:visited{color:#ffffff}
        .ep-pages a.current:hover, .ep-pages a.current:active{color:#ffffff}
        .ep-pages-ctrl{font-family:"\5B8B\4F53", sans-serif;font-weight:bold;font-size:16px}
        .ep-pages-e5e5e5{color:#e5e5e5}
        .ep-pages-all{font-size:12px;vertical-align:top}
    </style>
</head>
<body>
<iframe  src="p_nav_title" scrolling="no" style=";overflow:scroll;width:100%;height: 80px;;" frameborder="0"></iframe>
<div class="layui-main">
    <div class="layui-container">
        <div class="layui-col-md12">
            <span class="layui-breadcrumb">
              <a href="">首页</a>
              <a href="">分类</a>
              <a><cite>枪战游戏</cite></a>
            </span>
        </div>
        <div class="layui-col-md12">
            <fieldset class="layui-elem-field layui-field-title site-title">
                <legend><a name="compatibility" style="">枪战游戏</a></legend>
            </fieldset>
        </div>
        <div class="layui-col-md12">
            <fieldset class="layui-elem-field">
                <legend style="font-size: 14px;font-weight: bold">关键词为2个字最精准</legend>
                <div class="layui-field-box">
                    <span class="layui-breadcrumb" lay-separator="|">
                      <a href="">皮皮</a>
                      <a href="">枪战</a>
                      <a href="">益恼</a>
                      <a href="">方格</a>
                        <button class="layui-btn btn" style="width: 100px;margin-bottom: 3px;margin-left: 50px" type="button" onclick="location.href='sendf'">发帖</button>
                    </span>
                </div>
            </fieldset>
        </div>
        <div class="layui-col-md9">
            <fieldset class="layui-elem-field">
                <legend style="font-size: 14px;font-weight: bold">项目列表</legend>
                <div class="layui-field-box">
                    <!--一个layui-col-md4一个项目-->
                    <#if Session["zy_invitations"]?exists>
                    <#else>
                        <#list zy_invitations as zy_invitations_item>
                            <div class="layui-col-md3" style="padding-top: 20px;">
                                <p style="font-weight: bold">${zy_invitations_item.itt_title}</p>
                                <img src="${zy_invitations_item.itt_img01}" style="width: 100px;height: 100px;cursor:pointer"" alt="" onclick="location.href='/gname/${zy_invitations_item.id}'">
                                <p style="font-size: 10px">状态:不可下载</p>
                                <p style="font-size: 10px">${zy_invitations_item.itt_createtime?string("yyyy-MM-dd")} &emsp;上传</p>
                                <p style="font-size: 12px">热度 &emsp;10</p>
                                <p style="margin-left: 30%">作者: <a href="#">章大拿</a></p>
                            </div>
                        </#list>
                    </#if>
                </div>
            </fieldset>
        </div>
        <div class="layui-col-6" >
            这里引用的右边最新信息和联系我们
        </div>
        <div class="layui-col-md12" >

            <#if pageNo = pageTotal >
                <div class="ep-pages" style="margin-right: 30%">
                    <span class="ep-pages-e5e5e5">首页</span>
                    <span class="ep-pages-ctrl ep-pages-e5e5e5">&lt;
                </span> <a href="pageList?pageNo=${pageNo-1}" target="_self" class="current">上一页</a>
                    <a href="#" target="_self">共${pageTotal}页</a>
                    </span> <a href="#" target="_self" class="current">当前第${pageNo}页</a>

                </div>
                <#elseif pageNo == 1>
                <div class="ep-pages" style="margin-right: 30%">
                <span class="ep-pages-e5e5e5">首页</span>
                <span class="ep-pages-ctrl ep-pages-e5e5e5">&lt;
                </span> <a href="#" target="_self" class="current">当前第${pageNo}页</a>
                    <a href="#" target="_self">共${pageTotal}页</a>
                </span> <a href="pageList?pageNo=${pageNo+1}" target="_self" class="current">下一页</a>
            </div>
            </#if>
        </div>
        <div class="layui-col-md12" style="padding-left: 30%;">
            众游网络版权所有|2019~2022
        </div>
    </div>
</div>

<script src="../js/jquery-1.8.0.min.js"></script>
<#--<script src="layui.js"></script>-->
<script src="https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js"></script>
<script>
    layui.use(['layer', 'form', 'element','laypage'], function(){
        var carousel = layui.carousel
            , element = layui.element
            ,laypage = layui.laypage;

    });
</script>
</body>
</html>