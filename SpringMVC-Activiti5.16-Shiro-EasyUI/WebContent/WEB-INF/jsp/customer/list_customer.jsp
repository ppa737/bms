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
      <div class="sort_switch">
          <ul id="TabsNav">
          	  <li class="selected" id="vacation"><a href="${ctx}/process-listProcessInstance.action?processType=vacation">请假申请</a></li>
          	  <li class="" id="salary"><a href="${ctx}/process-listProcessInstance.action?processType=salary">薪资调整申请</a></li>
          	  <li class="" id="expense"><a href="${ctx}/process-listProcessInstance.action?processType=expense">报销申请</a></li>
          	  <li class="" id="customer"><a href="${ctx}/process-listProcessInstance.action?processType=customer">客户信息</a></li>
          </ul>
      </div>
      
      <div class="sort_content">
      	<form action="${ctx }/vacationAction/toList_page" method="post">
          <table class="tableHue1" width="100%" border="1" bordercolor="#a4d5e3" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th>客户编号</th>
					<th>客户名称</th>
					<th>所属分公司</th>
					<th>客户地址</th>
					<th>创建日期</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
              <tbody id="tbody">
              <c:forEach var="customer" items="${customerList}">
                <tr>

                  <td>"${customer.custCode }"</td>
                  <td>"${customer.custName }"</td>
                  <td>"${customer.branch }"</td>
                  <td>"${customer.address }"</td>
                  <td><fmt:formatDate value="${customer.createDate }" type="date" /></td>
				  <td>${customer.custState }</td>
                  	<c:choose>
                  		<c:when test="${custtate == 0 }">无效</c:when>
                  		<c:when test="${vacationType == 1 }">有效</c:when>
                  	</c:choose>
                  </td>
				  <td>
				  	  <a href="${ctx }/customerAction/details/${customer.custId }">详细</a>
				  </td>
                </tr>
              </c:forEach>
              </tbody>
          </table>
          </form>
      </div>

      
</div>
    
</body>

</html>
