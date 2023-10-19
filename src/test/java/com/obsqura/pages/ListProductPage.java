package com.obsqura.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.constants.Constants;
import com.obsqura.utilities.PageUtility;

public class ListProductPage extends PageUtility {

	WebDriver driver;

	public ListProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define my locators here
	By locator = By.xpath("write your xpath here");

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchBtn;

	@FindBy(xpath = "//input[@placeholder='Title']")
	private WebElement title;

	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchBtn2;

	@FindBy(xpath = "//tbody//tr/td[1]")
	private WebElement productTitleColumn;

	public void SearchProduct(String productName) {
		ClickElement(searchBtn);
		SetTextBox(title, productName);
		ClickElement(searchBtn2);
	}

	public String validateProductExists() {
		String productCompleteName=GetElemenText(productTitleColumn);
	    return productCompleteName.split(" ")[0].trim().toLowerCase();
	}
	
	public void ValidateFileUpload() throws AWTException {
		 //uploadFile(locator, Constants.FILETOUPLOAD);
	}

}
