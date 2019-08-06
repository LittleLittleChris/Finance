package com.chen.pojo;

public class Warehouse {

	private int id;
	private String goodsType;// 商品种类
	private java.sql.Date date;// 時間
	private java.math.BigDecimal tare;// 皮重
	private java.math.BigDecimal suttle;// 净重
	private java.math.BigDecimal price;// 价格
	// 1代表进货 -1代表出货
	private int handleType;// 操作
	private String username;// 关联店名
	private String region;// 地区
	private java.math.BigDecimal sumPrice;//

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public java.math.BigDecimal getTare() {
		return tare;
	}

	public void setTare(java.math.BigDecimal tare) {
		this.tare = tare;
	}

	public java.math.BigDecimal getSuttle() {
		return suttle;
	}

	public void setSuttle(java.math.BigDecimal suttle) {
		this.suttle = suttle;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	public int getHandleType() {
		return handleType;
	}

	public void setHandleType(int handleType) {
		this.handleType = handleType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public java.math.BigDecimal getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(java.math.BigDecimal sumPrice) {
		this.sumPrice = sumPrice;
	}

}
