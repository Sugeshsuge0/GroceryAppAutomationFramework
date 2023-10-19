package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class LoginPage  extends PageUtility{

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//define my locators here
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement userNameField;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	public void Login() {
		SetTextBox(userNameField, "admin");
		SetTextBox(passwordField, "admin");
		ClickElement(loginBtn);	
	}
}
