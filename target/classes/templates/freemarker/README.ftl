<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <title>Welcome to Textbox.io</title>
    <script type='text/javascript' src='plugins/textboxio/textboxio.js'></script>
    <link rel="stylesheet" type="text/css" href="plugins/example.css" />
	<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

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
	<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
	<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
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

  <body onload="instantiateTextbox();">
	<div class="container">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#">首页</a></li>
            <li class="active">发帖</li>
        </ol>
    </div>
    <div class="row" style="padding-top: 20px">
        <!--tabs标签start-->
        <div class="col-md-12 form-control" style="height: 650px;">
            <div>
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">发表帖子</a></li>
                    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">投票</a></li>

                </ul>
                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="home">
                        <div class="row">
                            <div class="col-md-12">
                                <form action="/upload"  method="post" enctype="multipart/form-data">
                                    <div class="col-md-3" style="padding-bottom: 23px;padding-top: 23px">
                                        <span style="font-size: 16px;">&nbsp;&nbsp;标题</span>:&nbsp;&nbsp;<input type="text" name="title" id="title" style="width: 180px"><span style="padding-left: 22px">可编辑 <span style="color: red;">80</span>个字符</span>
                                    </div>
                                    <div class="col-md-6" style="padding-bottom: 23px;padding-top: 23px">
                                        <span style="font-size: 16px;padding-left: 20px">缩略图</span>&nbsp;&nbsp;：<input  type="file" name="file" id="file" style="width: 190px;display: inline-block;padding-left: 20px"></span>
                                    </div>
                                    <div class="col-md-12"style="padding-top: 20px" >
                                        <textarea id="textbox" name="edit" style="width: 100%; height: 400px;"></textarea>
                                    </div>
                                    <div class="col-md-12">
                                        <div style="width: 301px;height: 23px;padding-top: 15px">
                                            <div class="form-control" style="width: 100%;height: 45px;">
                                                <div class="col-md-1">
                                                    <input type="submit" value="发表" class="btn btn-default">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane" id="profile">
                        未上线
                    </div>
                </div>
            </div>
        </div>
    </div>
  </body>
</html>
