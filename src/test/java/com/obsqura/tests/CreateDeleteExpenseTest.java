package com.obsqura.tests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.utilities.DateUtility;
@Listeners({com.obsqura.listeners.ReportListeners.class})
public class CreateDeleteExpenseTest extends BaseTest {

	
	@Test(groups="Smoke")
	public void ManageExpenseTest() {
		lp.Login();
		hp.NavigateToManageExpense();
		
		String currentDate= DateUtility.getCurrentDate();
		String alertText = ecp.CreateExpense(currentDate);
		
		/**
		 * Validation for Expense Creation
		 */
		Assert.assertEquals(alertText, "Alert!", "Alert validation failed");
		String deletionText = ecp.DeleteExpense(currentDate);
		/**
		 * Validation for Expense Deletion
		 */
		Assert.assertEquals(deletionText,  "Expense Category Deleted Successfully");
		Assert.fail();
	}
}
