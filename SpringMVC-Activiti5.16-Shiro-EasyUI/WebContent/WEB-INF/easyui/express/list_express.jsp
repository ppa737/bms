﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglibs/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    


<title></title>

</head>

<body>

	<div id="main">
	 	<c:if test="${not empty message}">
			<div id="message" class="alert alert-success">${message}</div>
		</c:if>
    
      <div id="toolbar" style="padding:2px 0">
		<table cellpadding="0" cellspacing="0">
			<tr>
				<td style="padding-left:2px">
					<a id="btnAddExpress" href="javascript:void(0);" class="btn bbtn-primary" iconCls="icon-ok" >新增</a>
					<%-- <shiro:hasPermission name="boss"> --%>
						<!-- <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="jumpTask();">跳转</a> -->
					<%-- </shiro:hasPermission> --%>
				</td>
			</tr>
		</table>
	 </div>
      
      <div class="sort_content">
       <table id="table_express"></table>
      	
      </div>

<!--        <div id="dialog_add_express" title="add">
		  <p>
		    <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 1px 5px 0;">2131232</span>
		    
		  </p>
		</div> -->
</div>
    
    
    
<!-- 模态框（Modal）组织机构树 -->
<div class="modal fade" id="expressModal" tabindex="0" role="dialog"
	aria-labelledby="treeModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width:600px;margin:0 auto;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="expressModalTitle">快递信息</h4>
			</div>
			<div class="modal-body">
				<div class="panel-default">
					<div class="panel-body">
						<form id="form_express" method="post"  action="${ctx }/expressAction/doAdd" modelAttribute="express" method="POST">
							<input type="hidden" id="opera" value="" />
                            <input type="hidden" id="expressId" name="expressId"  value="" />
                            <div class="form-group">
                                <label class="col-sm-3 control-label">快递单号：</label>
                                <div class="col-sm-9">
                                    <input id="expressCode" name="expressCode" class="form-control  valid" type="text"/>
                                </div>
                            </div>
						
							<div class="form-group">
                                <label class="col-sm-3 control-label">快递公司：</label>
                                <div class="col-sm-9">
                                    <input id="expressCompany" name="expressCompany" class="form-control  valid" type="text"/>
                                </div>
                            </div>
							<div class="form-group">
                                <label class="col-sm-3 control-label">类型：</label>
                                <div class="col-sm-9">
                                    <select id="expressType" class="form-control">
										<option value="receive">收</option>
										<option value="send">发</option>
									</select>
                                </div>
                            </div>
							<div class="form-group">
                                <label class="col-sm-3 control-label">发件日期：</label>
                                <div class="col-sm-9">
                                    <input id="expressDate" name="expressDate" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label">客户状态：</label>
                                <div class="col-sm-9">
                                     <select id="branch" class="form-control">
										<option value="1">启用</option>
										<option value="0">停用</option>
									</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">收件人：</label>
                                <div class="col-sm-9">
                                    <input id="receiver" name="receiver" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">收件公司：</label>
                                <div class="col-sm-9">
                                    <input id="receiverCompany" name="receiverCompany" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">收件地址：</label>
                                <div class="col-sm-9">
                                    <input id="position1" name="receiverAddress" class="receiverAddress  valid" type="text"/>
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="col-sm-3 control-label">收件人电话：</label>
                                <div class="col-sm-9">
                                    <input id="receiverTel" name="receiverTel" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">发件人：</label>
                                <div class="col-sm-9">
                                    <input id="sender" name="sender" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">发件公司：</label>
                                <div class="col-sm-9">
                                    <input id="senderCompany" name="senderCompany" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">发件地址：</label>
                                <div class="col-sm-9">
                                    <input id="senderAddress" name="senderAddress" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label">发件人电话：</label>
                                <div class="col-sm-9">
                                    <input id="senderTel" name="senderTel" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">快递内容：</label>
                                <div class="col-sm-9">
                                    <input id="expressComment" name="expressComment" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">录入人：</label>
                                <div class="col-sm-9">
                                    <input id="createUser" name="createUser" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                           
                      		<div class="form-group">
                                <label class="col-sm-3 control-label">录入日期：</label>
                                <div class="col-sm-9">
                                    <input id="createDate" name="createDate" class="form-control  valid" type="text"/>
                                </div>
                            </div>
				    </form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_b" id="btnSaveExpress" type="submit">保存</button>
				<button type="button" class="btn btn-default btn_b"
					data-dismiss="modal" id="btnCancel">取消</button>
			</div>
		</div>
	</div>
</div>
</body>
	
	<script src="${ctx}/js/app/express.js" type="text/javascript">
	</script>
</html>
