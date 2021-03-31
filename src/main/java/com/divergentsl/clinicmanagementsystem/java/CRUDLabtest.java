package com.divergentsl.clinicmanagementsystem.java;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.divergentsl.clinicmanagementsystem.dao.LabtestDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.LabtestDto;


public class CRUDLabtest{

	public static void crudLabtest() {

		exit: while (true) {
			System.out.println("------CRUD Labtest-----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of labtest");
			System.out.println("5.Exit");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				addLabtest();
				break;
			case 2:
				deleteLabtest();
				break;
			case 3:
				updateLabtest();
				break;
			case 4:
				listLabtest();
				break;
			case 5:
				break exit;

			}

		}
	}

	// add patient
	public static void addLabtest() {

		System.out.println("----Add Labtest-----");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter test id=");
		String testid = sc.nextLine();

		System.out.println("Enter test name=");
		String testname = sc.nextLine();

		System.out.println("Enter patient id=");
		String pid = sc.nextLine();

		System.out.println("Enter test fee=");
		String testfee = sc.nextLine();

		LabtestDao labtestdao = new LabtestDao(new DatabaseManager());

		try {
			labtestdao.addLabtest(testid, testname, pid, testfee);
			System.out.println("Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//delete
	public static void deleteLabtest() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Delete Labtest------");
		System.out.println("Enter the test id=");
		String testid = sc.nextLine();
		
		LabtestDao labtestdao = new LabtestDao(new DatabaseManager());
		
		try {
			labtestdao.deleteLabtest(testid);
			System.out.println("Deleted Successfully");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//update
	public static void updateLabtest() {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("----Update Labtest----");	
		System.out.println("Enter test id=");
		String testid = sc.nextLine();
		System.out.println("Enter new test name=");
		String testname = sc.nextLine();
		System.out.println("Enter new patient id=");
		String pid = sc.nextLine();
		System.out.println("Enter new test fee=");
		String testfee = sc.nextLine();
		
		LabtestDao labtestdao = new LabtestDao(new DatabaseManager());
		
		try {
			labtestdao.updateLabtest(testid, testname, pid, testfee);
			System.out.println("Updated Successfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//list of lab test
	public static void listLabtest() {
	
		System.out.println("----List of Labtest----");	 
		 try {
			 LabtestDao labtestdao = new LabtestDao(new DatabaseManager());
		    List<LabtestDto> dtos= labtestdao.listLabtest();
		    //System.out.printf("id  name\t  pid\t  fees\n ");
		    
		    for(LabtestDto labtestDto : dtos) {
		    	System.out.printf(" %10s %30s %15s  %20s ", labtestDto.getTestid(), labtestDto.getTestname(), labtestDto.getPid(),
		    			labtestDto.getTestfee());
				System.out.println("\n");
		    }	    
		    
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
	}

}
