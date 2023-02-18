package org.mbm.interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcelFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File(".\\resources\\users_data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		int noOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(noOfRows);
		for(int i=1; i<noOfRows; i++) {
			int noOfColumns = sheet.getRow(i).getPhysicalNumberOfCells();
			for(int j=0;j<noOfColumns; j++) {
				XSSFCell cell = sheet.getRow(i).getCell(j);
				String cellValue = getCellValue(cell);
				System.out.print("||"+cellValue);
				
			}
			
			System.out.println();
		}
		
		workbook.close();
		fis.close();
		
		
	}
	
	public static String getCellValue(XSSFCell cell) {
		switch(cell.getCellType()) {
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case STRING:
			return String.valueOf(cell.getStringCellValue());
		default:
			return cell.getStringCellValue();
		}
		
	}

}
