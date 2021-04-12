package com.divergentsl.clinicmanagementsystem.java;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.divergentsl.clinicmanagementsystem.dao.LabtestDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.LabtestDto;

public class CRUDLabtest {
	public static final Logger myLogger= Logger.getLogger("com.mycompany.myapp");

	public static void crudLabtest() {

		exit: while (true) {
			myLogger.setLevel(Level.FINE);
			myLogger.log(Level.INFO,"-------CRUD Labtest------");
			myLogger.log(Level.INFO,"1.Add");
			myLogger.log(Level.INFO,"2.Delete");
			myLogger.log(Level.INFO,"3.Update");
			myLogger.log(Level.INFO,"4.List of labtest");
			myLogger.log(Level.INFO,"5.Exit");
			
			
			/*System.out.println("------CRUD Labtest-----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of labtest");
			System.out.println("5.Exit");
			*/
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
		myLogger.log(Level.INFO,"------Add Labtest------");
		//System.out.println("----Add Labtest-----");
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
			myLogger.log(Level.INFO,"Added Successfully");
			//System.out.println("Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// delete
	public static void deleteLabtest() {

		Scanner sc = new Scanner(System.in);
		myLogger.log(Level.INFO,"-------Delete Labtest-------");
		//System.out.println("-----Delete Labtest------");
		System.out.println("Enter the test id=");
		String testid = sc.nextLine();

		LabtestDao labtestdao = new LabtestDao(new DatabaseManager());

		try {
			labtestdao.deleteLabtest(testid);
			myLogger.log(Level.INFO,"Deleted Successfully");
			//System.out.println("Deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update
	public static void updateLabtest() {

		Scanner sc = new Scanner(System.in);
		myLogger.log(Level.INFO,"------Update Labtest-------");
		//System.out.println("----Update Labtest----");
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
			myLogger.log(Level.INFO,"Updated Successfully");
			//System.out.println("Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// list of lab test
	public static void listLabtest() {
		myLogger.log(Level.INFO,"------List of Labtest------");
		//System.out.println("----List of Labtest----");
		try {
			LabtestDao labtestdao = new LabtestDao(new DatabaseManager());
			List<LabtestDto> dtos = labtestdao.listLabtest();
			// System.out.printf("id name\t pid\t fees\n ");

			for (LabtestDto labtestDto : dtos) {
				System.out.printf(" %10s %30s %15s  %20s ", labtestDto.getTestid(), labtestDto.getTestname(),
						labtestDto.getPid(), labtestDto.getTestfee());
				System.out.println("\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
