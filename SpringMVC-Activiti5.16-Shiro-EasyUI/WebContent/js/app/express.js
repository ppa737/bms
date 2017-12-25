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
	Express.init();
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

var Express ={
	url:{
		bindTable:'../expressAction/bindTable',
		doAdd: "../expressAction/doAdd",
	},
	init: function(){
		this.bindEvent();
		this.bindTable();
	},
	bindEvent : function(){
		var that =this;
		$("#btnAddExpress").bind('click', function () {
            that.addExpress();
        });
		
//		$("#btnSaveExpress").bind('click', function () {
//            that.saveExpress();
//        });
		
		$("#btnSaveExpress").bind('click', function () {
			
            that.saveExpress();
        });
	},
	
	bindTable :function(){
		var that =this
		$('#table_express').bootstrapTable({
        	method : 'get',
			url : that.url.bindTable,
			dataType : "json",
			toolbar : '#toolbar', // 工具按钮用哪个容器
			singleSelect : false,
			striped : true,
			cache : false,
			// data-locale:"zh-US" , //表格汉化
			search : false, // 显示搜索框
			pagination : true,
			pageNumber : 1,// 显示分页
			pageSize : 10,
			pageList : [ 10, 25, 50, 100 ],
			idField : 'expressId',
			sidePagination: "server", //服务端处理分页
			// detailView:true,//显示详情
			/*
			 * detailFormatter:function(index, row, element){
			 * return '编码：'+row.ragionid; },
			 */
			queryParams : function(params) {
				
		       
			},
			silent : true, // 刷新事件必须设置
			formatLoadingMessage : function() {
				return "请稍等，正在加载中...";
				
			},
			responseHandler : function(res) {// 回调
				return res;
			},
			
			queryParams : function(params) {
				var temp = {
						'pageSize' : params.limit,
						'pageNum' : params.offset / params.limit + 1,
					};
				return temp;
			},
			
			columns: [
                {
                    field: 'checkBox',
                    checkbox: true
                },
                {
                    field: 'expressCode',
                    title: '快递编号'
                },
                {
                    field: 'expressCompany',
                    title: '快递公司'
                },  {
                    field: 'expressType',
                    title: '类型',
                    align: 'center',
                    formatter: function (value, row, index) {
                    	var _html=""
                    	if(value=="receive"){
                    		_html= "收";
                    	}else if(value=="send"){
                    		_html=" 发";
                    	}else{
                    		_html=value;
                    	}
                    	return _html;
                    }
                },{
                    field: 'expressDate',
                    title: '发件日期',
                    align: 'center',
                    formatter: function (value, row, index) {
                    	if(null!=value&&""!=value){
                    		return new Date(value).format('yyyy-MM-dd');
                    	}else{
                    		return value;
                    	}
                    }

                },{
                    field: 'receiver',
                    title: '收件人',
                    align: 'center'
                }, {
                    field: 'receiverCompany',
                    title: '收件公司',
                }, {
                    field: 'receiverAddress',
                    title: '收件地址',
                },  {
                    field: 'receiverTel',
                    title: '收件人电话',
                },  {
                    field: 'sender',
                    title: '发件人',
                },  {
                    field: 'senderCompany',
                    title: '发件公司',
                },  {
                    field: 'senderAddress',
                    title: '发件地址',
                },   {
                    field: 'senderTel',
                    title: '发件人电话',
                },   {
                    field: 'expressComment',
                    title: '快递内容',
                },   {
                    field: 'createUser',
                    title: '录入人',
                },   {
                    field: 'expressId',
                    title: '操作',
                    align: 'center',
                    formatter: function (value, row, index) {
                        var _html = "";
                     
                        return _html;
                    }
                }]
        });
		
	},
	
	addExpress : function(){
		console.log("btnAddExpress");
		
		var options = {
				backdrop : false,
				show : true,
			};
		$('#expressModal').modal(options);
	},
	
	editExpress : function(index){
		console.log("editExpress");
		var that =this;
		that.clearExpress();
		$("#opera").val("edit")
		
		var row = $('#table_express').bootstrapTable("getData")[index];
		
		$("#opera").val("edit");
		$("#expressId").val(row.expressId);
		$("#expressCode").val(row.expressCode);
		$("#expressCompany").val(row.expressCompany);
		$("#expressType").val(row.expressType);
		$("#expressDate").val(row.expressDate);
		$("#receiver").val(row.receiver);
		$("#receiverCompany").val(row.receiverCompany);
		$("#receiverAddress").val(row.receiverAddress);
		$("#receiverTel").val(row.receiverTel);
		$("#sender").val(row.sender);
		$("#senderCompany").val(row.senderCompany);
		$("#senderAddress").val(row.senderAddress);
		$("#expressState").val(row.expressState);
		$("#expressComment").val(row.expressComment);
		$("#createUser").val(row.createUser);
		$("#createDate").val(row.createDate);		
		
		
		var options = {
				backdrop : false,
				show : true,
			};
		$('#expressModal').modal(options);
	},
	
	saveExpress : function(){
		console.log("saveExpress");
		var that =this;
		var express={
			"expressId" : $("#expressId").val(),
			"expressCode" : $("#expressCode").val(),
			"expressCompany" : $("#expressCompany").val(),
			"expressType" : $("#expressType").val(),
			"expressDate" : $("#expressDate").val(),
			"receiver" : $("#receiver").val(),
			"receiverCompany" : $("#receiverCompany").val(),
			"receiverAddress" : $("#receiverAddress").val(),
			"receiverTel" : $("#receiverTel").val(),
			"sender" : $("#sender").val(),
			"senderCompany" : $("#senderCompany").val(),
			"senderAddress" : $("#senderAddress").val(),
			"expressState" : $("#expressState").val(),
			"expressComment" : $("#expressComment").val(),
			"createUser" : $("#createUser").val(),
			"createDate" : $("#createDate").val()	
		}
		
		$.post(that.url.doAdd,{"express":JSON.stringify(express)},function(data){
			
			if(data.status){
				swal({
					title : "保存成功!",
					type : "success"
				});
				$('#table_express').bootstrapTable('refresh',{silent: true});
				$('#expressModal').modal('hide');
			}
		})
	},
	
	clearExpress: function(){
		$("#opera").val("")
		$("#expressId").val("");
		$("#expressCode").val("");
		$("#expressCompany").val("");
		$("#expressType").val("");
		$("#expressDate").val(null);
		$("#receiver").val("");
		$("#receiverCompany").val("");
		$("#receiverAddress").val("");
		$("#receiverTel").val("");
		$("#sender").val("");
		$("#senderCompany").val("");
		$("#senderAddress").val("");
		$("#expressState").val("");
		$("#expressComment").val("");
		$("#createUser").val("");
		$("#createDate").val(null);		
	}
}
