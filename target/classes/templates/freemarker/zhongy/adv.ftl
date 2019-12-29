<!DOCTYPE ftl>
<ftl lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/ftl; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
  <style>
    .fileinput-button {
      position: relative;
      display: inline-block;
      background: #9d1ccd;
      border: 1px solid #99D3F5;
      border-radius: 4px;
      padding: 4px 12px;
      overflow: hidden;
      color: white;
      text-decoration: none;
      text-indent: 0;
      line-height: 20px;
    }

    .fileinput-button input {
      position: absolute;
      right: 0px;
      top: 0px;
      opacity: 0;
      -ms-filter: 'alpha(opacity=0)';
      font-size: 200px;
      cursor: pointer;
    }
  </style>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  <div class="padding border-bottom">  
  <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><span class="icon-plus-square-o"></span> 添加内容</button>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="10%">ID</th>
      <th width="20%">图片</th>
      <th width="15%">描述</th>
      <th width="15%">操作</th>
    </tr>
      <#if Session["advs"]?exists>
          <#else>
          <#list advs as advs_item>
              <tr>
                <td>${advs_item.id}</td>
                <td><img src="${advs_item.wl_img}" alt="" width="320" style="border-radius: 3px" height="80" /></td>
                <td>${advs_item.wl_describe}</td>
                <td><div class="button-group">
                <a class="button border-main" href="#add"><span class="icon-edit"></span> 修改</a>
                <a class="button border-red" href="javascript:void(0)" onclick="return del('${advs_item.id}')"><span class="icon-trash-o"></span> 删除</a>
                </div></td>
            </tr>
          </#list>
      </#if>

  </table>
</div>
<script type="text/javascript">
function del(id){
	if(confirm("您确定要删除吗?")){
	  $.get("/delByid/"+id,function (data) {
        alert(data);
        location.reload();
      })
	}
}
</script>
<div class="panel admin-panel margin-top" id="add">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="Rotationchart" enctype="multipart/form-data">
      <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
          <img src="https://s2.ax1x.com/2019/12/02/QuWD9x.png" alt="" width="350" height="74" style="border-radius: 3px">
          <span class="fileinput-button">
            <span>上传</span>
            <input type="file" id="file" name="file" />
        </span>
          <div class="tipss">图片尺寸：1920*500</div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea type="text" class="input" name="note" id="note" style="height:120px;" value=""></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></ftl>