
	package com.divergentsl.clinicmanagementsystem.java;

	import java.sql.SQLException;
	import java.util.List;
	import java.util.Scanner;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;
import com.divergentsl.clinicmanagementsystem.dao.LabtestDao;
	import com.divergentsl.clinicmanagementsystem.databaseconnection.DatabaseManager;
import com.divergentsl.clinicmanagementsystem.dto.AppointmentDto;
import com.divergentsl.clinicmanagementsystem.dto.LabtestDto;


	public class CRUDAppointment{

		public static void crudAppointment() {

			exit: while (true) {
				System.out.println("------CRUD Apoointment-----");
				System.out.println("1.Add");
				System.out.println("2.Delete");
				System.out.println("3.Update");
				System.out.println("4.List of Appointment");
				System.out.println("5.Exit");

				Scanner sc = new Scanner(System.in);
				System.out.println("Enter your choice=");
				int input = sc.nextInt();

				switch (input) {
				case 1:
					addAppointment();
					break;
				case 2:
					deleteAppointment();
					break;
				case 3:
					updateAppointment();
					break;
				case 4:
					listAppointment();
					break;
				case 5:
					break exit;

				}

			}
		}

		// add patient
		public static void addAppointment() {

			System.out.println("----Add Appointment-----");
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Appointment id=");
			String appid = sc.nextLine();

			System.out.println("Enter patient id=");
			String pid = sc.nextLine();

			System.out.println("Enter patient name=");
			String pname = sc.nextLine();

			System.out.println("Enter Appointment date=");
			String appdate = sc.nextLine();

			AppointmentDao appointmentdao = new AppointmentDao(new DatabaseManager());

			try {
				appointmentdao.addAppointment(appid, pid, pname, appdate);
				System.out.println("Added Successfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		//delete
		public static void deleteAppointment() {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("-----Delete appointment------");
			System.out.println("Enter the app id=");
			String appid = sc.nextLine();
			
			AppointmentDao appointmentdao = new AppointmentDao(new DatabaseManager());
			
			try {
				appointmentdao.deleteAppointment(appid);
				System.out.println("Deleted Successfully");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		//update
		public static void updateAppointment() {
			
			Scanner sc = new Scanner (System.in);
			System.out.println("----Update Appointment----");	
			System.out.println("Enter appointment id=");
			String appid = sc.nextLine();
			System.out.println("Enter new patient id=");
			String pid = sc.nextLine();
			System.out.println("Enter new patient name=");
			String pname = sc.nextLine();
			System.out.println("Enter new app date=");
			String appdate = sc.nextLine();
			
			AppointmentDao appointmentdao = new AppointmentDao(new DatabaseManager());
			
			try {
				appointmentdao.updateAppointment(appid, pid, pname, appdate);
				System.out.println("Updated Successfully");
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		//list of lab test
		public static void listAppointment() {
		
			System.out.println("----List of Appointment----");	 
			 try {
				 AppointmentDao appointmentdao = new AppointmentDao(new DatabaseManager());
			    List<AppointmentDto> dtos= appointmentdao.listAppointment();
			    
			    for(AppointmentDto appointmentDto : dtos) {
			    	System.out.printf(" %s %30s %30s  %20s ", appointmentDto.getAppid(), appointmentDto.getPid(), appointmentDto.getPname(),
			    			appointmentDto.getAppdate());
					System.out.println("\n");
			    }	    
			    
			 }catch (SQLException e) {
				 e.printStackTrace();
			 }
		}

	}



