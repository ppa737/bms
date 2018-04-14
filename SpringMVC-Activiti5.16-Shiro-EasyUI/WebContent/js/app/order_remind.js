Date.prototype.format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}
$(function() {
	Order.init();
	var message = "${message}";
	var error = "${error}";
	if (message != "") {
		$("#dialog-complete").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	}
	if (error != "") {
		$("#dialog-error").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	}
});

var Order = {
	url : {
		bindRemindTable : ctx+'/orderAction/bindRemindTable',
		doUpdateRemind : ctx+"/orderAction/doUpdateRemind",
	},
	init : function() {
		this.bindEvent();
		this.bindTable();
	},
	bindEvent : function() {
		
	},

	bindTable : function() {
		var that = this;
		$('#table_order').bootstrapTable({
			method : 'get',
			url : that.url.bindRemindTable,
			dataType : "json",
			toolbar : '#toolbar', // 工具按钮用哪个容器
			singleSelect : true,
			clickToSelect : true, 
			striped : true,
			cache : false,
			// data-locale:"zh-US" , //表格汉化
			search : false, // 显示搜索框
			pagination : true,
			pageNumber : 1,// 显示分页
			pageSize : 10,
			pageList : [ 10, 25, 50, 100 ],
			idField : 'orderId',
			sidePagination : "server", // 服务端处理分页
			// detailView:true,//显示详情
			/*
			 * detailFormatter:function(index, row, element){ return
			 * '编码：'+row.ragionid; },
			 */
			queryParams : function(params) {
				var temp = {
					'pageSize' : params.limit,
					'pageNum' : params.offset / params.limit + 1,
					'searchKey':$.trim($("#inputSearch").val())
				};
				return temp;
			},
			silent : true, // 刷新事件必须设置
			formatLoadingMessage : function() {
				return "请稍等，正在加载中...";

			},
			responseHandler : function(res) {// 回调
				return res;
			},

			columns : [ {
				field : 'checkBox',
				checkbox : true
			}, {
				field : 'orderName',
				title : '客户名称'
			},  {
				field : 'orderType',
				title : '订单类型',
				align : 'center',
				formatter : function(value, row, index) {
					var _html = "";
					if (value == "new") {
						_html = "初审";
					} else if (value == "check") {
						_html = "复审";
					} else if (value == "recheck") {
						_html = "复审";
					}
					return _html;
				}

			}, {
				field : 'certificationType',
				title : '认证类型',
				align : 'center'
			}, {
				field : 'branch',
				title : '所属机构',
				align : 'center'
			}, {
				field : 'startDate',
				title : '证书开始时间',
				formatter : function(value, row, index) {
					if (null != value && "" != value) {
						return new Date(value).format('yyyy-MM-dd');
					} else {
						return value;
					}

				}
			},{
				field : 'endDate',
				title : '证书到期时间',
				align : 'center',
				formatter : function(value, row, index) {
					if (null != row && row.startDate!=null) {
						
						var orderDate  =new Date(row.startDate) ;
						orderDate.setFullYear(orderDate.getFullYear()+1); 
						orderDate.setDate(orderDate.getDate()-1); 
						var orderMonth = orderDate.getMonth();
						
						var now = new Date();
						now.setMonth(now.getMonth()+2)
						if( orderDate< now){
							return '<span style="color:red;">'+orderDate.format('yyyy-MM-dd')+'</span>'
						}
						
						return orderDate.format('yyyy-MM-dd');
					} else {
						return "";
					}

				}
			}, {
				field : 'createUser',
				title : '创建人',
				align : 'center',
			}, {
				field : 'orderId',
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					var _html = "";
					 _html+=("<a class='btn btn-warning btn-xs' href='javascript:void(0);'  onclick='Order.cancelRemind("+index+")'>不再提醒</a>");
					return _html;
				}
			} ]
		});

	},
	
	

	
	cancelRemind : function(index){
		var that =this;
		$("#opera").val("edit")
		var row = $('#table_order').bootstrapTable("getData")[index];
		
		
		var order={
			"orderId" : row.orderId,
			"remind_status" : '0'
		}
		var url= that.url.doUpdateRemind;
		$.post(url,{"order":JSON.stringify(order)},function(data){
			
			if(data.status){
				swal({
					title : "保存成功!",
					type : "success"
				});
				$('#table_order').bootstrapTable('refresh',{silent: true});
			}
		})
	},
	
}
function doSearch(value){
	
	$('#table_order').bootstrapTable('refresh', {
		silent : true
	});
}

function doSearchCust(value){
	
	$('#table_customer').bootstrapTable('refresh', {
		silent : true
	});
}