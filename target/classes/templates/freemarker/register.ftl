<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>注册界面</title>
		<link rel="stylesheet" href="css/reset.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/font-awesome.min.css" />
	<style>
		body{ background:#EEEEEE;margin:0; padding:0; font-family:"微软雅黑", Arial, Helvetica, sans-serif; }

		a{ color:#006600; text-decoration:none;}

		a:hover{color:#990000;}

		.top{ margin:5px auto; color:#990000; text-align:center;}

		.info select{ border:1px #993300 solid; background:#FFFFFF;}

		.info{ margin:5px; text-align:center;}
		#submit{
			width: 300px;
			height: 35px;
		}
		#submit:hover{
			border-radius:5px ;
			background-color: #BFAA81;
			transition: all .2s;

		}
		.info #show{ color:#3399FF; }

		.bottom{ text-align:right; font-size:12px; color:#CCCCCC; width:1000px;}
	</style>
	</head>
	<body>
		<div class="wrap login_wrap">
			<div class="content">
				
				<div class="logo"></div>
				
				<div class="login_box">	
					
					<div class="login_form">
						<div class="login_title">
							注册
						</div>
						<form action="/register" method="post">
							
							<div class="form_text_ipt">
								<input id="name" name="name" type="text" onblur="chekuser()" placeholder="手机号/邮箱">
							</div>
							<div class="ececk_warning"><span>&nbsp;</span></div>
							<div class="form_text_ipt">
								<input id="pwd" name="pwd" type="password" placeholder="密码">
							</div>
							<div class="ececk_warning"><span>&nbsp;</span></div>
							<div class="form_text_ipt">
								<input name="repassword" type="password" placeholder="重复密码">
							</div>
							<div class="ececk_warning"><span>&nbsp;</span></div>
							<#--<img id="cpcode" name="cpcode" src="http://bbs.free-http.svipss.top/api/captcha" alt=" " style="padding-left: 30px;padding-top: 20px">-->
							<img id="cpcode" name="cpcode" src="http://127.0.0.1/api/captcha" alt=" " style="padding-left: 30px;padding-top: 20px">
							<div class="form_text_ipt">
								<input id="code" name="code" type="text" placeholder="验证码" >
							</div>

							<div class="ececk_warning"><span>&nbsp;</span></div>
							<div style="padding-left: 30px;padding-bottom: 20px;padding-top: 20px">
								<select id="s_province" name="s_province" style="height: 35px"></select>
								<select id="s_city" name="s_city" style="height: 35px"></select>
								<select id="s_county" name="s_county" style="height: 35px"></select>
								<script class="resources library" src="js/area.js" type="text/javascript"></script>
								<script type="text/javascript">_init_area();</script>
							</div>
							<div class="form_btn">
								<input type="submit" id="submit" value="注册" class="btn btn-primary" style="display: inline-block;border: 0px;color: #626d62;font: bold 16px 文鼎特粗黑簡;border-radius: 5px">
							</div>
							<div class="form_reg_btn">
								<span>已有帐号？</span><a href="index.ftl">马上登录</a>
							</div>
						</form>
						<div class="other_login">
							<div class="left other_left">
								<span>其它登录方式</span>
							</div>
							<div class="right other_right">
								<a href="#"><i class="fa fa-qq fa-2x"></i></a>
								<a href="#"><i class="fa fa-weixin fa-2x"></i></a>
								<a href="#"><i class="fa fa-weibo fa-2x"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/common.js" ></script>
		<script type="text/javascript">
			var Gid  = document.getElementById ;
			var showArea = function(){
				Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" +
						Gid('s_city').value + " - 县/区" +
						Gid('s_county').value + "</h3>"
			}
			Gid('s_county').setAttribute('onchange','showArea()');


			function chekuser() {
				var content = $("#name").val();
				$.get("ckemail","email="+content,function (data) {

					if (data==1) {
						alert("该邮箱已注册过!请更换邮箱");
						$("#name").val("")
					}
				});
			}

		</script>
	</body>
</html>
