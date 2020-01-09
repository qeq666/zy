<!DOCTYPE html>
<html lang="zh" class="no-js">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>众游-邮箱注册-填写信息</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
    <link rel="stylesheet" type="text/css" href="css/component.css"/>
    <link rel='icon' href="img/favicon.ico" type='image/x-ico' />
    <!--[if IE]>
    <script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>

    <![endif]-->
    <script src="js/jquery-1.8.0.min.js"></script>
</head>
<body>
<div class="container">
    <header class="codrops-header">
        <h1>众游-独立开发-编程-共享 <span>邮箱注册</span></h1>
    </header>
    <form action="/register" method="post">
        <input type="hidden" name="name" id="name" value="${id!'不存在'}">
        <section class="content bgcolor-1">
            <h2 class="nomargin-bottom">邮箱注册</h2>
            <span class="input input--haruki">
					<input class="input__field input__field--haruki" type="text" id="Email" placeholder="输入密码" name="Email" style="font-size: 18px;padding-top: 18px"/>
					<label class="input__label input__label--haruki" for="input-1">
						<span class="input__label-content input__label-content--haruki"></span>
					</label>
            </span>
            <span class="input input--haruki">
					<input class="input__field input__field--haruki" type="text" id="pwd" placeholder="确认密码" name="pwd" style="font-size: 18px;padding-top: 18px"/>
					<label class="input__label input__label--haruki" for="input-1">
						<span class="input__label-content input__label-content--haruki"></span>
					</label>
            </span>
            <span class="input input--haruki">
			<select id="s_province" name="s_province" style="height: 35px"></select>
            <select id="s_city" name="s_city" style="height: 35px"></select>
            <select id="s_county" name="s_county" style="height: 35px"></select>
            <script class="resources library" src="js/area.js" type="text/javascript"></script>
            <script type="text/javascript">_init_area();</script>
            </span>
            <span class="input input--haruki">
                <img id="code" name="code" src="http://127.0.0.1/api/captcha" alt=" " style="width: 120px;height: 60px;"
            </span>
            <span class="input input--haruki">
					<input class="input__field input__field--haruki" type="text" placeholder="输入验证码" id="code" name="code" style="font-size: 18px;padding-top: 18px"/>
					<label class="input__label input__label--haruki" for="input-1">
						<span class="input__label-content input__label-content--haruki"></span>
					</label>
            </span>
        </section>
        <button class="button1" type="submit">注册</button>
    </form>




</div><!-- /container -->
<div class="layui-col-md8" style="padding-left: 50%">
    ${idxinfo.home_topinfo }
</div>
<script src="js/classie.js"></script>
<script>
    (function () {
        // trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
        if (!String.prototype.trim) {
            (function () {
                // Make sure we trim BOM and NBSP
                var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
                String.prototype.trim = function () {
                    return this.replace(rtrim, '');
                };
            })();
        }

        [].slice.call(document.querySelectorAll('input.input__field')).forEach(function (inputEl) {
            // in case the input is already filled..
            if (inputEl.value.trim() !== '') {
                classie.add(inputEl.parentNode, 'input--filled');
            }

            // events:
            inputEl.addEventListener('focus', onInputFocus);
            inputEl.addEventListener('blur', onInputBlur);
        });

        function onInputFocus(ev) {
            classie.add(ev.target.parentNode, 'input--filled');
        }

        function onInputBlur(ev) {
            if (ev.target.value.trim() === '') {
                classie.remove(ev.target.parentNode, 'input--filled');
            }
        }
    })();
</script>
</body>
</html>
