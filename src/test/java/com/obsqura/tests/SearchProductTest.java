package com.obsqura.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.utilities.TestProperties;

@Listeners({ com.obsqura.listeners.ReportListeners.class })
public class SearchProductTest extends BaseTest {

	@Test(groups = "Smoke")
	public void SearchProduct() throws IOException {
		lp.Login();
		hp.NavigateToManageProductSection();
		lpp.SearchProduct(GetProductName());
		String actualName = lpp.validateProductExists();
		/**
		 * Validation
		 */
		Assert.assertEquals(actualName, GetProductName());
		

	}

	public String GetProductName() throws IOException {
		return TestProperties.GetProperties().getProperty("productName");
	}
}
