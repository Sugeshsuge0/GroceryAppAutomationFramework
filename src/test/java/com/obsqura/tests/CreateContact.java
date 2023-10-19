package com.obsqura.tests;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.obsqura.model.Person;
import com.obsqura.utilities.ExcelReaderUtility;

public class CreateContact extends BaseTest {

	@Test
	public void CreateContactTest() throws IOException {
		
		lp.Login();
		hp.NavigateToManageContact();
		 List<Person> list = ExcelReaderUtility.readDataFromExcel();
		 for(Person person :list) {
				cp.submitFormData(person);
				 
		 }
		
		/**
		 * Assertion or make validation
		 */
		
	}
}
