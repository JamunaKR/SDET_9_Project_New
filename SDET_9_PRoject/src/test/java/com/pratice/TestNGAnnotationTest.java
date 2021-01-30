package com.pratice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationTest {
	@BeforeClass
	public void configBC() {
		System.out.println("launch browser and enter the url");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("login to vtiger");
	}
	@BeforeSuite
	public void configBS() {
		System.out.println("connect to database\n configure extent report");
	}
	@BeforeTest
	public void configBT() {
		//used for cross browser exceution
	}
	
	
	@Test
	public void createOrgTest() {
		System.out.println("create organization");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("logout from the app");
	}
	@AfterClass
	public void configAC() {
		System.out.println("quit the browser");
	}
	
	@AfterTest
	public void configAT() {
		//close browser launched in cross browser testing
	}
	@AfterSuite
	public void configAS() {
		
		System.out.println("close connection to database\n flush extent report");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
