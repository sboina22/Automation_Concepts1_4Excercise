package excercise;

import java.io.IOException;

import Utilities.ExcelUtills;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		ExcelUtills excelUtils = new ExcelUtills(System.getProperty("user.dir")+"/TestData/SpiceClub.xlsx");
		
		int totalrows= excelUtils.getRowCount("SignUp");
		System.out.println("Total rows ==>  "+totalrows);
		
		int totalcolumns =	excelUtils.getCellCount("SignUp", 0);
		System.out.println("Total columns in row 0 ==>  "+totalcolumns);
		
		String celldata = excelUtils.getCellData("SignUp", 1, 1);
		System.out.println("Cell Data in  1,1  ==>  "+celldata);

	}
}
