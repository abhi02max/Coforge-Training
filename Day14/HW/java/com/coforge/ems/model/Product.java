package com.coforge.ems.model;

public class Product {
	private Integer productId;
	private String productName;
	private Double productPrice;
	private Integer productQuantity;

	public Product() {
	}

	public Product(Integer productId, String productName, Double productPrice, Integer productQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + 
			   ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + "]";
	}
}
