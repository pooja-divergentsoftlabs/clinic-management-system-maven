package com.divergentsl.clinicmanagementsystem.java;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.divergentsl.clinicmanagementsystem.dao.PatientDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.PatientDto;

public class CRUDPatient {

	public static void crudPatient() {

		exit: while (true) {
			System.out.println("------CRUD Patient-----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of patient");
			System.out.println("5.Exit");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				addPatient();
				break;
			case 2:
				deletePatient();
				break;
			case 3:
				updatePatient();
				break;
			case 4:
				listPatient();
				break;
			case 5:
				break exit;

			}

		}
	}

	// add patient
	public static void addPatient() {

		System.out.println("----Add Patient-----");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id=");
		String pid = sc.nextLine();

		System.out.println("Enter name=");
		String pname = sc.nextLine();

		System.out.println("Enter address=");
		String paddress = sc.nextLine();

		System.out.println("Enter contact number=");
		String pcontactnumber = sc.nextLine();

		System.out.println("Enter age=");
		String page = sc.nextLine();

		System.out.println("Enter weight=");
		String pweight = sc.nextLine();

		PatientDao patientdao = new PatientDao(new DatabaseManager());

		try {
			patientdao.addPatient(pid, pname, paddress, pcontactnumber, page, pweight);
			System.out.println("Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//delete
	public static void deletePatient() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("-----Delete Patient------");
		System.out.println("Enter the patient id=");
		String pid = sc.nextLine();
		
		PatientDao patientdao = new PatientDao(new DatabaseManager());
		
		try {
			patientdao.deletePatient(pid);
			System.out.println("Deleted Successfully");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//update
	public static void updatePatient() {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("-----Update Patient------");
		System.out.println("Enter patient id=");
		String pid = sc.nextLine();
		System.out.println("Enter new patient name=");
		String pname = sc.nextLine();
		System.out.println("Enter new patient address=");
		String paddress = sc.nextLine();
		System.out.println("Enter new patient contactnumber=");
		String pcontactnumber = sc.nextLine();
		System.out.println("Enter new patient age=");
		String page = sc.nextLine();
		System.out.println("Enter new patient weight=");
		String pweight = sc.nextLine();
		
		PatientDao patientDao = new PatientDao(new DatabaseManager());
		
		try {
			patientDao.updatePatient(pid, pname, paddress, pcontactnumber, page, pweight);
			System.out.println("Updated Successfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//list of patient
	public static void listPatient() {
		//Scanner sc = new Scanner(System.in);
		System.out.println("----List of Patient----");
		// System.out.println("Enter the patient id");
		 //String pid = sc.nextLine();		 
		 try {
			 PatientDao patientdao = new PatientDao(new DatabaseManager());
		    List<PatientDto> dtos= patientdao.listPatient();
		 
		    
		    for(PatientDto patientDto : dtos) {
		    	System.out.printf(" %10s %30s %15s  %20s %20s %20s ", patientDto.getPid(), patientDto.getPname(), patientDto.getPaddress(),
						patientDto.getPcontactnumber(), patientDto.getPage(), patientDto.getPweight());
				System.out.println("\n");
		    }	    
		    
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
	}

}
