package com.divergentsl.clinicmanagementsystem.java;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.divergentsl.clinicmanagementsystem.dao.DrugDao;
import com.divergentsl.clinicmanagementsystem.dao.PatientDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.DrugDto;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

public class CRUDDrug {
	public static final Logger myLogger=Logger.getLogger("com.mycompany.myapp");

	public static void crudDrug() {

		exit: while (true) {
			myLogger.setLevel(Level.FINE);
			myLogger.log(Level.INFO,"-------CRUD Drug------");
			myLogger.log(Level.INFO,"1.Add");
			myLogger.log(Level.INFO,"2.Delete");
			myLogger.log(Level.INFO,"3.Update");
			myLogger.log(Level.INFO,"4.List of drug");
			myLogger.log(Level.INFO,"5.Exit");
			/*System.out.println("-----CRUDDrug----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of drug");
			System.out.println("5.Exit");
			*/
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				addDrug();
				break;
			case 2:
				deleteDrug();
				break;
			case 3:
				updateDrug();
				break;
			case 4:
				listDrug();
				break;
			case 5:
				break exit;
			}

		}
	}

	// add
	public static void addDrug() {
		myLogger.log(Level.INFO,"-------Add Drug-----");
		//System.out.println("----Add Drug-----");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter drug id=");
		String drugid = sc.nextLine();

		System.out.println("Enter drug name=");
		String drugname = sc.nextLine();

		System.out.println("Enter drug description=");
		String drugdescription = sc.nextLine();

		System.out.println("Enter quantity=");
		String drugquantity = sc.nextLine();

		System.out.println("Enter drugprice=");
		String drugprice = sc.nextLine();

		DrugDao drugdao = new DrugDao(new DatabaseManager());

		try {
			drugdao.addDrug(drugid, drugname, drugdescription, drugquantity, drugprice);
			myLogger.log(Level.INFO,"Added Successfully");
			//System.out.println("Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// delete
	public static void deleteDrug() {
		Scanner sc = new Scanner(System.in);
		myLogger.log(Level.INFO,"-------Delete Drug-----");
		//System.out.println("-----Delete Drug------");
		System.out.println("Enter the drug id=");
		String drugid = sc.nextLine();

		DrugDao drugdao = new DrugDao(new DatabaseManager());

		try {
			drugdao.deleteDrug(drugid);
			myLogger.log(Level.INFO,"Deleted Successfully");
			//System.out.println("Deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update
	public static void updateDrug() {
		Scanner sc = new Scanner(System.in);
		myLogger.log(Level.INFO,"-------Update Drug-----");
		//System.out.println("----Update Drug----");
		System.out.println("Enter drug id=");
		String drugid = sc.nextLine();
		System.out.println("Enter new drug name=");
		String drugname = sc.nextLine();
		System.out.println("Enter new drug description=");
		String drugdescription = sc.nextLine();
		System.out.println("Enter new drug quantity=");
		String drugquantity = sc.nextLine();
		System.out.println("Enter new drug price=");
		String drugprice = sc.nextLine();

		DrugDao drugdao = new DrugDao(new DatabaseManager());
		try {
			drugdao.updateDrug(drugid, drugname, drugdescription, drugquantity, drugprice);
			myLogger.log(Level.INFO,"Updated Successfully");
			//System.out.println("Updated Successfully");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// list of drug
	public static void listDrug() {
		myLogger.log(Level.INFO,"-------List of Drug-----");
		//System.out.println("----List of Drug----");
		try {
			DrugDao drugDao = new DrugDao(new DatabaseManager());
			List<DrugDto> dtos = drugDao.listDrug();

			for (DrugDto drugDto : dtos) {
				System.out.printf(" %10s %30s %15s  %20s %20s ", drugDto.getDrugid(), drugDto.getDrugname(),
						drugDto.getDrugdescription(), drugDto.getDrugquantity(), drugDto.getDrugprice());
				System.out.println("\n");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
