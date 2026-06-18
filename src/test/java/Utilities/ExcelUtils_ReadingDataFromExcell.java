package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelUtils_ReadingDataFromExcell {

	public static void main(String[] args) throws IOException {
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
