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
		bindTable : '../orderAction/bindTable',
		doAdd : "../orderAction/doAdd",
		doUpdate : "../orderAction/doUpdate",
		bindCustTable:'../customerAction/bindTable',
	},
	init : function() {
		this.bindEvent();
		this.bindTable();
		this.bindCustTable();
		
		
		
		$("#startDate").datetimepicker({
			language:  'zh-CN',  //日期
			format: 'yyyy-mm-dd',//显示格式
			todayHighlight: 1,//今天高亮
			minView: "month",//设置只显示到月份
			startView:2,
			forceParse: 0,
			showMeridian: 1,
			autoclose: 1//选择后自动关闭
			});
		$("#endDate").datetimepicker({
			language:  'zh-CN',  //日期
			format: 'yyyy-mm-dd',//显示格式
			todayHighlight: 1,//今天高亮
			minView: "month",//设置只显示到月份
			startView:2,
			forceParse: 0,
			showMeridian: 1,
			autoclose: 1//选择后自动关闭
			});
		
	},
	bindEvent : function() {
		var that = this;
		$("#btnAddOrder").bind('click', function() {
			that.add();
		});
		
		$("#btnSaveOrder").bind('click', function() {
			that.saveOrder();
		});
		
		$("#openCust").bind('click', function() {
			that.openCust();
		});
		
		$("#btnConfirmCust").bind('click', function() {
			that.confirmCust();
		});
		
	},

	bindTable : function() {
		var that = this;
		$('#table_order').bootstrapTable({
			method : 'get',
			url : that.url.bindTable,
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
			}, {
				field : 'orderCode',
				title : '客户编号'
			}, {
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
				title : '开始时间',
				formatter : function(value, row, index) {
					if (null != value && "" != value) {
						return new Date(value).format('yyyy-MM-dd hh:mm:ss');
					} else {
						return value;
					}

				}
			}, {
				field : 'orderState',
				title : '订单状态',
				align : 'center',
				formatter : function(value, row, index) {
					var _html="";
					if (value == "1") {
						_html = "有效";
					} else if (value == "0") {
						_html = "<p  class='text-danger'>作废</p >";
					}
					return _html;
				}
			}, {
				field : 'orderId',
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					var _html = "";
					 _html+=("<a class='btn btn-warning btn-xs' href='javascript:void(0);'  onclick='Order.edit("+index+")'>编辑</a>");
					return _html;
				}
			} ]
		});

	},
	
	

	add : function() {
		console.log("btnAddOrder");
		this.clearOrder()
		$("#opera").val("add");
		var options = {
			backdrop : false,
			show : true,
		};
		$('#orderModal').modal(options);
	},
	
	edit : function(index){
		var that =this;
		that.clearOrder();
		$("#opera").val("edit")
		$("#orderModalTitle").text("编辑快递信息信息");
		var row = $('#table_order').bootstrapTable("getData")[index];
		
		$("#opera").val("edit");
		$("#orderId").val(row.orderId);
		$("#orderCode").val(row.orderCode);
		$("#orderName").val(row.orderName);
		$("#orderType").val(row.orderType);
		$("#certificationType").val(row.certificationType);
		$("#branch").val(row.branch);
		$("#amount").val(row.amount);
		$("#startDate").val(row.startDate);
		$("#endDate").val(row.endDate);
		$("#orderState").val(row.orderState);
		$("#comment").val(row.comment);
		
		
		var options = {
				backdrop : false,
				show : true,
			};
		$('#orderModal').modal(options);
	},
	
	saveOrder : function(){
		console.log("saveOrder");
		var that =this;
		var order={
			"orderId" : $("#orderId").val(),
			"orderCode" : $("#orderCode").val(),
			"orderName" : $("#orderName").val(),
			"orderType" : $("#orderType").val(),
			"certificationType" : $("#certificationType").val(),
			"branch" : $("#branch").val(),
			"amount" : $("#amount").val(),
			"startDate" : $("#startDate").val(),
			"endDate" : $("#endDate").val(),
			"orderState" : $("#orderState").val(),
			"comment" : $("#comment").val()
		}
		var url =that.url.doAdd;
		if( $("#orderId").val()!=null &&  $("#orderId").val()!=""){
			url= that.url.doUpdate;
		}
		$.post(url,{"order":JSON.stringify(order)},function(data){
			
			if(data.status){
				swal({
					title : "保存成功!",
					type : "success"
				});
				$('#table_order').bootstrapTable('refresh',{silent: true});
				$('#orderModal').modal('hide');
			}
		})
	},
	
	clearOrder: function(){
		$("#opera").val("")
		$("#orderId").val("");
		$("#orderCode").val("");
		$("#orderName").val("");
		$("#orderType").val(null);
		$("#certificationType").val(null);
		$("#branch").val("");
		$("#amount").val(0);
		$("#startDate").val(new Date().format('yyyy-MM-dd'));
		$("#endDate").val(new Date().format('yyyy-MM-dd'));
		$("#orderState").val("1");
		$("#comment").val("");
	},

	openCust: function(){
		var options = {
				backdrop : false,
				show : true,
			};
			$('#selCustModal').modal(options);
		
	},
	bindCustTable :function(){
		var that =this;
		$('#table_customer').bootstrapTable({
        	method : 'get',
			url : that.url.bindCustTable,
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
			idField : 'custId',
			sidePagination: "server", //服务端处理分页
			// detailView:true,//显示详情
			/*
			 * detailFormatter:function(index, row, element){
			 * return '编码：'+row.ragionid; },
			 */
			queryParams : function(params) {
				var temp = {
						'pageSize' : params.limit,
						'pageNum' : params.offset / params.limit + 1,
						'searchKey':$.trim($("#inputSearchCust").val())
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
			
			columns: [
                {
                    field: 'checkBox',
                    checkbox: true
                },
                {
                    field: 'custName',
                    title: '客户名称'
                },{
                    field: 'address',
                    title: '公司地址',
                    align: 'left',

                },{
                    field: 'createDate',
                    title: '创建时间',
                    formatter: function (value, row, index) {
                    	if(null!=value&&""!=value){
                    		return new Date(value).format('yyyy-MM-dd');
                    	}else{
                    		return value;
                    	}
                        
                    }
                }
                ]
        });
	},
	confirmCust:function(){
		var rows = $('#table_customer').bootstrapTable('getSelections');
		if(rows==null || rows.length==0){
			swal({
				title : "请选择一个客户!",
				type : "info"
			});
			return;
		}else{
			$("#orderCode").val(rows[0].custId);
			$("#orderName").val(rows[0].custName);
			$('#selCustModal').modal("hide");
		}
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