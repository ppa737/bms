<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
					<a id="btnAddCust" href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" >新增</a>
					<input id="inputSearchCust" class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearchCust" style="width:300px"></input>
					
<!-- 					<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="delegateTask();">委派</a>
 -->					<%-- <shiro:hasPermission name="boss"> --%>
						<!-- <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="jumpTask();">跳转</a> -->
					<%-- </shiro:hasPermission> --%>
				</td>
			</tr>
		</table>
	 </div>
      
    <div class="sort_content">
       <table id="table_customer"></table>
    </div>
</div>
    
    
    
<!-- 模态框（Modal）客户信息 -->
<div class="modal fade" id="custModal" tabindex="0" role="dialog"
	aria-labelledby="treeModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" style="width:600px;margin:0 auto;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="orgModalTitle">模板所属机构</h4>
			</div>
			<div class="modal-body">
				<div class="panel-default">
					<div class="panel-body pre-scrollable">
						<form id="form_cust" method="post"  >
							<input type="hidden" id="opera" value="" />
                            <input type="hidden" id="custId" name="custId"  value="" />
<!--                             <div class="form-group">
                                <label class="col-sm-3 control-label">客户编号：</label>
                                <div class="col-sm-9">
                                    <input id="custCode" name="custCode" class="form-control  valid" type="text"/>
                                </div>
                            </div> -->
							<div class="form-group">
                                <label class="col-sm-3 control-label">客户名称：</label>
                                <div class="col-sm-9">
                                    <input id="custName" name="custName" class="form-control  valid" type="text"/>
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
                                <label class="col-sm-3 control-label">公司地址：</label>
                                <div class="col-sm-9">
                                    <input id="address" name="address" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">创建日期：</label>
                                <div class="col-sm-9">
                                    <input id="createDate" name="createDate" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">客户状态：</label>
                                <div class="col-sm-9">
                                     <select id="custState" class="form-control">
										<option value="1">启用</option>
										<option value="0">停用</option>
									</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第一联系人：</label>
                                <div class="col-sm-9">
                                    <input id="contacts1" name="contacts1" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                             <div class="form-group">
                                <label class="col-sm-3 control-label">第一联系人职位：</label>
                                <div class="col-sm-9">
                                    <input id="position1" name="position1" class="form-control valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第一联系人座机：</label>
                                <div class="col-sm-9">
                                    <input id="tel1" name="tel1" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第一联系人手机：</label>
                                <div class="col-sm-9">
                                    <input id="mobile1" name="mobile1" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第一联系人邮箱：</label>
                                <div class="col-sm-9">
                                    <input id="email1" name="email1" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第一联系人QQ：</label>
                                <div class="col-sm-9">
                                    <input id="qq1" name="qq1" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第二联系人：</label>
                                <div class="col-sm-9">
                                    <input id="contacts2" name="contacts2" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第二联系人职位：</label>
                                <div class="col-sm-9">
                                    <input id="position2" name="position2" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第二联系人座机：</label>
                                <div class="col-sm-9">
                                    <input id="tel2" name="tel2" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第二联系人手机：</label>
                                <div class="col-sm-9">
                                    <input id="mobile2" name="mobile2" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第二联系人邮箱：</label>
                                <div class="col-sm-9">
                                    <input id="email2" name="email2" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第二联系人QQ：</label>
                                <div class="col-sm-9">
                                    <input id="qq2" name="qq2" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第三联系人：</label>
                                <div class="col-sm-9">
                                    <input id="contacts3" name="contacts3" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第三联系人职位：</label>
                                <div class="col-sm-9">
                                    <input id="position3" name="position3" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第三联系人座机：</label>
                                <div class="col-sm-9">
                                    <input id="tel3" name="tel3" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第三联系人手机：</label>
                                <div class="col-sm-9">
                                    <input id="mobile3" name="mobile3" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第三联系人邮箱：</label>
                                <div class="col-sm-9">
                                    <input id="email3" name="email3" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">第三联系人QQ：</label>
                                <div class="col-sm-9">
                                    <input id="qq3" name="qq3" class="form-control  valid" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">备注：</label>
                                <div class="col-sm-9">
                                    <textarea id="comment" name="comment" class="form-control  valid" type="text"></textarea>
                                </div>
                            </div> 
				    </form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary btn_b" id="btnSaveCust">保存</button>
				<button type="button" class="btn btn-default btn_b"
					data-dismiss="modal" id="btnCancelOrg">取消</button>
			</div>
		</div>
	</div>
</div>
</body>
	<script src="${ctx}/js/app/customer.js" type="text/javascript">
	</script>
</html>
