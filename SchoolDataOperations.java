package com.edu.school;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



	public class SchoolDataOperations {
	static Connection scon=null;
	static ResultSet rs=null;
	static Statement st=null;	
	
	static Scanner sc=new Scanner(System.in);
	static String sname;
	static float fees;
	static String language;
	static String labs;
	static int sid;
	static String Teacher;
	static String Records;
	static int lid;
	static String lusername;
	static String lpassword;
	static String stuname;
	static String stuclass;
	static String stuFathername;
	static String stuMothername;
	static int stuphno;
	static int stufees;
	
	
	public static void Login() {
		try 
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();		
			String log="select * from loginvalue where lid="+lid;
			rs=st.executeQuery(log);
			System.out.println("Enter Id");
			lid=sc.nextInt();
			if(!rs.next()) 
			{
				System.out.println("Enter UserName");
				lusername=sc.next();
				System.out.println("Enter Password");
				lpassword=sc.next();
				String log1="insert into loginvalue values("+lid+",'"+lusername+"',"+lpassword+")";
				int  i1 =st.executeUpdate(log1);
				if(i1>0) 
				{
					System.out.println("Login Information Is right!!!!");
				}
			}
			else 
			{
				System.out.println("Login Information Is Wrong");
			}
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}  	
	}
		
	public static void StudentInfo() {
		try 
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("My connection"+scon);			
			String sql="select * from studentdata where stuname="+stuname;
			rs=st.executeQuery(sql);
			if(!rs.next()) 
			{
				System.out.println("Enter Name");
				stuname=sc.next();
				System.out.println("Enter Class");
				stuclass=sc.next();
				System.out.println("Enter Father Name");
				stuFathername=sc.next();
				System.out.println("Enter Mother Name");
				stuMothername=sc.next();
				System.out.println("Enter Student phno");
				stuphno=sc.nextInt();
				System.out.println("Enter Fees");
				stufees=sc.nextInt();
				
				String student="insert into studentdata values('"+stuname+"','"+stuclass+"','"+stuFathername+"','"+stuMothername+"','"+stuphno+"','"+stufees+"')";
				int  i =st.executeUpdate(student);
				if(i>0) 
				{
					System.out.println("Student information is registered");
				}
			}
			else 
			{
				System.out.println("Id already exists");
			}
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
		}  	
	}
		
	
	
         public static void displaySchoolInfo() {
		//get the Connection
		try
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			
			String sql="select * from schoolinfo";
			rs=st.executeQuery(sql);
			System.out.println("sid\tName\tfees\tLanguage\tlabs");
			
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+rs.getString(4)+rs.getString(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

   public static void insertSchoolInfo() {
		//get the connection
		try {
			
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			
			String sql="select * from schoolinfo where sid="+sid;
			
			rs=st.executeQuery(sql);
			
			if(!rs.next()) {
			
			System.out.println("enter id to insert record");
			int sid = sc.nextInt();
			System.out.println("enter name to insert record");
			String sname=sc.next();
			System.out.println("enter fees to insert record");
			float fees=sc.nextFloat();
			System.out.println("enter language to insert record");
			String language=sc.next();
			System.out.println("enter labs to insert record");
			String labs=sc.next();
			
			
				   
				   String ins="insert into schoolinfo values("+sid+",'"+sname+"','"+fees+"','"+language+"','"+labs+"')";
				   
				   
				  int i= st.executeUpdate(ins);
				   if(i>0) {
					   System.out.println("Record is inserted successfully");
				   }
				   
				 }else {
					 System.out.println("Id already exists choose different id ");
				 }
			 
	
			
			
			}catch (Exception e) {
				e.printStackTrace();
				
			}
			
	      
		}  
	
	      public static void deleteSchoolInfo() {
		System.out.println("Enter school id to delete record");
		int sid=sc.nextInt();
		//check id exists
		//if exists go for delete else display id not exists
		
		scon=DbConnect.getConnection();
		try {
			st=scon.createStatement();
			
			String sql = "select * from schoolinfo where sid="+sid;
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				String del = "delete from schoolinfo where sid="+sid;
				int i=st.executeUpdate(del);
				if(i>0) {
					System.out.println("The schoolinfo with sid "+sid+" is deleted");
				}
			}else {
				System.out.println(sid+ " not exists in database");
			}
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
		
	public static void selectSchoolInfo() {
		
			System.out.println("Which field you want to select");
			System.out.println("1.Show School Name");
			System.out.println("2.Show Student id");
			System.out.println("3.Show School labs");	
			scon=DbConnect.getConnection();
			int choice=sc.nextInt();
			switch(choice) 
			{
			case 1:System.out.println("SCHOOL NAME RECORD");
			try
			{
				scon=DbConnect.getConnection();
				st=scon.createStatement();			
				String sql="select * from schoolinfo";
				rs=st.executeQuery(sql);	
				System.out.println("sid\tName\tfees\tlanguages\tlabs");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+rs.getString(4)+rs.getString(5));
				}			
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			
			break;
			
			case 2:System.out.println("STUDENT ID");
			
			try {
				scon=DbConnect.getConnection();
				st=scon.createStatement();			
				String sql="select * from schoolinfo";
				rs=st.executeQuery(sql);
				System.out.println("sid\tName\tTeacher\tLabs\tRecords");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
				}
			
			}
				
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			break;
			
			
			case 3:System.out.println("SCHOOL LABS");
			
			try {
				scon=DbConnect.getConnection();
				st=scon.createStatement();			
				String sql="select * from schoolinfo";
				rs=st.executeQuery(sql);
				System.out.println("sid\tSchool\tTeacher\tLabs\tRecords");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
				}
			
			}
				
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			break;
			default:System.out.println("INVALID CHOICE");
			}
			}
	}




	
	
			
			
			
			
			
			
		
	
	
	
	
	
		
		
	
		
		


			
			
		

	
		

	

	

	
		
		
	

	

		
	

	
		
		
	

	
		
		
	


