package com.obsqura.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.constants.Constants;
import com.obsqura.constants.WebDriverContext;


public class PageUtility extends WaitUtility {
	WebDriver driver;
	WebDriverWait wait;

	public PageUtility(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public void ClickElement(WebElement element) {
		isElementDisplayed(element);
		isElemenClickable(element);
		element.click();
	}

	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000);");
	}

	public void waitFor() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void isElementDisplayed(WebElement element) {
		waitFor();
		try {
			if (element.isDisplayed()) {
				//System.out.println("element is Displayed " + element);
			}
		} catch (Exception e) {
			//Assert.assertTrue(false);
		}

	}

	public void SetTextBox(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public String GetElemenText(WebElement element) {
		return element.getText();
	}

	public void AcceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static String getScreenshot() throws IOException {
		TakesScreenshot scrshot=(TakesScreenshot)WebDriverContext.getDriver();
		File srcfile = scrshot.getScreenshotAs(OutputType.FILE);
		String path=Constants.SCREENSHOTPATH;
		File destfile = new File(path);
		FileUtils.copyFile(srcfile, destfile);
		return path;
	}
	public void uploadFile(By locator, String fileToUpload) throws AWTException {
		driver.findElement(locator).click();

	     //put path to your image in a clipboard
	     StringSelection ss = new StringSelection(fileToUpload);
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	     //imitate mouse events like ENTER, CTRL+C, CTRL+V
	     Robot robot = new Robot();
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
