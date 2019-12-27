<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>公告管理</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 公告列表</strong></div>
  <div class="padding border-bottom">
  </div> 
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>
      <th>公告标题</th>
      <th>公告内容</th>
      <th>创建时间</th>
      <th>创建者</th>
      <th width="250">操作</th>
    </tr>

      <#if (Session["NewsList"]?exists)!"不存在">
          <#list NewsList as us_item>
              <tr>
                  <td>${us_item.id}</td>
                  <td>${us_item.title}</td>
                  <td>${us_item.comntent}</td>
                  <td>${us_item.createtime?string("yyyy-MM-dd")}</td>
                  <td>${us_item.senduser}</td>
                  <td>
                      <div class="button-group">
                          <#if us_item.kind == 1>
                                <a type="button" class="button border-main" href="/topdesc/${us_item.id}"><span class="icon-edit"></span>置顶</a>
                              <#else>
                                  <a class="button border-red" href="/Notop/${us_item.id}" ><span class="icon-trash-o"></span>
                                      取消置顶
                                  </a>
                          </#if>
                      </div>
                  </td>
                  <td><a type="button" class="button border-main" href="/del/${us_item.id}"><span class="icon-edit"></span>删除</a></td>
              </tr>
              <#else>
              暂时没有公告
          </#list>
          <#else>
              游
      </#if>
  </table>
</div>
<script>
function del(id){
	if(confirm("您确定要删除吗?")){
		
	}
}
</script>

</div>
</body></html>