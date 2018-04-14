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
	Customer.init();
	var message = "${message}";
	var error = "${error}";
	if(message != ""){
		$( "#dialog-complete" ).dialog({
		      modal: true,
		      buttons: {
		        Ok: function() {
		          $( this ).dialog( "close" );
		        }
		      }
	    });
	}
	if(error != ""){
		$( "#dialog-error" ).dialog({
		      modal: true,
		      buttons: {
		        Ok: function() {
		          $( this ).dialog( "close" );
		        }
		      }
	    });
	}
});

var Customer ={
	url:{
		bindTable:'../customerAction/bindTable',
		doAdd: "../customerAction/doAdd",
		doUpdate: "../customerAction/doUpdate",
	},
	init: function(){
		this.bindEvent();
		this.bindTable();
		$("#createDate").datetimepicker({
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
	bindEvent : function(){
		var that =this;
		$("#btnAddCust").bind('click', function () {
            that.add();
        });
		
		$("#btnSaveCust").bind('click', function () {
            that.saveCustomer();
        });
		
		
	},
	
	bindTable :function(){
		var that =this;
		$('#table_customer').bootstrapTable({
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
                }, {
                    field: 'custState',
                    title: '排序',
                    align: 'center'
                },  {
                    field: 'custId',
                    title: '操作',
                    align: 'center',
                    formatter: function (value, row, index) {
                        var _html = "";
                        _html+=("<a class='btn btn-warning btn-xs' href='javascript:void(0);'  onclick='Customer.edit("+index+")'>编辑</a>");
                        return _html;
                    }
                }]
        });
	},
	
	add : function(){
		this.clearCustomer();
		$("#opera").val("add")
		var options = {
				backdrop : false,
				show : true,
			};
		$('#custModal').modal(options);
	},
	
	edit : function(index){
		var that =this;
		that.clearCustomer();
		$("#opera").val("edit")
		$("#custModalTitle").text("编辑快递信息信息");
		var row = $('#table_customer').bootstrapTable("getData")[index];
		$("#custId").val(row.custId);
		$("#custCode").val(row.custCode);
		$("#custName").val(row.custName);
		$("#branch").val(row.branch);
		$("#address").val(row.address);
		$("#createDate").val(row.createDate);
		$("#custState").val(row.custState);
		$("#contacts1").val(row.contacts1);
		$("#position1").val(row.position1);
		$("#tel1").val(row.tel1);
		$("#mobile1").val(row.mobile1);
		$("#email1").val(row.email1);
		$("#qq1").val(row.qq1);
		$("#contacts2").val(row.contacts2);
		$("#position2").val(row.position2);
		$("#mobile2").val(row.mobile2);	
		$("#email2").val(row.email2);		
		$("#qq2").val(row.qq2);		
		$("#contacts3").val(row.contacts3);		
		$("#position3").val(row.position3);		
		$("tel3").val(row.tel3);		
		$("#mobile3").val(row.mobile3);		
		$("#email3").val(row.email3);		
		$("#qq3").val(row.qq3);		
		$("#comment").val(row.comment);		
		
		
		var options = {
				backdrop : false,
				show : true,
			};
		$('#custModal').modal(options);
	},
	
	saveCustomer : function(){
		var that =this;
		var customer={
			"custId": $("#custId").val(),
			"custCode": $("#custCode").val(),
			"custName": $("#custName").val(),
			"branch": $("#branch").val(),
			"address": $("#address").val(),
			"createDate": $("#createDate").val(),
			"custState": $("#custState").val(),
			"contacts1": $("#contacts1").val(),
			"position1": $("#position1").val(),
			"tel1": $("#tel1").val(),
			"mobile1": $("#mobile1").val(),
			"email1": $("#email1").val(),
			"qq1": $("#qq1").val(),
			"contacts2": $("#contacts2").val(),
			"position2": $("#position2").val(),
			"mobile2": $("#mobile2").val(),	
			"email2": $("#email2").val(),		
			"qq2": $("#qq2").val(),		
			"contacts3": $("#contacts3").val(),		
			"position3": $("#position3").val(),		
			"tel3": $("tel3").val(),		
			"mobile3": $("#mobile3").val(),		
			"email3": $("#email3").val(),		
			"qq3": $("#qq3").val(),		
			"comment": $("#comment").val(),
		}
		var url=that.url.doAdd;
		if (null!=$("#custId").val()&&""!=$("#custId").val() ){
			url=that.url.doUpdate;
		}
		
		$.post(url,{"customer":JSON.stringify(customer)},function(data){
			
			if(data.status){
				swal({
					title : "保存成功!",
					type : "success"
				});
				$('#table_customer').bootstrapTable('refresh',{silent: true});
				$('#custModal').modal('hide');
			}
		})
	},
	
	clearCustomer: function(){
		$("#opera").val("edit");
		$("#custId").val("");
		$("#custCode").val("");
		$("#custName").val("");
		$("#branch").val("");
		$("#address").val("");
		$("#createDate").val(new Date().format('yyyy-MM-dd'));
		$("#custState").val("");
		$("#contacts1").val("");
		$("#position1").val("");
		$("#tel1").val("");
		$("#mobile1").val("");
		$("#email1").val("");
		$("#qq1").val("");
		$("#contacts2").val("");
		$("#position2").val("");
		$("#mobile2").val("");	
		$("#email2").val("");		
		$("#qq2").val("");		
		$("#contacts3").val("");		
		$("#position3").val("");		
		$("tel3").val("");		
		$("#mobile3").val("");		
		$("#email3").val("");		
		$("#qq3").val("");		
		$("#comment").val("");		
	}
		
}
function doSearchCust(value){
	
	$('#table_customer').bootstrapTable('refresh', {
		silent : true
	});
}