package com.wipro.sales.bean;

public class Sales {
	private String salesID;
	private java.util.Date salesDate;
	private String ProductID;
	private int quantitySold;
	private double salesPricrPerUnit;
	public String getSalesID() {
		return salesID;
	}
	public void setSalesID(String salesID) {
		this.salesID = salesID;
	}
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getSalesPricrPerUnit() {
		return salesPricrPerUnit;
	}
	public void setSalesPricrPerUnit(double salesPricrPerUnit) {
		this.salesPricrPerUnit = salesPricrPerUnit;
	}
	public java.util.Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(java.util.Date salesDate) {
		this.salesDate = salesDate;
	}

}
