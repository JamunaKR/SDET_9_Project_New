package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Deepak
 *
 */
public class PRoductInfo {
	
	public PRoductInfo(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "dtlview_Unit Price")
	private WebElement actunitPrice;
	
	@FindAll({ @FindBy(xpath = "//span[@class='lvtHeaderText']") ,@FindBy(xpath = "//span[@class='dvHeaderText']")})
	  private WebElement successFullMsg;


	public WebElement getSuccessFullMsg() {
		return successFullMsg;
	}


	public WebElement getActunitPrice() {
		return actunitPrice;
	}
	
	
}
