<!DOCTYPE ftl>
<html lang="zh-cn">
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
</head>
<body>
<form method="post" action="swchList" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>搜索：</li>

        <if condition="$iscid eq 1">
          <li>
            <select name="sechtype" id="sechtype" class="input" style="width:200px; line-height:17px;" >
              <option value="">请选择分类</option>
              <#list apls1 as item_type >
                <option value="${item_type.t_id}">${item_type.t_type}</option>
              </#list>
            </select>
          </li>
        </if>
        <li>
          <input type="text" name="title" id="title" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <button class="button border-main icon-search" type="submit"> 搜索</button></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th>图片</th>
        <th>名称</th>
        <th>分类名称</th>
        <th width="10%">更新时间</th>
        <th width="10%">是否置顶</th>
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">

        <#if Session["Itts"]?exists>
            <#else>
            <#list Itts as Itts_item>
              <tr>
                <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />
                 ${Itts_item.id}</td>
                <td width="10%"><img src="${Itts_item.itt_img01}" alt="" width="70" height="50" /></td>
                <td>${Itts_item.itt_title}</td>
                <td>${Itts_item.type}</td>
                <td>${Itts_item.itt_createtime?string("yyyy-MM-dd")}</td>
                <td><#if Itts_item.itt_kind == 2>是<#else >否</#if></td>
                <td><div class="button-group"> <a class="button border-main" href="updateinfo/${Itts_item.id}"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="/IttdeleteByd/${Itts_item.id}"><span class="icon-trash-o"></span> 删除</a> </div></td>
            </tr>
            </#list>
        </#if>


      <tr>
        <td colspan="8"><div class="pagelist">
            <a href="">当前是第[${pageNo}]页</a>
            <a href="/IttList?pageNo=${pageNo-1}">上一页</a>
            <a href="/IttList?pageNo=${pageNo+1}">下一页</a>
            <a href="">尾页</a>
          </div>
        </td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">


//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false;		
		$("#listform").submit();		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

//批量排序
function  sorts(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		return false;
	}
}


//批量首页显示
function changeishome(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}

//批量推荐
function changeisvouch(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");	
		
		return false;
	}
}

//批量置顶
function changeistop(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}


//批量移动
function changecate(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		
		return false;
	}
}

//批量复制
function changecopy(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		var i = 0;
	    $("input[name='id[]']").each(function(){
	  		if (this.checked==true) {
				i++;
			}		
	    });
		if(i>1){ 
	    	alert("只能选择一条信息!");
			$(o).find("option:first").prop("selected","selected");
		}else{
		
			$("#listform").submit();		
		}	
	}
	else{
		alert("请选择要复制的内容!");
		$(o).find("option:first").prop("selected","selected");
		return false;
	}
}


function cktop(istop) {
  var msg = null;
  if(istop == "2"){
    msg = "置顶"
  }else if(istop == "1"){
    msg = "取消置顶"
  }
  return msg;
}

</script>
</body>
</html>