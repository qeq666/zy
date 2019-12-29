<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/ftl; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <div class="padding border-bottom">
        <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><span
                    class="icon-plus-square-o"></span> 添加分类
        </button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="5%">ID</th>
            <th width="15%">分类标题</th>
            <th width="10%">一句话描述</th>
            <th width="10%">操作</th>
        </tr>
        <#if Session["cates"]?exists>
            暂时还没有分类!
          <#else>
            <#list cates as catei_tem>

                <tr>
                    <td>${(catei_tem.t_id)!'不尊在啊'}</td>
                    <td>${(catei_tem.t_type)!'不尊在啊'}</td>
                    <td>${(catei_tem.t_back)!'不尊在啊'}</td>
                    <td><DIV class="button-group"> <a class="button border-main" href="tinfo/${catei_tem.t_id}"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del('${catei_tem.t_id}')"><span class="icon-trash-o"></span> 删除</a> </DIV></td>
                </tr>
            </#list>
        </#if>

    </table>
</div>
<script type="text/javascript">
    function del(id) {
        if (confirm("您确定要删除吗?")) {
            $.get("/delType/"+id,function (data) {
                alert(data);
                location.reload();
            })
        }
    }
</script>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="/addType">
            <div class="form-group">
                <div class="label">
                    <label>分类标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="title" id="title"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>关键字描述：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="s_desc" id="s_desc"/>
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
</body>
</html>