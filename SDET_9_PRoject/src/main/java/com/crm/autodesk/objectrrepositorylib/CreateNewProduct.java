package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Deepak
 *
 */
public class CreateNewProduct {
	WebDriver driver;
	public CreateNewProduct(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(name = "unit_price")
	private WebElement unitPriveEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	/**
	 * 
	 * @param productName
	 */
	public void createProduct(String productName) {
		productNameEdt.sendKeys(productName);
		saveBtn.click();
	}
	/**
	 * 
	 * @param productName
	 * @param unitPrice
	 */
	public void createProduct(String productName ,String unitPrice) {
		productNameEdt.sendKeys(productName);
		unitPriveEdt.sendKeys(unitPrice);
		saveBtn.click();
	}
	
}
