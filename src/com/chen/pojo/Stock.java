package com.chen.pojo;

import java.math.BigDecimal;

public class Stock {
	private BigDecimal tare;
	private BigDecimal suttle;
	private BigDecimal price;
	private String chickType;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public String getChickType() {
		return chickType;
	}

	public void setChickType(String chickType) {
		this.chickType = chickType;
	}

}
