<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Title</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <style>
        .file {
            position: relative; /*绝对定位!*/
            display: inline-block; /*设置为行内元素*/
            background: #D0EEFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 4px 12px;
            overflow: hidden;
            color: #1E88C7;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
        }

        .file input {
            position: absolute; /*相对定位*/
            right: 0;
            top: 0;
            opacity: 0; /*将上传组件设置为透明的*/
            font-size: 100px;
        }

        .file:hover {
            background: #AADDFF;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div>
            <!--这是修改头像-->
            <span class="h4">当前我的头像</span> </br>
            <span>如果您还没有设置自己的头像，系统会显示为默认头像，您需要自己上传一张新照片来作为自己的个人头像</span>
            <p>
                <img src="../../img/logo.png" alt="">
                </br>
            </p>
            <p>
                <span class="h4" style="padding-top: 50px">设置我的新头像</span> </br>
                <span>请选择一个新照片进行上传编辑。</span> </br>
                <span>头像保存后，您可能需要刷新一下本页面(按F5键)，才能查看最新的头像效果</span> </br>
            </p>
            <p>
                <a href="javascript:;" class="file">选择文件
                    <input type="file"/>
                </a>
            </p>
            <p><span class="h4">暂时不支持在线预览上传(选择图片后上传即可</span></p>
        </div>
    </div>
</div>


<script src="../../js/jquery-1.8.0.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
</body>
</html>