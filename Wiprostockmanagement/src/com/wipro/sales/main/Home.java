package com.wipro.sales.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.wipro.sales.service.Administrator;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.bean.Product;

public class Home extends JFrame implements ActionListener {

	private JPanel contentPane=new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4,textField1,textField2,textField3,textField4;
	private JPanel contentPane1=new JPanel();
	private JPanel contentPane2=new JPanel();
	private JPanel contentPane3=new JPanel();
	JButton btnNewButton ;
	JButton btnNewButton_2 ;
	JButton btnNewButton_3 ;
	JButton btnNewButton_1,btnNewButton_4,btnNewButton_1_1,btnNewButton_1_1_1;
	Product pr;
	Sales sa;
	SalesReport obj;
	Administrator ad=new Administrator();
	JTextArea disp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 452);
		
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(0, 0, 710, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 btnNewButton = new JButton("INSERT STOCK");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(45, 10, 117, 34);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);
		
		 btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBounds(200, 10, 117, 34);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		
		btnNewButton_1_1 = new JButton("INSERT SALE");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1_1.setBounds(361, 10, 117, 34);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(this);
		
		btnNewButton_1_1_1 = new JButton("VIEW SALE");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1_1_1.setBounds(505, 10, 117, 34);
		panel.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(this);
		
		contentPane1.setBackground(new Color(255, 255, 255));
		contentPane1.setBounds(0,10, 671, 400);
		contentPane1.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("PRODUCT NAME");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblNewLabel.setBounds(200, 91, 89, 13);
			contentPane1.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(200, 114, 261, 19);
			contentPane1.add(textField);
			textField.setColumns(10);
			
			JLabel lblQuantity = new JLabel("QUANTITY");
			lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblQuantity.setBounds(200, 143, 68, 13);
			contentPane1.add(lblQuantity);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(200, 166, 261, 19);
			contentPane1.add(textField_1);
			
			JLabel lblProductUnitPrice = new JLabel("PRODUCT UNIT PRICE");
			lblProductUnitPrice.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblProductUnitPrice.setBounds(200, 195, 119, 13);
			contentPane1.add(lblProductUnitPrice);
			
			
			textField_2 = new JTextField();
			textField_2.setBounds(200, 218, 261, 19);
			contentPane1.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblRecorderLevel = new JLabel("RECORDER LEVEL");
			lblRecorderLevel.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblRecorderLevel.setBounds(200, 247, 100, 13);
			contentPane1.add(lblRecorderLevel);
			
			textField_3 = new JTextField();
			textField_3.setBounds(200, 270, 261, 19);
			contentPane1.add(textField_3);
			textField_3.setColumns(10);
			
			 btnNewButton_2 = new JButton("SUBMIT");
			btnNewButton_2.setForeground(new Color(240, 255, 255));
			btnNewButton_2.setBackground(new Color(138, 43, 226));
			btnNewButton_2.setBounds(255, 310, 155, 21);
			btnNewButton_2.addActionListener(this);
			contentPane1.add(btnNewButton_2);
			
			contentPane2.setBackground(new Color(255, 255, 255));
			contentPane2.setBounds(0,10, 671, 400);
			contentPane2.setLayout(null);
			
			JLabel lblProductUnitPrice2 = new JLabel("PRODUCT ID");
			lblProductUnitPrice2.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblProductUnitPrice2.setBounds(200, 195, 119, 13);
			contentPane2.add(lblProductUnitPrice2);
			
			textField_4 = new JTextField();
			textField_4.setBounds(200, 218, 261, 19);
			contentPane2.add(textField_4);
			textField_4.setColumns(10);
			
			btnNewButton_3 = new JButton("Delete");
			btnNewButton_3.setForeground(new Color(240, 255, 255));
			btnNewButton_3.setBackground(new Color(138, 43, 226));
			btnNewButton_3.setBounds(255, 310, 155, 21);
			btnNewButton_3.addActionListener(this);
			contentPane2.add(btnNewButton_3);
			
			contentPane3.setBackground(new Color(255, 255, 255));
			contentPane3.setBounds(0,10, 671, 400);
			contentPane3.setLayout(null);
			
				JLabel lblNewLabel1 = new JLabel("PRODUCT Id");
				lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel1.setBounds(200, 91, 89, 13);
				contentPane3.add(lblNewLabel1);
				
				textField1 = new JTextField();
				textField1.setBounds(200, 114, 261, 19);
				contentPane3.add(textField1);
				textField1.setColumns(10);
				
				JLabel lblNewLabel2 = new JLabel("Date");
				lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel2.setBounds(200, 143, 68, 13);
				contentPane3.add(lblNewLabel2);
				
				textField2 = new JTextField();
				textField2.setColumns(10);
				textField2.setBounds(200, 166, 261, 19);
				contentPane3.add(textField2);
				
				JLabel lblNewLabel3 = new JLabel("Quantity Sold");
				lblNewLabel3.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel3.setBounds(200, 195, 119, 13);
				contentPane3.add(lblNewLabel3);
				
				
				textField3 = new JTextField();
				textField3.setBounds(200, 218, 261, 19);
				contentPane3.add(textField3);
				textField3.setColumns(10);
				
				JLabel lblNewLabel4 = new JLabel("Sales price per unit");
				lblNewLabel4.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel4.setBounds(200, 247, 100, 13);
				contentPane3.add(lblNewLabel4);
				
				textField4= new JTextField();
				textField4.setBounds(200, 270, 261, 19);
				contentPane3.add(textField4);
				textField4.setColumns(10);
				
				 btnNewButton_4 = new JButton("SUBMIT");
				btnNewButton_4.setForeground(new Color(240, 255, 255));
				btnNewButton_4.setBackground(new Color(138, 43, 226));
				btnNewButton_4.setBounds(255, 310, 155, 21);
				btnNewButton_4.addActionListener(this);
				contentPane3.add(btnNewButton_4);
				
				disp=new JTextArea();
				disp.setBounds(0,70, 700, 400);
				disp.setFont(new Font("Arial", Font.PLAIN, 15));
				disp.setVisible(false);
				//disp.setEditable(false);
				
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setContentPane(contentPane);
		contentPane.setLayout(null);
		if(e.getSource()==btnNewButton)
		{  
			contentPane1.setVisible(true);
			contentPane2.setVisible(false);
			contentPane3.setVisible(false);
			disp.setVisible(false);
			contentPane.add(contentPane1);
			contentPane1.setLayout(null);
		}
		
		if(e.getSource()==btnNewButton_2)
		{
		    if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty())
		    {
		    	JOptionPane.showMessageDialog(contentPane,"Please enter all the field");
		    }
		    else
		    {
		    	pr=new Product();
		    	pr.setProductName(textField.getText());
		    	pr.setQuantityOnHand(Integer.parseInt(textField_1.getText()));
		    	pr.setProductUnitPrice(Double.parseDouble(textField_2.getText()));
		    	pr.setReorderLevel(Integer.parseInt(textField_3.getText()));
			try 
			{
				JOptionPane.showMessageDialog(contentPane,"Product id -: "+ad.insertStock(pr));
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
		    }
		}
		
		if(e.getSource()==btnNewButton_1)
		{
			contentPane1.setVisible(false);
			contentPane3.setVisible(false);
			contentPane2.setVisible(true);
			disp.setVisible(false);
				contentPane.add(contentPane2);
				contentPane2.setLayout(null);
		}
		
		if(e.getSource()==btnNewButton_3)
		{
			if(textField_4.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(contentPane,"Please enter Product id");
			}
			else
			{
				JOptionPane.showMessageDialog(contentPane,ad.deleteStock(textField_4.getText()));
			}
			textField_4.setText("");
		}
		
		if(e.getSource()==btnNewButton_1_1)
		{
			contentPane1.setVisible(false);
			contentPane2.setVisible(false);
			contentPane3.setVisible(true);
			disp.setVisible(false);
				contentPane.add(contentPane3);
				contentPane3.setLayout(null);
		}
		
		if(e.getSource()==btnNewButton_4)
		{
		    if(textField1.getText().isEmpty()||textField2.getText().isEmpty()||textField3.getText().isEmpty()||textField4.getText().isEmpty())
		    {
		    	JOptionPane.showMessageDialog(contentPane,"Please enter all the field");
		    }
		    else
		    {
		    	sa=new Sales();
		    	sa.setProductID(textField1.getText());
		    	try {
					sa.setSalesDate(new SimpleDateFormat("dd/MM/yyyy").parse(textField2.getText()));
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		    	sa.setQuantitySold(Integer.parseInt(textField3.getText()));
		    	sa.setSalesPricrPerUnit(Double.parseDouble(textField4.getText()));
			try 
			{
				JOptionPane.showMessageDialog(contentPane,ad.insertSales(sa));
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
		    }
		}
		
		if(e.getSource()==btnNewButton_1_1_1)
		{
			contentPane1.setVisible(false);
			contentPane2.setVisible(false);
			contentPane3.setVisible(false);
			contentPane.setLayout(null);
			ArrayList<SalesReport> list=ad.getSalesReport();
			//Collections.sort(list);
			String res="Sales_Id\tSales_Date\tProduct_Id\tProduct_Name\t    Quantity_Sold      Product_Unit_Price      Sales_Price_Per_Unit      Profit_Amount\n";
			for(SalesReport item:list)
				res+=item.getSalesID()+"\t"+item.getSalesDate()+"\t"+item.getProductID()+"\t"+item.getProductName()+"\t        "+item.getQuantitySold()+"\t         "+item.getProductUnitPrice()+"\t\t"+item.getSalesPriceperUnit()+"\t          "+item.getProfitAmount()+"\n";
			disp.setText(res);
			disp.setVisible(true);
			disp.setEditable(false);
			contentPane.add(disp);
		}
	}
}