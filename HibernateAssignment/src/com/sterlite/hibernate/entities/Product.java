/*
 * @ author trusha.patel@stltech.in
 * @version 1.0
 * @date 18-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved
 * @description: Represents Database entity (Table)
 *          POJO Class/Persistence class in hibernate
 * */
//dependency is hibernate core
package com.sterlite.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//JPA annotations/hibernate mapping
@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@Column(name = "ID")
	private int productId;
	
	@Column(name = "NAME")
	private String productName;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "PRICE")
	private int price;

	
	//setter and getter methods 
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brand=" + brand + ", price="
				+ price + "]";
	}
	
	
	

	
}
