package com.buttershine.springmvc.model;

import java.util.Date;

public class Product {

    private String id;
    private String index;
    private String productId;
    private String name;
    private String price;
    private String picture;
    private String insertUser;
    private String desc;
    private String insertDate;
    private String updateDate;

    public Product() {}
    
    public Product(String id, String index, String productId,
          String name, String price, String picture,
          String insertUser, String desc, String insertDate,
          String updateDate){
    	this.id = id;
    	this.index = index;
    	this.productId = productId;
    	this.name = name;
    	this.price = price;
    	this.picture = picture;
    	this.insertUser = insertUser;
    	this.desc = desc;
    	this.insertDate = insertDate;
    	this.updateDate = updateDate;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
    
    
}

