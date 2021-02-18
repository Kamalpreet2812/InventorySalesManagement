package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.sales.bean.Product;
import com.wipro.sales.util.DBUtil;

public class StockDao {
	static Connection con=DBUtil.getDBConnection();
	
	 public void insertStock(Product sales){ 
		 try {
			 PreparedStatement ps=con.prepareStatement("insert into TBL_STOCK values(?,?,?,?,?)");
					ps.setString(1,sales.getProductID());
					ps.setString(2, sales.getProductName());
					ps.setInt(3,sales.getQuantityOnHand());
					ps.setDouble(4,sales.getProductUnitPrice());
					ps.setInt(5,sales.getReorderLevel());
					ps.executeUpdate();
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	 }
	 public String GenerateProductID(String productName)
	 { String productid="";
		 try {
		 int pdnext = 0;
		 
		 PreparedStatement ps=con.prepareStatement("select SEQ_PRODUCT_ID.nextval from dual");
		 ResultSet rs=ps.executeQuery();
		 if(rs.next()) {
		 pdnext=rs.getInt(1);
		 }
		 productid=productName.substring(0,2)+pdnext;	
	 }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
		 return  productid;
	 
	 }
	 public void updateStock(String productId,int soldQty)
	 { try{
		 PreparedStatement ps =con.prepareStatement("select QUANTITY_ON_HAND from TBL_STOCK where PRODUCT_id=?");
		 ps.setString(1, productId);
		 ResultSet rs=ps.executeQuery();
		 int v=0;
		 if(rs.next());
		  v=rs.getInt(1)-soldQty;
		 if(v>=0)
		 {
			ps=con.prepareStatement("update TBL_STOCK set QUANTITY_ON_HAND=? where PRODUCT_ID=?");
			ps.setInt(1, v);
			ps.setString(2,productId);
			ps.executeUpdate();
			
		 }
		 else
		 {
			System.out.print("insufficent");
		 }
	 }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 
	 }
	public Product getStock(String productID)
	 { Product obj=new Product();
		try {
			PreparedStatement ps=con.prepareStatement("select * from TBL_STOCK where PRODUCT_id=productId");
			ResultSet rs=ps.executeQuery();
			
			obj.setProductID(rs.getString("Product_ID"));
			 obj.setProductName(rs.getString("Product_Name"));
			 obj.setQuantityOnHand(rs.getInt("Quantity_On_Hand"));
			 obj.setProductUnitPrice(rs.getDouble("Product_Unit_Price"));
			 obj.setReorderLevel(rs.getInt("Recorder_Level"));
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
		
		 
	 }
	public int deleteStock(String productID)
	{
		int t=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from TBL_STOCK where PRODUCT_ID=?");
			ps.setString(1,productID);
			t=ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return t;
	}
}
