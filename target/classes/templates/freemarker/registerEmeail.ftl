<!DOCTYPE html>
<html lang="zh" class="no-js">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>众游-独立开发-编程-共享 -注册</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.2.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
    <link rel="shortcuticon" href="img/ik.ico" type="image/x-icon" />
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
    <form action="/sendEmailurl" method="post">
        <section class="content bgcolor-1">
            <h2 class="nomargin-bottom">邮箱注册</h2>
            <span class="input input--haruki">
					<input class="input__field input__field--haruki" placeholder="输入邮箱" type="text" id="Email" name="Email" style="font-size: 18px;padding-top: 18px" />
					<label class="input__label input__label--haruki" for="input-1">
						<span class="input__label-content input__label-content--haruki"></span>
					</label>
				</span>
            <span class="input input--haruki">
					<img id="code" name="code" src="http://127.0.0.1/api/captcha" alt=" "
                         style="padding-left: 30px;padding-top: 20px;width: 150px;">
				</span>
            <span class="input input--haruki">
					<input class="input__field input__field--haruki" style="font-size: 18px;padding-top: 18px" type="text" id="code" name="code" placeholder="输入验证码"/>
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
