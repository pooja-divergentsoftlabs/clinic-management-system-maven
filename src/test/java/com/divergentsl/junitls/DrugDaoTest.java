package com.divergentsl.junitls;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.DoctorDao;
import com.divergentsl.clinicmanagementsystem.dao.DrugDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

class DrugDaoTest {
	
	

	H2DatabaseManager driverManager = null;
	Statement st = null;
	Connection con = null;
	

	@BeforeEach
	void setUp() throws SQLException{
		driverManager = new H2DatabaseManager();
		con= driverManager.getConnection();
		st = con.createStatement();
		
		st.execute("drop table if exists drug");
		st.execute("create table if not exists drug (drugid varchar(15) ,drugname varchar(20) ,drugdescription varchar(25),drugquantity varchar(10) ,drugprice varchar(10))");
		st.execute("insert into drug values ('1','Crocin','Painkiller','4','20')");	 
				
	}
	
	

	@Test
	void addDrugDao() throws SQLException {
		DrugDao drugdao = new DrugDao(driverManager);
		assertEquals(1,drugdao.addDrug("1","Crocin","Painkiller","4","20"));
		
	}
	
	@Test
	void deleteDrugTest() throws SQLException {
		DrugDao drugdao = new DrugDao(driverManager);
		assertEquals(1, drugdao.deleteDrug("1"));
	}

	@Test
	void updateDrugTest() throws SQLException{
		DrugDao drugdao = new DrugDao(driverManager);
		assertEquals(1,drugdao.updateDrug("1","Crocin","Painkiller","4","20"));
	}
	
	@Test
	void listDrugTest() throws SQLException{
		DrugDao drugdao = new DrugDao(driverManager);
		assertFalse(drugdao.listDrug().isEmpty());
	}
	}
