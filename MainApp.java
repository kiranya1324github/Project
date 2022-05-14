package com.edu.school;

import java.util.Scanner;

public class MainApp {

			public static void main(String[] args) {
				
				
				Scanner sc=new Scanner(System.in);
				while(true) {
				System.out.println("******SCHOOL MANAGEMENT  SYSTEM******");
				System.out.println("Enter your choice: ");
				System.out.println("1.Login");
				System.out.println("2.Insert a record");
				System.out.println("3.Delete a record");
				System.out.println("4.Student Information");
				System.out.println("5.Select a student labs");
				System.out.println("6.Display all the information");
				
				int in=sc.nextInt();
				
				
				switch(in) {
				case 1: SchoolDataOperations.Login();
				        break;
				case 2: SchoolDataOperations.insertSchoolInfo();
				        break;
				case 3: SchoolDataOperations.deleteSchoolInfo(); 
				         break;
				case 4: SchoolDataOperations.StudentInfo();
				         break;
				case 5: SchoolDataOperations.selectSchoolInfo();
				         break;
				case 6: SchoolDataOperations.displaySchoolInfo();  
				break;
				 default:System.out.println("Invalid choice");
				} //switch
				
				System.out.println("Do you want to continue yes/no");
				String choice=sc.next();
				if(choice.equalsIgnoreCase("no")) {
					break;
				} 
				
				}
				System.out.println("Program Terminated");
			} 

		}

	


