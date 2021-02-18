package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.util.DBUtil;

public class SalesDao {
	static Connection con=DBUtil.getDBConnection();
 public int insertSales(Sales sales) throws SQLException
 { PreparedStatement ps = null;
	 try {
	  ps=con.prepareStatement("insert into TBL_sales values(?,?,?,?,?)");
	 ps.setString(1,sales.getSalesID());
	 java.sql.Date sqldate=new java.sql.Date(sales.getSalesDate().getTime());
	 ps.setDate(2, sqldate);
	 ps.setString(3,sales.getProductID());
	 ps.setInt(4,sales.getQuantitySold());
	 ps.setDouble(5,sales.getSalesPricrPerUnit());
	 
	 
	
	 
 }catch(Exception e) {
	 e.printStackTrace();
 }
	 return ps.executeUpdate();

	
	
 }
  public String  generateSalesID(java.util.Date salesDate)
 {
	
	  try
	  {
	  java.sql.Date dateValue=new java.sql.Date(salesDate.getTime());
	  int nextID_from_seq=0;
	  LocalDate localDate = dateValue.toLocalDate();
	  
	  //extract last two characters of year
	  String y=String.valueOf(localDate.getYear());
	  String s=y.substring(2);                                          
	   
	     PreparedStatement ps = con.prepareStatement("select SEQ_SALES_ID.nextval from dual");
	  ResultSet rs=ps.executeQuery();
	  if(rs.next())
	   nextID_from_seq=rs.getInt(1);
	  
	  //concatenate seq id and last 2 digits of year
	  String salesId=nextID_from_seq+s;
	  return salesId;
	  }
	  catch(Exception e)
	  {
	   System.out.print(e);
	  }
	        return null;
	 
	
	 
 }
  public ArrayList<SalesReport> getSalesReport()
  {
	  ArrayList<SalesReport> arrsale=new ArrayList<SalesReport>();
	  try {
	  PreparedStatement ps =con.prepareStatement("select * from V_SALES_REPORT");
	  ResultSet rs=ps.executeQuery();
	  while(rs.next())
	  {
		  SalesReport ob = new SalesReport();
	  ob.setSalesID(rs.getString("SALES_ID"));
	  ob.setSalesDate(rs.getDate("SALES_DATE"));
	  ob.setProductID(rs.getString("PRODUCT_ID"));
	  ob.setProductName(rs.getString("PRODUCT_NAME"));
	  ob.setQuantitySold(rs.getInt("QUANTITY_SOLD"));
	  ob.setProductUnitPrice(rs.getDouble("PRODUCT_UNIT_PRICE"));
	  ob.setSalesPriceperUnit(rs.getDouble("SALES_PRICE_PER_UNIT"));
	  ob.setProfitAmount(rs.getDouble("PROFIT_AMOUNT"));
	  arrsale.add(ob);
	  }
  
	  }catch(Exception e)
	  {
		  System.out.println(e);
	  }
	return arrsale;
	  
  }
}
