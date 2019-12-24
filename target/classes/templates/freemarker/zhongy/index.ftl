<!DOCTYPE ftl>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/ftl; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-image: url('img/bj.jpg')" >
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="https://s2.ax1x.com/2019/12/02/QuhRfI.png" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="Init" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a> &nbsp;&nbsp;<a class="button button-little bg-red" href="/adminout"><span class="icon-power-off"></span> 退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">
    <li><a href="/info" target="right"><span class="icon-caret-right"></span>网站设置</a></li>
    <li><a href="/pass" target="right"><span class="icon-caret-right"></span>修改密码</a></li>

    <li><a href="/advs" target="right"><span class="icon-caret-right"></span>推广信息(首页轮播</a></li>
    <li><a href="#" target="right" title="留言删除,留言筛选"><span class="icon-caret-right"></span>留言管理(维护</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>公告管理</h2>
  <ul>
    <li><a href="Ittadd" target="right" ><span class="icon-caret-right"></span>添加公告</a></li>
    <li><a href="NewticsList" target="right" ><span class="icon-caret-right"></span>公告管理</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
  <ul>
    <li><a href="IttList" target="right"><span class="icon-caret-right"></span>项目管理</a></li>
    <li><a href="cate" target="right"><span class="icon-caret-right"></span>分类管理</a></li>
    <li><a href="/Ittadd" target="right"><span class="icon-caret-right"></span>添加项目</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>用户管理</h2>
  <ul>
    <li><a href="ulists" target="right"><span class="icon-caret-right"></span>用户列表</a></li>
    <li><a href="/ulists" target="right"><span class="icon-caret-right"></span>管理用户</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>特权管理</h2>
  <ul>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>会员特权</a></li>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>会员特权</a></li>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>会员特权</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>审核管理</h2>
  <ul>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>游戏审核</a></li>
    <li><a href="#" target="right"><span class="icon-caret-right"></span>推宣审核</a></li>   
    <li><a href="#" target="right"><span class="icon-caret-right"></span>投稿审核</a></li>   
  </ul> 
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="/info" name="right" width="100%" height="100%"></iframe>
</div>
</body>
</html>