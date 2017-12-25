package com.zml.oa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 薪资对象
 * @author zml
 *
 */
@Entity
@Table(name = "T_EXPRESS_INFO")
public class ExpressInfo extends BaseVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 179260132812559678L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EXPRESS_ID", unique = true)
	private Integer expressId;

	@Column(name = "EXPRESS_CODE")
	private String expressCode;
	
	@Column(name = "EXPRESS_COMPANY")
	private String expressCompany;
	
	@Column(name = "EXPRESS_TYPE")
	private String expressType;
	
	@Column(name = "EXPRESS_DATE")
	private Date expressDate;
	
	@Column(name = "RECEIVER")
	private String receiver;
	
	@Column(name = "RECEIVER_COMPANY")
	private String receiverCompany;
	
	@Column(name = "RECEIVER_ADDRESS")
	private String receiverAddress;
	
	@Column(name = "RECEIVER_TEL")
	private String receiverTel;
	
	@Column(name = "SENDER")
	private String sender;
	
	@Column(name = "SENDER_COMPANY")
	private String senderCompany;
	
	@Column(name = "SENDER_ADDRESS")
	private String senderAddress;
	
	@Column(name = "SENDER_TEL")
	private String senderTel;
	
	@Column(name = "EXPRESS_STATE")
	private String expressState;

	@Column(name = "EXPRESS_COMMENT")
	private String expressComment;
	
	@Column(name = "CREATE_USER")
	private String createUser;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;

	public Integer getExpressId() {
		return expressId;
	}

	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getExpressCompany() {
		return expressCompany;
	}

	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}

	public Date getExpressDate() {
		return expressDate;
	}

	public void setExpressDate(Date expressDate) {
		this.expressDate = expressDate;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverCompany() {
		return receiverCompany;
	}

	public void setReceiverCompany(String receiverCompany) {
		this.receiverCompany = receiverCompany;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverTel() {
		return receiverTel;
	}

	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderCompany() {
		return senderCompany;
	}

	public void setSenderCompany(String senderCompany) {
		this.senderCompany = senderCompany;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderTel() {
		return senderTel;
	}

	public void setSenderTel(String senderTel) {
		this.senderTel = senderTel;
	}

	public String getExpressState() {
		return expressState;
	}

	public void setExpressState(String expressState) {
		this.expressState = expressState;
	}

	public String getExpressComment() {
		return expressComment;
	}

	public void setExpressComment(String expressComment) {
		this.expressComment = expressComment;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
