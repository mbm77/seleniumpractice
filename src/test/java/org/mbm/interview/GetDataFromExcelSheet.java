package org.mbm.interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcelSheet {

	public static void main(String[] args) throws IOException {
		File file = new File(".\\resources\\users_data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		System.out.println(noOfRows+" "+noOfColumns);
		for(int i=1; i<noOfRows; i++) {
			for(int j=0;j<noOfColumns;j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
								
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
		
	}

}
