package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class ManagePaymentMethodsPage extends PageUtility {

	WebDriver driver;

	public ManagePaymentMethodsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr[2]//td[4]/a[1]")
	private WebElement editBtn;

	@FindBy(css = "#limit")
	private WebElement payLimit;

	@FindBy(css = "button[name='Update']")
	private WebElement updateBtn;

	public void UpdateCreditDetail(int randomNumber) {
		ClickElement(editBtn);
		SetTextBox(payLimit, Integer.toString(randomNumber));
		ClickElement(updateBtn);
	}

	public void ValidateCreditisUpdated() {
	}
}
