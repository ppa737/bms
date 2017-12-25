<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglibs/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form:form action="${ctx }/vacationAction/doAdd" modelAttribute="vacation" method="POST">
        <div id="main">
        <div class="where">
            <ul>
            	<form:errors path="*" cssStyle="font-color:red"/>
            </ul>
        </div>
        <div id="dialog-complete" title="complete">
		  <p>
		    <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 1px 5px 0;"></span>
		    ${message}
		  </p>
		</div>
		<div id="dialog-error" title="error">
		  <p>
		    <span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 1px 5px 0;"></span>
		    ${error}
		  </p>
		</div>
      <div class="sort_switch">
          <ul id="TabsNav">
          	  <li class="selected"><a href="#">新增客户信息</a></li>
          </ul>
      </div>
      
      <div id="tagContent0" class="sort_content">
        	<div class="currency_area hue9">
            	<div class="the_content">
                	<table class="tableHue2" width="100%" border="1" bordercolor="#dddddd" cellspacing="0" cellpadding="0">
                      <tbody>
                        <tr>
							<td width="15%" class="title1">客户编号：</td>
							<td class="left"><input name="custCode" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">客户名称：</td>
							<td class="left"><input name="custName" type="text" class="input_text2" size="30" /></td>
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
							<td class="left"><input name="owner" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        
                        <tr>
							<td width="15%" class="title1">公司地址：</td>
							<td class="left"><input name="address" type="text" class="input_text2" size="30" /></td>
                        </tr>
 						<tr>
                          <td width="15%" class="title1">
                          	<label for="createDate" class="title1">开始日期：</label>
                          </td>
                          <td class="left">
                          	<form:input id="createDate" path="createDate" cssClass="input_text2"/>
                          </td>
                        </tr>
                        
                        <tr>
							<td width="15%" class="title1">客户状态：</td>
							<td class="left"><input name="custState" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人：</td>
							<td class="left"><input name="contacts1" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人职位：</td>
							<td class="left"><input name="position1" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人座机：</td>
							<td class="left"><input name="tel1" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人手机：</td>
							<td class="left"><input name="mobile1" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人邮箱：</td>
							<td class="left"><input name="email1" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第一联系人QQ：</td>
							<td class="left"><input name="qq1" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人：</td>
							<td class="left"><input name="contacts2" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人职位：</td>
							<td class="left"><input name="position2" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人座机：</td>
							<td class="left"><input name="tel2" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人手机：</td>
							<td class="left"><input name="mobile2" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人邮箱：</td>
							<td class="left"><input name="email2" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第二联系人QQ：</td>
							<td class="left"><input name="qq2" type="text" class="input_text2" size="30" /></td>
                        </tr>
                         <tr>
							<td width="15%" class="title1">第三联系人：</td>
							<td class="left"><input name="contacts3" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第三联系人职位：</td>
							<td class="left"><input name="position3" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第三联系人座机：</td>
							<td class="left"><input name="tel3" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第三联系人手机：</td>
							<td class="left"><input name="mobile3" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第三联系人邮箱：</td>
							<td class="left"><input name="email3" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">第三联系人QQ：</td>
							<td class="left"><input name="qq3" type="text" class="input_text2" size="30" /></td>
                        </tr>
                        <tr>
							<td width="15%" class="title1">备注：</td>
							<td class="left"><input name="comment" type="text" class="input_text2" size="30" /></td>
                        </tr>
                      
                      </tbody>
                  </table>
                </div>
            </div>
            <div class="fun_area" style="text-align:center;"><input type="submit" value="确 定" class="input_button1"/></div>
      	</div>
	</div>        
    </form:form>
<script type="text/javascript" src="js/customer.js"></script>
</body>
</html>