package com.obsqura.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.obsqura.constants.Constants;
import com.obsqura.model.Person;

public class ExcelReaderUtility {

	public static List<Person> readDataFromExcel() throws IOException {
		List<Person> list = new ArrayList<>();
		FileInputStream fileInputStream = new FileInputStream(Constants.EXCEL_FILE_PATH);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheetAt(0); // give me first sheet
		int lastRow = sheet.getLastRowNum();

		for (int rowIndex = 1; rowIndex <= lastRow; rowIndex++) {
			Row row = sheet.getRow(rowIndex);

			int phoneNumber = (int) row.getCell(0).getNumericCellValue();
			String email = row.getCell(1).getStringCellValue();
			String address = row.getCell(2).getStringCellValue();
			String deliveryTime=row.getCell(3).getStringCellValue();
			int deliveryCharge=(int) row.getCell(4).getNumericCellValue();
			
		list.add(new Person(Integer.toString(phoneNumber), email, address, deliveryTime, Integer.toString(deliveryCharge)));
			
			
//			System.out.print(phoneNumber + " "+email + " "+address+" "+deliveryTime+" "+deliveryCharge);
//			System.out.println();
			
		}
		return list;
	}
}
