package com.chen.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice {

	private int id;
	private Date createTime;// 创建时间
	private Date sendTime;// 发货时间
	private String city_from;// 关联店名
	private String city_to;// 关联店名
	private String sender;// 关联店名
	private String sender_phone;// 关联店名
	private String sender_address;// 关联店名
	private String recipient;// 关联店名
	private String recipient_phone;// 关联店名
	private String recipient_address;// 关联店名
	private String item_name;// 关联店名
	private String item_package;// 关联店名
	private BigDecimal item_quantity;// 关联店名
	private BigDecimal item_weight;// 关联店名
	private BigDecimal item_volume;// 关联店名
	private String item_category;// 关联店名
	private BigDecimal item_charge;// 关联店名
	private BigDecimal item_total;// 关联店名
	private String item_pay_method;// 关联店名
	private BigDecimal collection_payment;// 关联店名
	private String collection_payment_capital; //

	private String bank_card_no;// 关联店名
	private String bank_card_name;// 关联店名
	private String bank_card_deposit;// 关联店名
	private String operator;// 关联店名


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getCity_from() {
		return city_from;
	}

	public void setCity_from(String city_from) {
		this.city_from = city_from;
	}

	public String getCity_to() {
		return city_to;
	}

	public void setCity_to(String city_to) {
		this.city_to = city_to;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSender_phone() {
		return sender_phone;
	}

	public void setSender_phone(String sender_phone) {
		this.sender_phone = sender_phone;
	}

	public String getSender_address() {
		return sender_address;
	}

	public void setSender_address(String sender_address) {
		this.sender_address = sender_address;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipient_phone() {
		return recipient_phone;
	}

	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
	}

	public String getRecipient_address() {
		return recipient_address;
	}

	public void setRecipient_address(String recipient_address) {
		this.recipient_address = recipient_address;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_package() {
		return item_package;
	}

	public void setItem_package(String item_package) {
		this.item_package = item_package;
	}

	public BigDecimal getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(BigDecimal item_quantity) {
		this.item_quantity = item_quantity;
	}

	public BigDecimal getItem_weight() {
		return item_weight;
	}

	public void setItem_weight(BigDecimal item_weight) {
		this.item_weight = item_weight;
	}

	public BigDecimal getItem_volume() {
		return item_volume;
	}

	public void setItem_volume(BigDecimal item_volume) {
		this.item_volume = item_volume;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public BigDecimal getItem_charge() {
		return item_charge;
	}

	public void setItem_charge(BigDecimal item_charge) {
		this.item_charge = item_charge;
	}

	public BigDecimal getItem_total() {
		return item_total;
	}

	public void setItem_total(BigDecimal item_total) {
		this.item_total = item_total;
	}

	public String getItem_pay_method() {
		return item_pay_method;
	}

	public void setItem_pay_method(String item_pay_method) {
		this.item_pay_method = item_pay_method;
	}

	public BigDecimal getCollection_payment() {
		return collection_payment;
	}

	public void setCollection_payment(BigDecimal collection_payment) {
		this.collection_payment = collection_payment;
	}

	public String getCollection_payment_capital() {
		return collection_payment_capital;
	}

	public void setCollection_payment_capital(String collection_payment_capital) {
		this.collection_payment_capital = collection_payment_capital;
	}

	public String getBank_card_no() {
		return bank_card_no;
	}

	public void setBank_card_no(String bank_card_no) {
		this.bank_card_no = bank_card_no;
	}

	public String getBank_card_name() {
		return bank_card_name;
	}

	public void setBank_card_name(String bank_card_name) {
		this.bank_card_name = bank_card_name;
	}

	public String getBank_card_deposit() {
		return bank_card_deposit;
	}

	public void setBank_card_deposit(String bank_card_deposit) {
		this.bank_card_deposit = bank_card_deposit;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
