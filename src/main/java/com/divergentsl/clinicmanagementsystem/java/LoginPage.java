package com.divergentsl.clinicmanagementsystem.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginPage {

	public static void loginPage() {

		exit: while (true) {
			System.out.println("------Clinic Management System-------");
			System.out.println("------LOGIN PAGE-----");
			System.out.println("1.Admin");
			System.out.println("2.Doctor");
			System.out.println("3.Exit");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {

			case 1:
				if(adminLogin()) {
				AdminPanel.adminPanel();
				}
				else {
					System.out.println("Wrong id/password");
				}
				break;

			case 2:
				if(doctorLogin()) {
					DoctorLogin.doctorPanel();
				}else {
					System.out.println("Wrong id/password");
				}
				break;

			case 3:
				System.out.println("----EXIT----");
				break exit;

			}
		}
	}
	
	 public static boolean adminLogin(){
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter username=");
	        String username = sc.nextLine();

	        System.out.println("Enter password=");
	        String password = sc.nextLine();

	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_management_system","root","root");
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM adminn where a_username = '"+username+"' && a_password = '"+password+"'");
	            if(rs.next()){
	                System.out.println("Login Successful");
	                return true;
	            }
	            else{
	                System.out.println("Wrong username/password");
	                return false;
	            }

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }


	        return false;
	    }
	 
	 
	 public static boolean doctorLogin(){
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter username=");
	        String username = sc.nextLine();

	        System.out.println("Enter password");
	        String password = sc.nextLine();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_management_system","root","root");
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM doctorlogin where d_username='"+username+"'&& d_password='"+password+"' ");
	            if(rs.next()){
	                System.out.println("Login successful");
	                return true;
	            }
	            else{
	                System.out.println("Wrong username/password");
	                return false;
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	        return false;
	    }

	 
	 
	 
	 
}
	
	
	 
