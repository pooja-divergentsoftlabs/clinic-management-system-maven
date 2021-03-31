package com.divergentsl.junitls;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.divergentsl.clinicmanagementsystem.dao.DrugDao;
import com.divergentsl.clinicmanagementsystem.dao.LabtestDao;
import com.divergentsl.clinicmanagementsystem.databaseconnection.H2DatabaseManager;

class LabtestDaoTest {

	

	H2DatabaseManager driverManager = null;
	Statement st = null;
	Connection con = null;
	

	@BeforeEach
	void setUp() throws SQLException{
		driverManager = new H2DatabaseManager();
		con= driverManager.getConnection();
		st = con.createStatement();
		
		st.execute("drop table if exists labtest");
		st.execute("create table if not exists labtest(testid varchar(10) ,testname varchar(20) ,pid varchar(10),testfee varchar(10))");
		st.execute("insert into labtest values ('1','Bloodtest','4','2000')");	 
					
	}
	
	

	@Test
	void addLabtestDao() throws SQLException {
		LabtestDao labtestdao = new LabtestDao(driverManager);
		assertEquals(1,labtestdao.addLabtest("1","Bloodtest","4","2000"));
		
	}
	
	@Test
	void deleteLabtestTest() throws SQLException {
		LabtestDao drugdao = new LabtestDao(driverManager);
		assertEquals(1, drugdao.deleteLabtest("1"));
	}

	@Test
	void updateLabtestTest() throws SQLException{
		LabtestDao labtestdao = new LabtestDao(driverManager);
		assertEquals(1,labtestdao.updateLabtest("1","Bloodtest","4","2000"));
	}
	
	@Test
	void listLabtestTest() throws SQLException{
		LabtestDao labtestdao = new LabtestDao(driverManager);
		assertFalse(labtestdao.listLabtest().isEmpty());
	}
	}



