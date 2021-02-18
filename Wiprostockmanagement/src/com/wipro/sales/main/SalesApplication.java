package com.wipro.sales.main;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;



import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.service.Administrator;

public class SalesApplication {

	public static void main(String[] args) throws ParseException, SQLException {
		Scanner sc=new Scanner(System.in);
		Administrator ad=new Administrator();
		Product pr;
		Sales sl;
		int i;
		do
		{
			System.out.println("1. insert stock");
			System.out.println("2. Delete stock");
			System.out.println("3. insert sales");
			System.out.println("4. view Salesreport");
			System.out.println("5. Exit");
			 i=sc.nextInt();
			 sc.nextLine();
			switch(i)
			{
			case 1:
			{
			 	pr=new Product();
			  System.out.println(ad.insertStock(pr));
			 	break;
			 	
			}
			case 2:
			{ 
				
				String s=sc.nextLine();
				System.out.println(ad.deleteStock(s));
				break;
			}
			case 3:
			{
				sl=new Sales();
				System.out.println("Enter product id");
				sl.setProductID(sc.nextLine());
				System.out.println("Enter SalesDate dd/mm/yyyy");
				sl.setSalesDate(new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
				System.out.println("Enter Quantity Sold");
				sl.setQuantitySold(sc.nextInt());
				System.out.println("Enter Sales Price PerUnit");
				sl.setSalesPricrPerUnit(sc.nextDouble());
				System.out.println(ad.insertSales(sl));
				break;
			}
			case 4:
			{
			  ArrayList<SalesReport> ar=ad.getSalesReport();
			  for(SalesReport t:ar)
			  {
				  System.out.println(t.getSalesID()+"\t"+t.getProductID()+"\t"+t.getSalesDate()+"\t"+t.getProductName()+"\t"+t.getQuantitySold()+"\t"+t.getProductUnitPrice()+"\t"+
						  t.getSalesPriceperUnit()+"\t"+t.getProfitAmount());
				  
			  }
			  break;
			}
			}
			}while(i!=5);
		 System.out.println("have a good day");
		

	}

}
