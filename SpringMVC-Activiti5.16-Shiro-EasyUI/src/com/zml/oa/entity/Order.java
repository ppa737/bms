package com.zml.oa.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_order", catalog = "mysql")
public class Order implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6016572012002173428L;
	private Integer orderId;
	private String orderCode;
	private String orderName;
	private String orderType;
	private String branch;
	private String owner;
	private Double amount;
	private Timestamp startDate;
	private Timestamp endDate;
	private String comment;
	private String orderState;
	private String procInstId;
	private String certificationType;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(String orderCode, String orderName, String orderType) {
		this.orderCode = orderCode;
		this.orderName = orderName;
		this.orderType = orderType;
	}

	/** full constructor */
	public Order(String orderCode, String orderName, String orderType,
			String branch, String owner, Double amount, Timestamp startDate,
			Timestamp endDate, String comment, String orderState,
			String procInstId, String certificationType) {
		this.orderCode = orderCode;
		this.orderName = orderName;
		this.orderType = orderType;
		this.branch = branch;
		this.owner = owner;
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
		this.orderState = orderState;
		this.procInstId = procInstId;
		this.certificationType = certificationType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "order_code", nullable = false, length = 100)
	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	@Column(name = "order_name", nullable = false, length = 1000)
	public String getOrderName() {
		return this.orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Column(name = "order_type", nullable = false, length = 100)
	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	@Column(name = "branch", length = 100)
	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Column(name = "owner", length = 100)
	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Column(name = "amount", precision = 10)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "start_date", length = 19)
	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date", length = 19)
	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	@Column(name = "comment", length = 65535)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "order_state", length = 10)
	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	@Column(name = "PROC_INST_ID")
	public String getProcInstId() {
		return this.procInstId;
	}

	public void setProcInstId(String procInstId) {
		this.procInstId = procInstId;
	}
	@Column(name = "certification_type")
	public String getCertificationType() {
		return certificationType;
	}

	public void setCertificationType(String certificationType) {
		this.certificationType = certificationType;
	}

}