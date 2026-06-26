package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtills {

	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	String path;
	public ExcelUtills(String path){
		this.path = path;
	}
	
// * NOTE: If you prefer not to use a constructor to initialize the file path, you can use this alternative static method by explicitly passing the Excel file path ('xlfile') as a parameter.
		
//	public static int getRowCount(String xlfile, String sheet) throws IOException {}
		 
	
		public int getRowCount(String sheet) throws IOException{
		
		fis =new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		worksheet = workbook.getSheet(sheet);
		int rowcount =worksheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
	
	}

	public int getCellCount(String sheet, int rownum) throws IOException{
		
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		worksheet= workbook.getSheet(sheet);
		row = worksheet.getRow(rownum);
		int columncount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return columncount;

	}
	
	
	public String getCellData(String sheet, int rownum, int celnum) throws IOException{
		
		fis = new FileInputStream(path);
		workbook =new XSSFWorkbook(fis);
		worksheet = workbook.getSheet(sheet);
		row= worksheet.getRow(rownum);
		cell = row.getCell(celnum);
		DataFormatter formatter = new DataFormatter();
		
		String data;
		
		data = formatter.formatCellValue(cell);
		workbook.close();
		fis.close();
		return data;	
	
	}

	
	/*
	 * NOTE: If you prefer not to use a constructor to initialize the file path, you can use this alternative static method by explicitly passing the Excel file path ('xlfile') as a parameter.
	
		public static int getRowCount(String xlfile, String sheet) throws IOException {
	
		fis = new FileInputStream(xlfile);
	
		
		workbook =new XSSFWorkbook(fis);
		
		worksheet = workbook.getSheet(sheet);
		
		int rowcount = worksheet.getLastRowNum();
		
		workbook.close();
		
		fis.close();
		
		return rowcount;

	}
	

	public static int getCellCount(String xlfile, String sheet, int rownum) throws IOException{
		
		fis = new FileInputStream(xlfile);
		
		workbook = new XSSFWorkbook(fis);
		
		worksheet = workbook.getSheet(sheet);
		
		int columncount = worksheet.getRow(rownum).getLastCellNum();
		
		workbook.close();
		
		fis.close();
		
		return columncount;
		
	}
	
	public static String getCellData(String xlfile, String sheet, int rownum, int celnum) throws IOException{
		
		fis = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fis);
		worksheet = workbook.getSheet(sheet);
		row = worksheet.getRow(rownum);
		cell = row.getCell(celnum);
		String data;
		//data = cell.toString();
		DataFormatter formatter = new DataFormatter();
		data = formatter.formatCellValue(cell);
		workbook.close();
		fis.close();
		return data;
	}
	 */
	

	/*
	public class ExcelUtils {
		
		//Create a constructor with the same class name, when ever wants to use methods of the class, pass the parameter, say file and start use of methods
		public ExcelUtils(file){
			this.file = file;
		}
		
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
	*/
	}
	

