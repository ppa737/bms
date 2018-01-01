package com.zml.oa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *  客户信息实体
 * @author ccs
 *
 */
@Entity
@Table(name = "T_CUSTOMER")
// 在Hibernate中可以利用@DynamicInsert和@DynamicUpdate生成动态SQL语句，
//即在插入和修改数据的时候,语句中只包括要插入或者修改的字段。
@DynamicUpdate(true)
@DynamicInsert(true)
public class Customer extends BaseVO implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2616390154785020238L;
	private Integer custId;
	private String custCode;
	private String custName;
	private String branch;
	private String owner;
	private String address;
	private String contacts1;
	private String position1;
	private String tel1;
	private String mobile1;
	private String email1;
	private String qq1;
	private String contacts2;
	private String position2;
	private String tel2;
	private String mobile2;
	private String email2;
	private String qq2;
	private String contacts3;
	private String position3;
	private String tel3;
	private String mobile3;
	private String email3;
	private String qq3;
	private String remarks;
	private String custState;
	private String createUser;
	private Date createDate;
	private String modifyUser;
	private Date modifyDate;

	
	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(String custCode, String custName, String address,
			String contacts1, String position1, String tel1, String mobile1,
			String email1, String qq1, String contacts2, String position2,
			String tel2, String mobile2, String email2, String qq2) {
		this.custCode = custCode;
		this.custName = custName;
		this.address = address;
		this.contacts1 = contacts1;
		this.position1 = position1;
		this.tel1 = tel1;
		this.mobile1 = mobile1;
		this.email1 = email1;
		this.qq1 = qq1;
		this.contacts2 = contacts2;
		this.position2 = position2;
		this.tel2 = tel2;
		this.mobile2 = mobile2;
		this.email2 = email2;
		this.qq2 = qq2;
	}

	/** full constructor */
	public Customer(String custCode, String custName, String branch,
			String owner, String address, String contacts1, String position1,
			String tel1, String mobile1, String email1,
			String qq1, String contacts2, String position2, String tel2,
			String mobile2, String email2, String qq2, String contacts3,
			String position3, String tel3, String mobile3, String email3,
			String qq3, String comment, String custState ,String createUser, 
			Date createDate, String modifyUser, Date modifyDate) {
		this.custCode = custCode;
		this.custName = custName;
		this.branch = branch;
		this.owner = owner;
		this.address = address;
		this.contacts1 = contacts1;
		this.position1 = position1;
		
		this.tel1 = tel1;
		this.mobile1 = mobile1;
		this.email1 = email1;
		this.qq1 = qq1;
		this.contacts2 = contacts2;
		this.position2 = position2;
		this.tel2 = tel2;
		this.mobile2 = mobile2;
		this.email2 = email2;
		this.qq2 = qq2;
		this.contacts3 = contacts3;
		this.position3 = position3;
		this.tel3 = tel3;
		this.mobile3 = mobile3;
		this.email3 = email3;
		this.qq3 = qq3;
		this.custState = custState;
		this.createUser =createUser;
		this.createDate = createDate;
		this.modifyUser = modifyUser;
		this.modifyDate = modifyDate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id", unique = true, nullable = false)
	public Integer getCustId() {
		return this.custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@Column(name = "cust_code", nullable = false, length = 100)
	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	@Column(name = "cust_name", nullable = false, length = 1000)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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

	@Column(name = "address", nullable = false, length = 2000)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "contacts1", nullable = false, length = 100)
	public String getContacts1() {
		return this.contacts1;
	}

	public void setContacts1(String contacts1) {
		this.contacts1 = contacts1;
	}

	@Column(name = "position1", nullable = false, length = 100)
	public String getPosition1() {
		return this.position1;
	}

	public void setPosition1(String position1) {
		this.position1 = position1;
	}

	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "tel1", nullable = false, length = 100)
	public String getTel1() {
		return this.tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	@Column(name = "mobile1", nullable = false, length = 100)
	public String getMobile1() {
		return this.mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	@Column(name = "email1", nullable = false, length = 100)
	public String getEmail1() {
		return this.email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	@Column(name = "qq1", nullable = false, length = 100)
	public String getQq1() {
		return this.qq1;
	}

	public void setQq1(String qq1) {
		this.qq1 = qq1;
	}

	@Column(name = "contacts2", nullable = false, length = 100)
	public String getContacts2() {
		return this.contacts2;
	}

	public void setContacts2(String contacts2) {
		this.contacts2 = contacts2;
	}

	@Column(name = "position2", nullable = false, length = 100)
	public String getPosition2() {
		return this.position2;
	}

	public void setPosition2(String position2) {
		this.position2 = position2;
	}

	@Column(name = "tel2", nullable = false, length = 100)
	public String getTel2() {
		return this.tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	@Column(name = "mobile2", nullable = false, length = 100)
	public String getMobile2() {
		return this.mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	@Column(name = "email2", nullable = false, length = 100)
	public String getEmail2() {
		return this.email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	@Column(name = "qq2", nullable = false, length = 100)
	public String getQq2() {
		return this.qq2;
	}

	public void setQq2(String qq2) {
		this.qq2 = qq2;
	}

	@Column(name = "contacts3", length = 100)
	public String getContacts3() {
		return this.contacts3;
	}

	public void setContacts3(String contacts3) {
		this.contacts3 = contacts3;
	}

	@Column(name = "position3", length = 100)
	public String getPosition3() {
		return this.position3;
	}

	public void setPosition3(String position3) {
		this.position3 = position3;
	}

	@Column(name = "tel3", length = 100)
	public String getTel3() {
		return this.tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	@Column(name = "mobile3", length = 100)
	public String getMobile3() {
		return this.mobile3;
	}

	public void setMobile3(String mobile3) {
		this.mobile3 = mobile3;
	}

	@Column(name = "email3", length = 100)
	public String getEmail3() {
		return this.email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	@Column(name = "qq3", length = 100)
	public String getQq3() {
		return this.qq3;
	}

	public void setQq3(String qq3) {
		this.qq3 = qq3;
	}

	@Column(name = "cust_state", length = 10)
	public String getCustState() {
		return this.custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}
	@Column(name = "remarks", length = 65535)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "create_user", length = 100)
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "modify_user", length = 100)
	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	@Column(name = "modify_date")
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	
}