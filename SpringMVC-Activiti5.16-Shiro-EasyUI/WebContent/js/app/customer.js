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
		bindTable:'../expressAction/bindTable',
		doAdd: "../expressAction/doAdd",
	},
	init: function(){
		this.bindEvent();
		this.bindTable();
	},
	bindEvent : function(){
		var that =this;
		$("#btnAddCust").bind('click', function () {
            that.add();
        });
	},
	
	bindTable :function(){
		var that =this;
		$('#table_customer').bootstrapTable({
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
                    field: 'custCode',
                    title: '客户编码'
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
                     
                        return _html;
                    }
                }]
        });
		
	},
	
	add : function(){
		console.log("btnAddCust");
		
		var options = {
				backdrop : false,
				show : true,
			};
		$('#custModal').modal(options);
	}
		
}
