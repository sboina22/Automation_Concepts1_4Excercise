package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/TestData/SpiceClub.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("SignUp");
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(0).getLastCellNum();
		
		for(int r=0; r<=totalRows;r++) {
			XSSFRow row = sheet.getRow(r);
			for(int c=0;c<totalCells;c++) {
				XSSFCell cell = sheet.getRow(r).getCell(c);
				String contentCell = cell.toString();
				System.out.print(contentCell+"\t");
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
	}
	

}
