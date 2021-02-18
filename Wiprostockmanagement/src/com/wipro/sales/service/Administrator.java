package com.wipro.sales.service;
import java.util.ArrayList;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.dao.StockDao;
import com.wipro.sales.util.DBUtil;

public class Administrator {
	final static Connection con=DBUtil.getDBConnection();
	PreparedStatement ps;
	Scanner sc=new Scanner(System.in);
	public String insertStock(Product stockobj)
	{   
		if(stockobj!=null && stockobj.getProductName().length()>=2)
		{
        StockDao obj=new StockDao();
        stockobj.setProductID(obj.GenerateProductID(stockobj.getProductName()));
        obj.insertStock(stockobj);
        return stockobj.getProductID();
					
		}
		else
		{
			return "Data not valid for insertion";
		}
		
	}
	public String deleteStock(String ProductID)
	{    
		 StockDao obj=new StockDao();
		 
		 if(obj.deleteStock(ProductID)==1)
		 {
			 return "deleted";
		 }
		 else
			 return "record cannot be deleted";
		
	}
	public String insertSales(Sales salesobj) throws SQLException
	{
		java.sql.Date date;;
		  java.sql.Date currentDate;
		if(salesobj!=null)
		{
			ps = con.prepareStatement("select PRODUCT_ID from TBL_STOCK where PRODUCT_ID=(?)");
			ps.setString(1, salesobj.getProductID());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				 ps=con.prepareStatement("select QUANTITY_ON_HAND from TBL_STOCK where Product_ID=?");
				 ps.setString(1, salesobj.getProductID());
				 rs=ps.executeQuery();
				 int qty = 0;
				if(rs.next())
					 qty=rs.getInt("QUANTITY_ON_HAND");
				System.out.println(qty);
				if(qty>= salesobj.getQuantitySold()) 
				{
					date= new java.sql.Date(salesobj.getSalesDate().getTime());
				  currentDate=new java.sql.Date(new java.util.Date().getTime());
				  if(date.compareTo(currentDate)<0)                              
				  {
				   SalesDao ob1=new SalesDao();
				   salesobj.setSalesID(ob1.generateSalesID(salesobj.getSalesDate()));
				   
				   if(ob1.insertSales(salesobj)==1)
				   {
					 new StockDao().updateStock(salesobj.getProductID(),salesobj.getQuantitySold());
					 return "Sales";
				   }
				   else
					   return"error";
				  }
				  else
				  {
					  
					  return "Invalid Date";
				}
				}
				else return "not enough stock for sale";
			}
			else
				return "Unkonown product for sale";
		}
		else
		{
			return "object not valid for insertion";
		}
		
		
		
	}
	public ArrayList<SalesReport> getSalesReport()
	{
		return new SalesDao().getSalesReport();
	}
		
	}
	
	

