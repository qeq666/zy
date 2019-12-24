<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/ftl; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>网站信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 网站信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="/updattHome">

      <#if Session["infos"]?exists>
      不存在
      <#else>
      <#list infos as item>
      <DIV class="form-group">
        <DIV class="label">
          <label>网站标题：</label>
        </DIV>
        <DIV class="field">
          <input TYPE="text" class="input" name="stitle" VALUE="${item.home_title}" />
          <DIV class="tips"></DIV>
        </DIV>
      </DIV>
      <DIV class="form-group">
        <DIV class="label">
          <label>网站LOGO：</label>
        </DIV>
        <DIV class="field">
          <img src="${item.home_logo}" alt="" style="width: 50px;height: 50px;">
          <input TYPE="button" class="button bg-blue margin-left" id="image1" VALUE="上传" >
          <input type="hidden" name="id"  id="id" value="${item.homeid}">
        </DIV>
      </DIV>
      <DIV class="form-group">
        <DIV class="label">
          <label>网站关键字：</label>
        </DIV>
        <DIV class="field">
          <textarea class="input" name="skeywords" style="height:80px">${item.home_Keyword}</textarea>
          <DIV class="tips"></DIV>
        </DIV>
      </DIV>
      <DIV class="form-group">
        <DIV class="label">
          <label>网站描述：</label>
        </DIV>
        <DIV class="field">
          <textarea class="input" name="sdescription">${item.home_desion}</textarea>
          <DIV class="tips"></DIV>
        </DIV>
      </DIV>
      <DIV class="form-group">
        <DIV class="label">
          <label>底部信息：</label>
        </DIV>
        <DIV class="field">
          <textarea name="scopyright" class="input" style="height:120px;">${item.home_topinfo}</textarea>
          <DIV class="tips"></DIV>
        </DIV>
      </DIV>
      <DIV class="form-group">
        <DIV class="label">
          <label></label>
        </DIV>
        </#list>
        </#if>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>