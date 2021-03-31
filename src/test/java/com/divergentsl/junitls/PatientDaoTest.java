package com.divergentsl.junitls;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.PatientDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

class PatientDaoTest {

	H2DatabaseManager driverManager = null;
	Statement st = null;
	Connection con = null;

	@BeforeEach
	void setUp() throws SQLException {
		driverManager = new H2DatabaseManager();
		con = driverManager.getConnection();
		st = con.createStatement();

		st.execute("drop table if exists patient");
		st.execute(
				"create table if not exists patient (pid varchar(15),pname varchar(20),paddress varchar(30),pcontactnumber varchar(12),page varchar(10),pweight varchar(10)   )");
		st.execute("insert into patient values ('1','Pooja','Indore','9754678902','21','48')");
	}

	@Test
	void addPatientTest() throws SQLException {
		PatientDao patientdao = new PatientDao(driverManager);
		assertEquals(1, patientdao.addPatient("1", "Pooja", "Indore", "9754678902", "21", "48"));
	}

	@Test
	void deletePatientTest() throws SQLException {
		PatientDao patientdao = new PatientDao(driverManager);
		assertEquals(1, patientdao.deletePatient("1"));
	}

	@Test
	void updatePatientTest() throws SQLException{
		PatientDao patientdao = new PatientDao(driverManager);
		assertEquals(1,patientdao.updatePatient("1", "Jay", "Sanwer","7772972825","23", "70"));
	}
	
	@Test
	void listPatientTest() throws SQLException{
		PatientDao patientdao = new PatientDao(driverManager);
		assertFalse(patientdao.listPatient().isEmpty());
	}
}
