package com.obsqura.utilities;
public class GenerateRandomNumber {

	
	public static int GetRandomNumber() {
		
		double doubleRandomNumber = Math.random() * 5000;
        int randomNumber = (int)doubleRandomNumber;
       return randomNumber;
	}
}
