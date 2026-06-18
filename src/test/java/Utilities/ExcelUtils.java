package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtils {
	/*
	//Create a constructor with the same class name, when ever wants to use methods of the class, pass the parameter, say file and start use of methods
	public ExcelUtils(file){
		this.file = file;
	}
	*/
	
	@Test
	void ReadingDataFromExcell() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/TestData/SpiceClub.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("SignUp");
		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getLastCellNum();
		System.out.println("Total Rows ==> "+totalRows);
		System.out.println("Total Cells ==> "+totalColumns);
		
		for (int r=0; r<=totalRows; r++){
			XSSFRow row =sheet.getRow(r);
			for(int c=0;c<totalColumns; c++ ) {
				XSSFCell cell = row.getCell(c);
				String cellData =cell.toString();
				System.out.print(cellData+"\t");
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
	}
}

