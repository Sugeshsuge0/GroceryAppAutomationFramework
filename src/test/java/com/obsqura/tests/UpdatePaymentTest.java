package com.obsqura.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.utilities.GenerateRandomNumber;

@Listeners({ com.obsqura.listeners.ReportListeners.class })
public class UpdatePaymentTest extends BaseTest {

	@Test
	public void UpdateCreditPayment() {
		lp.Login();
		hp.NavigateToManagePaymentSection();
		int randomNumber = GenerateRandomNumber.GetRandomNumber();
		up.UpdateCreditDetail(randomNumber);
		up.ValidateCreditisUpdated();
		/**
		 * Perform Validation
		 */

	}
}
