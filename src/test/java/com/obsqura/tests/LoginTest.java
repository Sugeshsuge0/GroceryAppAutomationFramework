package com.obsqura.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ com.obsqura.listeners.ReportListeners.class})
public class LoginTest extends BaseTest {

	@Test
	public void MyLoginTest() {
		lp.Login();
		hp.NavigateToManagePaymentSection();
	
	}

}
