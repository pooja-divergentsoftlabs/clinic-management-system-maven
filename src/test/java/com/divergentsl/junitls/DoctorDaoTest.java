package com.divergentsl.junitls;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.DoctorDao;
import com.divergentsl.clinicmanagementsystem.dao.PatientDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

class DoctorDaoTest {
	
	H2DatabaseManager driverManager = null;
	Statement st = null;
	Connection con = null;
	
	
	@BeforeEach
	void setUp() throws SQLException{
		driverManager = new H2DatabaseManager();
		con= driverManager.getConnection();
		st = con.createStatement();
		
		st.execute("drop table if exists doctor");
		st.execute("create table if not exists doctor (did varchar(10),dname varchar(25),dspeciality varchar(20),dcontactnumber varchar(12),dfees varchar(10))");
		st.execute("insert into doctor values ('1','LayPatidar','surgeon','9876540987','2000')");	 
		
	}
	

	@Test
	void addDoctorDao() throws SQLException {
		DoctorDao doctordao = new DoctorDao(driverManager);
		assertEquals(1,doctordao.addDoctor("1", "LayPatidar", "surgeon", "9876540987", "2000"));
		
	}
	@Test
	void deleteDoctorTest() throws SQLException {
		DoctorDao doctordao = new DoctorDao(driverManager);
		assertEquals(1, doctordao.deleteDoctor("1"));
	}

	@Test
	void updateDoctorTest() throws SQLException{
		DoctorDao doctordao = new DoctorDao(driverManager);
		assertEquals(1,doctordao.updateDoctor("1", "LayPatidar", "surgeon","9876540987","2000"));
	}
	
	@Test
	void listDoctorTest() throws SQLException{
		DoctorDao doctordao = new DoctorDao(driverManager);
		assertFalse(doctordao.listDoctor().isEmpty());
	}

	
	

}
