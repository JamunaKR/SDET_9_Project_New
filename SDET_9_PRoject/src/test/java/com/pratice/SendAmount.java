package com.pratice;

import java.sql.SQLException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.crm.autodesk.genericlib.DatabaseUtils;
import com.crm.autodesk.genericlib.JavaUtils;

public class SendAmount {
	//DatabaseUtils dbLib = new DatabaseUtils();
	JavaUtils javalib = new JavaUtils();
	@Test
	public void sendAmountTest() throws SQLException {
		String projectID = "TY_PROJ_"+javalib.generateRandomNum();
		System.out.println("insert amount in to database ");
		
		//int result = dbLib.executeNonSelectQuery("insert int project values('"+projectID+"', 'deepak', '10/4/2020','jdbc', 'Completed', 10)");
	
	//	Assert.assertEquals(result, 1);
		
		  WebDriver driver = new FirefoxDriver(); driver.get("http://localhost:8888");
		  driver.findElement(By.name("user_name")).sendKeys("root");
		  driver.findElement(By.name("user_password")).sendKeys("root");
		 driver.findElement(By.id("submitButton")).click();
		 
		
	}
}
