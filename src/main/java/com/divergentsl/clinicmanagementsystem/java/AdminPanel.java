package com.divergentsl.clinicmanagementsystem.java;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminPanel {
	public static final Logger myLogger = Logger.getLogger("com.mycompany.myapp");
	
	public static void adminPanel() {
		
		exit:
			while(true) {
				myLogger.setLevel(Level.FINE);
				myLogger.log(Level.INFO,"-------Admin Panel------");
				myLogger.log(Level.INFO,"1.CRUD Patient");
				myLogger.log(Level.INFO,"2.CRUD Doctor");
				myLogger.log(Level.INFO,"3.CRUD Drug");
				myLogger.log(Level.INFO,"4.CRUD Lab Test");
				myLogger.log(Level.INFO,"5.CRUD Appointment");
				myLogger.log(Level.INFO,"6.Exit");
				/*
				System.out.println("--------Admin Panel-------");
				System.out.println("1.CRUD Patient");
				System.out.println("2.CRUD Doctor");
				System.out.println("3.CRUD Drug");
				System.out.println("4.CRUD Lab Test");
				System.out.println("5.CRUD Appointment");
				System.out.println("6.Exit");
				*/
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter your choice=");
				int input = sc.nextInt();
				
				switch (input) {
				
				case 1:
					CRUDPatient.crudPatient();
					break;
					
				case 2:
					CRUDDoctor.crudDoctor();
					break;
					
				case 3:
					CRUDDrug.crudDrug();
					break;
					
				case 4:
					CRUDLabtest.crudLabtest();
					break;
					
				case 5:
					CRUDAppointment.crudAppointment();
					break;
					
				case 6:
					break exit;
				}
				
				
			}
	}

}
