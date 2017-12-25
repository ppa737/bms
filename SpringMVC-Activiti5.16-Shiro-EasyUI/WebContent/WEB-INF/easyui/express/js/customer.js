$(function() {
	$('#createDate').datepicker({
		currentText: 'Now',
		showAnim: 'slideDown',
		dateFormat: 'yy-mm-dd'
	}); 

});
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
	init: function(){
		this.bindEvent();
	},
	bindEvent : function(){
		var that =this;
		$("#btnAddCust").bind('click', function () {
			
            that.add();
        });
	},
	
	add : function(){
		console.long("btnAddCust");
		$( "#dialog_add_cust" ).dialog({
		      modal: true,
		      buttons: {
		        Ok: function() {
		          $( this ).dialog( "close" );
		        }
		      }
	    });
	}
		
}
