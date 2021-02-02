package com.pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.RETRYTestListIm;

public class SampleRetryTest {
	
	@Test(retryAnalyzer = RETRYTestListIm.class)
	public void createContact() {
		Assert.assertEquals("HDFC", "ffff");
		System.out.println("execute create conatct");
	}

}
