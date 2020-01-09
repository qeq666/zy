<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>项目列表-众游</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel='icon' href="img/favicon.ico" type='image/x-ico' />
    <style>
        *{
            padding: 0;
            margin: 0;
        }
        #ittList a{
            color: #FFCC66;
            font-size: 20;
            list-style: none;
            text-decoration: none;
        }
        #ittList a:hover{
            color: #6666ff;
        }
    </style>
</head>
<body style="background-color: rgba(198,243,255,0.4)">
<!--引用公用头部-->
<iframe MARGINWIDTH=0 MARGINHEIGHT=0 HSPACE=0 VSPACE=0 FRAMEBORDER=0 SCROLLING=no src=editItt height=“auto” width="100%"></iframe>

<div class="container">
    <div class="row">
       <div class="row">
           <div class="col-md-12">
               <ol class="breadcrumb">
                   <li><a href="/Init">首页</a></li>
                   <li><a href="#">项目专区</a></li>
                   <li class="active">动漫</li>
               </ol>
           </div>
       </div>
        <!--路径导航stop;-->
            <div class="col-md-7" style="width: 960px;height: 70px;border: 1px #CECFCE solid">

                <div class="col-md-6">
                    <ul class="list-inline" style="padding-top: 12px">
                        <li><span class="h4" style="font-weight: bold">今日设计</span></li>
                        <li >今日: <span style="color: #F71818;">${zy_invitationscount}</span>&nbsp;&nbsp;<span class="glyphicon glyphicon-cloud-download" style="color: #F71818;"></span></li>
                        <li></li>
                        <li>主题: <span style="color: #F71818;">${zy_invitationscount}</span></li>
                        <li></li>
                        <li>排名: <span style="color: #F71818;">${zy_invitationscount}</span>&nbsp;&nbsp;<span class="glyphicon glyphicon-cloud-upload" style="color: #F71818;"></span></li>
                        <li></li>
                    </ul>
                    <ul class="list-inline">
                        <li style="font: 12px/1.5 Tahoma,Helvetica,'SimSun',sans-serif">版主: <span><a href="#">小众众</a></span></li>
                    </ul>
                </div>
                <div class="col-md-2 pull-right" style="padding-top: 12px">
                    <span class="glyphicon glyphicon-bookmark" style="color: #FFB25A;"></span>&nbsp;&nbsp;<a href="#">收藏板块 <span style="color: #F76D73;">(${zy_invitationscount})</span></a>
                </div>
            </div>
        <div class="col-md-2 pull-right" style="background-color:#f5f5f5 ;width: 170px;height: 89px;">
            <div class="col-md-10 pull-right">
                <span class="h4" style="line-height:30px;font-size: 17px;box-sizing: border-box;border: 0px solid transparent;">联系我们</span>
            </div>
            <div class="col-md-12 pull-right">
                &nbsp;
            </div>
            <div class="col-md-10 pull-right">
                <a target="_blank" href="tencent://message/?uin=你QQ&Site=http://77ya.com/&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:944358609:1"></a>
            </div>
            <#--<a target="_blank" href="tencent://message/?uin=你QQ&Site=http://77ya.com/&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:944358609:2"></a>
            <a target="_blank" href="tencent://message/?uin=你QQ&Site=http://77ya.com/&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:944358609:3"></a>
            <a target="_blank" href="tencent://message/?uin=你QQ&Site=http://77ya.com/&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:944358609:6"></a>
            风格七代码：
            <a target="_blank" href="tencent://message/?uin=你QQ&Site=http://77ya.com/&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:944358609:7"></a>
            风格十一代码：
            <a target="_blank" href="tencent://message/?uin=你QQ&Site=http://77ya.com/&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:944358609:11"></a>
            风格十二代码：
            <a target="_blank" href="tencent://message/?uin=你QQ&Site=http://77ya.com/&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:944358609:12"></a>
            风格十三代码：
            <a target="_blank" href="tencent://message/?uin=你QQ&Site=http://77ya.com/&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:944358609:13"></a>
            风格十六代码：
            <a target="_blank" href="tencent://message/?uin=你QQ&Site=http://77ya.com/&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:944358609:16"></a>
        --></div>
        <!--板块介绍stop;-->
        <div class="row">
            <div style="width: 960px;height: 33px;">
                <div class="col-md-4" style="padding-top: 24px">
                    <button type="button" class="btn btn-primary" style="width: 80px;height: 33px" onclick="location.href='/sendf'">发帖</button>
                </div>
                <div class="col-md-8">
                    <nav aria-label="...">
                        <ul class="pager">
                            <li><a href="#">上一页</a></li>
                            <li><a href="#">下一页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <!--发帖 上页 下页 结束-->
        <div class="row">
            <div class="col-md-12" ><div style="border-bottom: silver 2px solid;width: 960px"></div></div>
        </div>
    </div>
    <!--导航结束-->
    <!--下面帖子;-->
    <div class="row">
        <div style="height: 850px;width: 960px;border: silver 1px solid;padding-left: 2px;margin-top: 12px;padding-left: 30px" id="ittList">
            <table style="width: 900px;height: 41px;border-bottom:  1px silver solid" >
                <th style="width: 50%;">名称</th>
                <th style="width: 50%;">日期</th>
            </table>
            <#if Session["zy_invitations"]?exists>
                <#else>
                <#list zy_invitations as zy_invitations_item>
                    <a href="/gname/${zy_invitations_item.id}">
                        <table style="width: 900px;height: 41px;border-bottom:  1px silver solid">
                            <th style="width: 50%;">${zy_invitations_item.itt_title}</th>
                            <td style="width: 50%;">${zy_invitations_item.itt_createtime}</td>
                        </table>
                    </a>
                </#list>
            </#if>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8 pull-right">
            众游版权所有|2019~2020
        </div>
    </div>
</div>

<div class="layui-col-md8" style="padding-left: 50%">
    ${idxinfo.home_topinfo }
</div>
<script src="js/jquery-1.8.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>