package com.divergentsl.clinicmanagementsystem.java;

import java.sql.SQLException;
import java.util.Scanner;

public class DoctorLogin {

	public static void doctorPanel() {

		Scanner sc = new Scanner(System.in);

		exit: while (true) {
			System.out.println("--------Doctor Panel-------");
			System.out.println("1.List of Patient");
			System.out.println("2.List of appointments booked");
			System.out.println("3.List of Lab Test");
			System.out.println("4.List of Drugs Available");
			System.out.println("5.Exit");

			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				CRUDPatient.listPatient();
				break;
			case 2:
				CRUDAppointment.listAppointment();
				break;
			case 3:
				CRUDLabtest.listLabtest();
				break;
			case 4:
				CRUDDrug.listDrug();
				break;
			case 5:
				break exit;

			}
		}

	}
}
