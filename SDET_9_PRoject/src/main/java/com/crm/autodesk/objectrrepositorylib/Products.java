package com.crm.autodesk.objectrrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericlib.WebDriverUtiles;
/**
 * 
 * @author Deepak
 *
 */
public class Products extends WebDriverUtiles{
	public Products(WebDriver driver) {             
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductImg;
	
	
	@FindBy(name = "search_text")
	private WebElement serchText;
	
	@FindBy(name = "search_field")
	private WebElement serchlst;
	
	@FindBy(name = "submit")
	private WebElement serchBtn;
	
	

	public WebElement getCreateProductImg() {
		return createProductImg;
	}
	
	/**
	 * 
	 */
	public void serachProduct(String dropDwonValue , String actualValue) {
		select(serchlst, dropDwonValue);
		serchText.sendKeys(actualValue);
		serchBtn.click();
	}
	
	
}
