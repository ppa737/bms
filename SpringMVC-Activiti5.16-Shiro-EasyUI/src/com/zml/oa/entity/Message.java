package com.zml.oa.entity;

public class Message {
	private String title = "提示";
	private String message;
	private Boolean status = true;
	
	private Object data;
	public Message(){
		
	}
	
	public Message(Boolean status, String message){
		this.status = status;
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
