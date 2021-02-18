package com.wipro.sales.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

import com.wipro.sales.bean.Product;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.dao.StockDao;
import com.wipro.sales.service.Administrator;

public class DBUtil {
	public static Connection getDBConnection()
	{
	Connection con = null;
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KAMAL","kamal");
	}
	catch(ClassNotFoundException e)
	{
	System.out.println("Driver not loaded");
	}
	catch(SQLException e)
	{
	System.out.println("Connecrtion not established");
	}
    
	return con;
	}
	public static void main(String[] args) 
	{		
		Administrator ob =new Administrator();
		Product k = new Product();
          System.out.println(ob.insertStock(k));
	}
}
