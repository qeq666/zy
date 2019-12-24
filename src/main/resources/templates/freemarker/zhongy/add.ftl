<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
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
<body onload="instantiateTextbox();>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="/addtice">
      <input type="hidden" value="${admin.zuid}" name="uname">
      <div class="form-group">
        <div class="label">
          <label>公告标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="title" data-validate="required:请输入标题" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>公告内容：</label>
        </div>
        <div class="field">
          <textarea id="textbox" name="edit" style="width: 100%; height: 400px;"></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>其他属性：</label>
        </div>
        <div class="field" style="padding-top:8px;">
          置顶 <input id="ittop" value="1"   type="checkbox" name="ittop"/>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 添加公告</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>