<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglibs/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>调整请假申请</title>
<script type="text/javascript">
	$(function() {
		$('#beginDate').datepicker({
			currentText: 'Now',
			showAnim: 'slideDown',
			dateFormat: 'yy-mm-dd'
		}); 
		$('#endDate').datepicker({
			currentText: 'Now',
			showAnim: 'slideDown',
			dateFormat: 'yy-mm-dd'
		});
	  });
	function complete( flag ) {
		$("#reApply").val(flag);
		$("#customer").submit();
	}
</script>  
</head>

<body>
<form:form action="${ctx }/customerAction/modifycustomer/${customer.task.id }" id="customer" modelAttribute="customer" method="POST">
	<input type="hidden" name="custId" value="${customer.custId }" />
	<input type="hidden" name="processInstanceId" value="${customer.processInstanceId }" />
	<input type="hidden" name="userId" value="${user.id }" />
	<input type="hidden" id="reApply" name="reApply" value="" />
	<div id="main">
        <div class="where">
            <ul>
            	<form:errors path="*" cssStyle="font-color:red"/>
            </ul>
        </div>
        
      <div class="sort_switch">
          <ul id="TabsNav">
          	  <li class="selected"><a href="#">变更客户信息</a></li>
          </ul>
      </div>
      
      <div id="tagContent0" class="sort_content">
			
        	<div class="currency_area hue9">
            	<div class="the_content">
                	<table class="tableHue2" width="100%" border="1" bordercolor="#dddddd" cellspacing="0" cellpadding="0">
                      <tbody>
                       <tr>
							<td width="15%" class="title1">客户编号：</td>
							<td class="left"><input name="custCode" type="text" class="input_text2" size="30" 
							 value="${customer.custCode }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">客户名称：</td>
							<td class="left"><input name="custName" type="text" class="input_text2" size="30" 
							value="${customer.custName }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">所属机构：</td>
							 <td class="left">
							<form:select path="branch">
								<option></option>
								<form:option value="wuhan">武汉</form:option>
								<form:option value="fujian">福建</form:option>
							</form:select>
						  </td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">所属员工：</td>
							<td class="left"><input name="owner" type="text" class="input_text2" size="30" 
							value="${customer.owner }" /></td>
                        </tr>
                        
                        <tr>
							<td width="15%" class="title1">公司地址：</td>
							<td class="left"><input name="address" type="text" class="input_text2" size="30" 
							value="${customer.address }" /></td>
                        </tr>
                        <tr>
                          <td width="15%" class="title1"><label for="createDate" class="title1">开始日期：</label></td>
                          <td class="left"><input name="createDate" id="createDate" value="<fmt:formatDate value="${customer.createDate }" pattern="yyyy-MM-dd" />" type="text" class="input_text2" size="30" readonly/></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">客户状态：</td>
							<td class="left"><input name="custState" type="text" class="input_text2" size="30" 
							value="${customer.custState }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人：</td>
							<td class="left"><input name="contacts1" type="text" class="input_text2" size="30" 
							value="${customer.contacts1 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人职位：</td>
							<td class="left"><input name="position1" type="text" class="input_text2" size="30" 
							value="${customer.position1 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人座机：</td>
							<td class="left"><input name="tel1" type="text" class="input_text2" size="30" 
							value="${customer.tel1 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人手机：</td>
							<td class="left"><input name="mobile1" type="text" class="input_text2" size="30" 
							value="${customer.mobile1 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人邮箱：</td>
							<td class="left"><input name="email1" type="text" class="input_text2" size="30" 
							value="${customer.email1 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人QQ：</td>
							<td class="left"><input name="qq1" type="text" class="input_text2" size="30" 
							value="${customer.qq1 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人：</td>
							<td class="left"><input name="contacts2" type="text" class="input_text2" size="30" 
							value="${customer.contacts2 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人职位：</td>
							<td class="left"><input name="position2" type="text" class="input_text2" size="30" 
							value="${customer.position2 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人座机：</td>
							<td class="left"><input name="tel2" type="text" class="input_text2" size="30" 
							value="${customer.tel2 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人手机：</td>
							<td class="left"><input name="mobile2" type="text" class="input_text2" size="30" 
							value="${customer.mobile2 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人邮箱：</td>
							<td class="left"><input name="email2" type="text" class="input_text2" size="30" 
							value="${customer.email2 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人QQ：</td>
							<td class="left"><input name="qq2" type="text" class="input_text2" size="30" 
							value="${customer.qq2 }" /></td>
                        </tr>
                         <tr>
							<td width="15%" class="title1">第三联系人：</td>
							<td class="left"><input name="contacts3" type="text" class="input_text2" size="30" 
							value="${customer.contacts3 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第三联系人职位：</td>
							<td class="left"><input name="position3" type="text" class="input_text2" size="30" 
							value="${customer.position3 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第三联系人座机：</td>
							<td class="left"><input name="tel3" type="text" class="input_text2" size="30" 
							value="${customer.tel3 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第三联系人手机：</td>
							<td class="left"><input name="mobile3" type="text" class="input_text2" size="30" 
							value="${customer.mobile3 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第三联系人邮箱：</td>
							<td class="left"><input name="email3" type="text" class="input_text2" size="30" 
							value="${customer.email3 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第三联系人QQ：</td>
							<td class="left"><input name="qq3" type="text" class="input_text2" size="30" 
							value="${customer.qq3 }" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">备注：</td>
							<td class="left"><input name="remarks" type="text" class="input_text2" size="30" 
							value="${customer.remarks }" /></td>
                        </tr>
                        <tr>
                       		<td width="15%" class="title1">评论：</td>
                          	<td class="left">
                          		
								<table>
									<c:forEach var="comment" items="${commentList}">
									<tr>
										<td>${comment.userName}- <fmt:formatDate value="${comment.time }" type="date" /> </td>
									</tr>
									<tr>
										<td>${comment.content}</td>
									</tr>
									</c:forEach>
								</table>
							</td>
                        </tr>
                      </tbody>
                  </table>
				  
                </div>
            </div>
            
            <div class="fun_area" style="text-align:center;">
            	<input type="button" onclick="complete(true)" value="提 交" class="input_button1"/>
            	<input type="button" onclick="complete(false)" value="取消申请" class="input_button1"/>
            </div>

      </div>
</div>
</form:form>
</body>
</html>
