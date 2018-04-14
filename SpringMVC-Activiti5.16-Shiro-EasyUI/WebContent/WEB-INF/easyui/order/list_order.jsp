<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglibs/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
			<title>订单管理</title>
</head>

<body>

	<div id="main">
		<c:if test="${not empty message}">
			<div id="message" class="alert alert-success">${message}</div>
		</c:if>



		<div class="container-fluid">
			<div class="row">
				<div style="padding-left:2px">
					<a id="btnAddOrder" href="javascript:void(0);"
						class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
					<input id="inputSearch" class="easyui-searchbox"
						data-options="prompt:'请输入客户名称',searcher:doSearch"
						style="width:300px"></input>
					<!-- 					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="delegateTask();">委派</a>
 -->
					<%-- <shiro:hasPermission name="boss"> --%>
					<!-- <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="jumpTask();">跳转</a> -->
					<%-- </shiro:hasPermission> --%>
				</div>
			</div>
			<table id="table_order"></table>

		</div>
	</div>



	<!-- 模态框（Modal）客户信息 -->
	<div class="modal fade" id="orderModal" tabindex="0" role="dialog"
		aria-labelledby="treeModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="width:800px;margin:0 auto;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="orgModalTitle">订单管理</h4>
				</div>
				<div class="modal-body">
					<div class="panel-default">
						<div class="panel-body">
							<form id="form_order" method="">
								<input type="hidden" id="opera" value="" /> <input
									type="hidden" id="orderId" name="orderId" value="" /> <input
									type="hidden" id="orderCode" name="orderCode" value="" />
								<div class="form-group">
									<label class="col-sm-3 control-label">客户名称：</label>
									<div class="col-sm-9">
										<input type="text" id="orderName" name="orderName"
											class="form-control col-sm-9" value="" style="width: 260px;" readonly="readonly">
											<div class="col-sm-3">
												<a class="btn btn-sm btn-info" id="openCust">选择</a>
											</div> <!-- <input id="orderName" name="orderName" class="form-control  valid" type="text"/>
                                    <button class="btn btn-sm btn-danger">选择</button> -->
									</div>
								</div>
								<!--                             <div class="form-group">
                                <label class="col-sm-3 control-label">联系人：</label>
                                <div class="col-sm-9">
                                    <input id="orderCode" name="orderCode" class="form-control  valid" type="text"/>
                                </div>
                            </div> -->
								<div class="form-group">
									<label class="col-sm-3 control-label">订单类型：</label>
									<div class="col-sm-9">
										<select id="orderType" class="form-control">
											<option value="new">初审</option>
											<option value="check">复审</option>
											<option value="recheck">重审</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">认证类型：</label>
									<div class="col-sm-9">
										<select id="certificationType" name="certificationType"
											class="form-control">
											<option value="Q">E</option>
											<option value="EC">EC</option>
											<option value="E">E</option>
											<option value="S">S</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">所属机构：</label>
									<div class="col-sm-9">
										<select id="branch" class="form-control">
											<option value="wuhan">武汉</option>
											<option value="fujian">福建</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">订单金额：</label>
									<div class="col-sm-9">
										<input id="amount" name="amount" class="form-control  valid"
											type="number" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">证书开始时间：</label>
									<div class="col-sm-9">
										<input id="startDate" name="startDate"
											class="form-control  valid" type="text" />
									</div>
								</div>
		<!-- 						<div class="form-group">
									<label class="col-sm-3 control-label">证书到期时间：</label>
									<div class="col-sm-9">
										<input id="endDate" name="endDate" class="form-control  valid"
											type="text" />
									</div>
								</div> -->
								<div class="form-group">
									<label class="col-sm-3 control-label">订单状态：</label>
									<div class="col-sm-9">
										<select id="orderState" class="form-control" value="1">
											<option value="1">有效</option>
											<option value="0">作废</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">备注：</label>
									<div class="col-sm-9">
										<textarea id="comment" name="comment"
											class="form-control  valid" type="text"></textarea>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary " id="btnSaveOrder">保存</button>
					<!-- <button type="button" class="btn btn-primary " id="btnStart">启动流程</button> -->
					<button type="button" class="btn btn-default " data-dismiss="modal"
						id="btnCancel">取消</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 模态框（Modal）客户信息 -->
	<div class="modal fade" id="selCustModal" tabindex="0" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="width:600px;margin:0 auto;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="selCustModalTitle">客户信息</h4>
				</div>
				<div class="modal-body">
					<div class="panel-default">
						<div class="panel-body">

							<input id="inputSearchCust" class="easyui-searchbox"
								data-options="prompt:'Please Input Value',searcher:doSearchCust"
								style="width:300px"></input>

							<table id="table_customer"></table>

						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary " id="btnConfirmCust">确定</button>
					<button type="button" class="btn btn-default " data-dismiss="modal"
						id="btnCancel">取消</button>
				</div>
			</div>
		</div>
	</div>

</body>
<script src="${ctx}/js/app/order.js" type="text/javascript"></script>
</html>
