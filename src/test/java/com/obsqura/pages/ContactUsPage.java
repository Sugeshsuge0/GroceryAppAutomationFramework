package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.model.Person;
import com.obsqura.utilities.PageUtility;

public class ContactUsPage  extends PageUtility{

	WebDriver driver;
	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath="//i[@class='fas fa-edit']")
	private WebElement editBtn;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneNum;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email ;
	
	@FindBy(xpath="//textarea[1]")
	private WebElement address ;
	
	@FindBy(xpath="//textarea[2]")
	private WebElement deliveryTime;
	
	@FindBy(xpath="//input[@id='del_limit']")
	private WebElement deliveryChargeLimit;
	
	@FindBy(xpath="//button[@name='Update']")
	private WebElement updateBtn;
	
	
	public void submitFormData(Person person) {
		ClickElement( editBtn);
		SetTextBox(phoneNum, person.phoneNumber);
		SetTextBox(email, person.email);
		SetTextBox(address, person.address);
		SetTextBox(deliveryTime, person.deliveryTime);
		SetTextBox(deliveryChargeLimit, person.deliveryCharge);
		scroll();
		ClickElement( updateBtn);
	}
}