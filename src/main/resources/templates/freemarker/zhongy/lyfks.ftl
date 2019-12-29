<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>反馈信息</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 反馈信息列表</strong></div>
  <div class="padding border-bottom">
  </div> 
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>     
      <th>反馈标题</th>
      <th >反馈内容</th>
      <th>反馈时间</th>
      <th>联系方式</th>
      <th>是否解决</th>
      <th width="300">操作</th>
    </tr>
      <#if (Session["ulists"]?exists)!"不存在">
          <#else>
            <#list fkmsgs as us_item>
                  <tr>
                      <td>${us_item.id}</td>
                      <td>${us_item.title}</td>
                      <td>${us_item.contents}</td>
                      <td>${us_item.createtime?string("yyyy-MM-dd")}</td>
                      <td>${us_item.contact}</td>
                      <td>${us_item.isok}</td>
                      <td>
                      <div class="button-group">
                          <a class="button border-red" href="javascript::void;" onclick="jj('${us_item.id}')" ><span class="icon-trash-o"></span>
                              解决
                          </a>
                          <a class="button border-red" href="javascript::void;" onclick="del('${us_item.id}')"><span class="icon-trash-o"></span>
                              删除该反馈
                          </a>
                      </div>
                      </td>
                </tr>
            </#list>
      </#if>
  </table>
</div>
<script>
function jj(id){
	if(confirm("管理员请确保您修复了BUG")){
		$.get("/upfeedb/"+id,function (data) {
            alert(data);
            location.reload();
        })
	}
}
function del(id){
	if(confirm("确认删除该反馈么?")){
		$.get("/delfeedb/"+id,function (data) {
            alert(data);
            location.reload();
        })
	}
}
</script>

</div>
</body></html>