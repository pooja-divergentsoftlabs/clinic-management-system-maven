package com.divergentsl.junitls;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;
import com.divergentsl.clinicmanagementsystem.dao.LabtestDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

class AppointmentDaoTest {

	H2DatabaseManager driverManager = null;
	Statement st = null;
	Connection con = null;
	

	@BeforeEach
	void setUp() throws SQLException{
		driverManager = new H2DatabaseManager();
		con= driverManager.getConnection();
		st = con.createStatement();
		
		st.execute("drop table if exists appointment");
		st.execute("create table if not exists appointment(appid varchar(10) ,pid varchar(10) ,pname varchar(20) ,appdate varchar(15))");
		st.execute("insert into appointment values ('1','P0002','Neha','2021-10-10')");	 
		}
	
	

	@Test
	void addAppointmentDao() throws SQLException {
		AppointmentDao appointmentdao = new AppointmentDao(driverManager);
		assertEquals(1,appointmentdao.addAppointment("1","P0002","Neha","2021-10-10"));
		
	}
	
	@Test
	void deleteAppointmentTest() throws SQLException {
		AppointmentDao appointmentdao = new AppointmentDao(driverManager);
		assertEquals(1, appointmentdao.deleteAppointment("1"));
	}

	@Test
	void updateAppointmentTest() throws SQLException{
		AppointmentDao appointmentdao = new AppointmentDao(driverManager);
		assertEquals(1,appointmentdao.updateAppointment("1","P0002","Neha","2021-10-10"));
	}
	
	@Test
	void listAppointmentTest() throws SQLException{
		AppointmentDao appointmentdao = new AppointmentDao(driverManager);
		assertFalse(appointmentdao.listAppointment().isEmpty());
	}

}
