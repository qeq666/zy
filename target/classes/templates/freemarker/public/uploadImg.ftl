<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Title</title>
    <link rel="stylesheet" href="../css/layui.css">
</head>
<body>
<div class="layui-main">
    <div class="layui-container">
        <div class="layui-row">
            <div class="layui-col-md12">
                <span style="font-weight: bold">当前我的头像</span><br>
                如果您还没有设置自己的头像，系统会显示为默认头像，您需要自己上传一张新照片来作为自己的个人头像
                <p style="padding-top: 20px">
                    <img src="../img/slt.jpg" alt="" style="width: 180px;height: 180px;border-radius: 8px">
                </p>
                <span style="font-weight: bold" > 设置我的新头像</span><br>
                <span style="padding-top: 20px">请选择一个新照片进行上传编辑。</span><br>
                <span style="margin-top: 20px">头像保存后，您可能需要刷新一下本页面(按F5键)，才能查看最新的头像效果</span><br>
                <button type="button" class="layui-btn" id="test1">
                    <i class="layui-icon">&#xe67c;</i>上传图片
                </button>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery-1.8.0.min.js"></script>
<script src="../layui.js"></script>
<script>
    layui.use("upload ",function () {
        var upload = layui.upload;
        var uploadInst = upload.render({
            elem: '#test1' //绑定元素
            ,url: '/upload/' //上传接口
            ,done: function(res){
                //上传完毕回调
            }
            ,error: function(){
                //请求异常回调
            }
        });
    })
</script>
</body>
</html>