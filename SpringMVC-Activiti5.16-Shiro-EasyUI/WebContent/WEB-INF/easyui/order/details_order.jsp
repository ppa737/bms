<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<style type="text/css">
    #fm{
        margin:0;
        padding:10px 30px;
    }
    .ftitle{
        font-size:14px;
        font-weight:bold;
        padding:5px 0;
        margin-bottom:10px;
        border-bottom:1px solid #ccc;
    }
    .fitem{
        margin-bottom:5px;
    }
    .fitem label{
        display:inline-block;
        width:80px;
    }
    .fitem input{
        width:160px;
    }
</style>

<div id="dlg" class="easyui-layout" style="padding:10px 20px">
    <div class="ftitle"><img src="${ctx }/extend/fromedit.png" style="margin-bottom: -3px;"/> 订单信息</div>
    <form id="vacation_form" method="post" >
        <div class="fitem">
            <label>客户名称：</label>
            <input id="beginDate" name="beginDate" value = "${order.name }" readonly="readonly" class="easyui-textbox easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>联系人:</label>
            <input id="endDate" name="endDate" value = "${order.orderCode }" readonly="readonly" class="easyui-textbox easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>请假天数:</label>
            <input id="days" name="days" value="${order.days }" readonly="readonly" class="easyui-textbox easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>订单类型:</label>
            <input type="hidden" id="vacationType" value="${order.orderType }">
			<select id="type" class="easyui-combobox" disabled="disabled" name="orderType" style="width:160px;">
			   <option value="new">初审</option>
				<option value="check">复审</option>
				<option value="recheck">重审</option>
			</select>
        </div>
        <div class="fitem">
            <label>认证类型:</label>
            <input type="hidden" id="certificationType" value="${order.orderType }">
			<select id="type" class="easyui-combobox" disabled="disabled" name="certificationType" style="width:160px;">
			  <option value="QE">QE</option>
			  <option value="QC">QC</option>
			</select>
        </div>
         <div class="fitem">
            <label>联系人:</label>
            <input id="endDate" name="endDate" value = "${order.orderCode }" readonly="readonly" class="easyui-textbox easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>认证类型:</label>
            <textarea readonly="readonly" rows="4" cols="50">${order.reason }</textarea>
            <%-- <input id="reason" name="reason"  value = "${order.reason }" class="easyui-textbox" required="true"> --%>
        </div>
    </form>
</div>
