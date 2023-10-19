package com.obsqura.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class ExpenseCategoryPage extends PageUtility {

	WebDriver driver;

	public ExpenseCategoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newBtn;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement title;

	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveBtn;

	@FindBy(xpath = "//h5[normalize-space()='Alert!']")
	private WebElement alertText;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement search;
	
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchInput ;
	
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchBtn ;
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	private WebElement deleteBtn ;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlertText ;
	
	
	
	
	
	public String CreateExpense(String currentDate) {
		String name = "Obsqura";
		ClickElement(newBtn);
		SetTextBox(title, name + currentDate);
		ClickElement(saveBtn);
		return GetElemenText(alertText);

	}
	
	public String DeleteExpense(String currentDate) {
		String name = "Obsqura";
		ClickElement(search);
		SetTextBox(searchInput, name + currentDate);
		ClickElement(searchBtn);
		ClickElement(deleteBtn);
		AcceptAlert();
		String deleteText = GetElemenText(deleteAlertText);
		System.out.println(deleteText.split("Alert!")[1].trim());
		return deleteText.split("Alert!")[1].trim();
		
		
	}

}
