<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
  <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong></div>
  <div class="padding border-bottom">
  </div> 
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>     
      <th>用户昵称</th>
      <th>用户邮箱</th>
      <th>用户地址</th>
      <th>是否冻结</th>
      <th>备注</th>
      <th width="250">操作</th>
    </tr>

      <#if (Session["ulists"]?exists)!"不存在">
          <#else>
            <#list ulists as us_item>
                  <tr>
                      <td>${us_item.id}</td>
                      <td>${us_item.user_realname}</td>
                      <td>${us_item.user_email}</td>
                      <td>${us_item.user_phone}</td>
                      <td>${us_item.isdj}</td>
                      <td>${us_item.user_remark}</td>
                      <td>
                      <div class="button-group">
                      <a type="button" class="button border-main" href="#"><span class="icon-edit"></span>编辑</a>
                          <#if us_item.isdj=="是">

                              <a class="button border-red" href="/Thaw/${us_item.id}" ><span class="icon-trash-o"></span>
                                  解冻
                              </a>
                          <#elseif us_item.isdj=="否">
                              <a class="button border-red" href="/Frozen/${us_item.id}" ><span class="icon-trash-o"></span>
                                  冻结
                              </a>
                          </#if>
                      </div>
                      </td>
                </tr>
            </#list>
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