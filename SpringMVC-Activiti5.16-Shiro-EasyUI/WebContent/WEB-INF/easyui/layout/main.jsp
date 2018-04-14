<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglibs/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
</head>

<body>

	<div data-options="region:'north',border:false" title="" style="overflow: hidden; padding: 5px;">
			<div class="toolbar">
					<input id="inputSearch" class="easyui-searchbox"
						data-options="prompt:'请输入客户名称',searcher:doSearch"
						style="width:300px"></input>
					<%-- <shiro:hasPermission name="boss"> --%>
					<!-- <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="jumpTask();">跳转</a> -->
					<%-- </shiro:hasPermission> --%>
			</div>
			<table id="table_order"></table>
	</div>
    
</body>
<script src="${ctx}/js/app/order_remind.js" type="text/javascript"></script>
</html>
