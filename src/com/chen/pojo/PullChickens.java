package com.chen.pojo;

import java.math.BigDecimal;

public class PullChickens {
	private BigDecimal tare;
	private BigDecimal suttle;
	private BigDecimal price;
	private BigDecimal sumWeight;
	private BigDecimal sumPrice;
	private String chickType;

	public BigDecimal getTare() {
		return tare;
	}

	public void setTare(BigDecimal tare) {
		this.tare = tare;
	}

	public BigDecimal getSuttle() {
		return suttle;
	}

	public void setSuttle(BigDecimal suttle) {
		this.suttle = suttle;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSumWeight() {
		return sumWeight;
	}

	public void setSumWeight(BigDecimal sumWeight) {
		this.sumWeight = sumWeight;
	}

	public BigDecimal getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(BigDecimal sumPrice) {
		this.sumPrice = sumPrice;
	}

	public String getChickType() {
		return chickType;
	}

	public void setChickType(String chickType) {
		this.chickType = chickType;
	}
}
