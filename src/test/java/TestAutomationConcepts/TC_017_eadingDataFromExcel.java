package TestAutomationConcepts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TC_017_eadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		// FileInputStream - Selenium class opens file in Read mode, FileOutputStream - Selenium class opens file in write mode,
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/TestData/SpiceClub.xlsx"); // May arise cross platform Issues due to hard code file seperaters. Windows uses backslashes (\) as a file separator.Mac and Linux use forward slashes (/).
	
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("SignUp");
		
		int lastRowNumber = sheet.getLastRowNum();
		int lastCellNumber = sheet.getRow(0).getLastCellNum(); // Last Cell Number of Row[1] in Sheet "SignUP' 
		
		System.out.println("Number of Rows ==> "+lastRowNumber); // As per Excell, Rows are counted from 0. If Total rows count shows 5 means, Total 6 rows(1 <th>, 5 <tr>s)
		System.out.println("Number of Cells ==> "+lastCellNumber); // As per Excell, Cells are counted from 1 , I.e If Total columns count shows 5 means, A,B,C,D,E
	
		//Get data from cells
		// As per Excell, Rows are counted from 0, Cell are counted from 1, but as per Java, both Rows and  Cell are counted from 0, That's why the difference of condition (I.e "<=" for row, "<" for columns) counts in the for loop 
		//Use classic for {} loops to deel with index, Enhanced for {} loops to deal with collection types, set, list, hashmaps..etc
		for (int r=0; r <= lastRowNumber; r++) {
			XSSFRow row = sheet.getRow(r);
			for(int c=0; c<lastCellNumber; c++) {
			XSSFCell cell =	row.getCell(c);
			String valCell = cell.toString();
			System.out.print(valCell+"\t");
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
	}

}
