package com.playwright.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet excelSheet;
	private static XSSFWorkbook excelWorkbook;
	private static XSSFCell cell;
	private static XSSFRow row;
	private static String sheetPath = System.getProperty("user.dir")+"\\Data\\OlympicTestdata.xlsx";
	private static String sheetName = "AgentDetails";
	//private static final Logger LOG = LogManager.getLogger(ExcelUtils.class);

	public static void setExcelFile() throws IOException {
			//LOG.info("Getting sheets from the workbook.");
			FileInputStream excelFile = new FileInputStream(new File(sheetPath).getAbsolutePath());
			excelWorkbook = new XSSFWorkbook(excelFile);
			excelSheet = excelWorkbook.getSheet(sheetName);
	}

	private static int getDataRow(String dataKey, int dataColumn) {
		int rowCount = excelSheet.getLastRowNum();
		for(int row=0; row<= rowCount; row++){
			if(ExcelUtils.getCellData(row, dataColumn).equalsIgnoreCase(dataKey)){
				return row;
			}
		}
		return 0;		
	}

	private static String getCellData(int rowNumb, int colNumb) {
		cell = excelSheet.getRow(rowNumb).getCell(colNumb);
		//LOG.info("Getting cell data.");
		if(cell.getCellType() == CellType.NUMERIC) {
			cell.setCellType(CellType.STRING);
		}
		String cellData = cell.getStringCellValue();
		return cellData;
	}

	public static void setCellData(String result, int rowNumb, int colNumb, String sheetPath,String sheetName) throws Exception{
		try{
			
			sheetPath = System.getProperty("user.dir")+"\\Data\\AgentDetails.xlsx";
			 //sheetName = "AgentDetails";
				FileInputStream excelFile = new FileInputStream(new File(sheetPath));
				excelWorkbook = new XSSFWorkbook(excelFile);
				excelSheet = excelWorkbook.getSheetAt(0);
			row = excelSheet.getRow(rowNumb);
			cell = row.getCell(colNumb);
			//LOG.info("Setting results into the excel sheet.");
			if(cell==null){
				cell = row.createCell(colNumb);
				cell.setCellValue(result);
			}
			else{
				cell.setCellValue(result);
			}

			//LOG.info("Creating file output stream.");
			//FileOutputStream fileOut = new FileOutputStream(sheetPath + sheetName);
			FileOutputStream fileOut = new FileOutputStream(sheetPath);
			excelWorkbook.write(fileOut);
			fileOut.flush();
			fileOut.close();

		}catch(Exception exp){
			//LOG.info("Exception occured in setCellData: "+exp);
			System.out.println("Exception occured in setCellData: "+exp);
		}
	}

	public static Map getData(String dataKey) throws Exception {
		Map dataMap = new HashMap<String, String>();
			setExcelFile();
			int dataRow = getDataRow(dataKey.trim(), 0);
			//LOG.info("Test Data Found in Row: "+dataRow);
			if (dataRow == 0) {
				throw new Exception("NO DATA FOUND for dataKey: "+dataKey);
			}
			int columnCount = excelSheet.getRow(dataRow).getLastCellNum();
			for(int i=0;i<columnCount;i++) {
				cell = excelSheet.getRow(dataRow).getCell(i);
				String cellData = null; 
				if (cell != null) {
					if(cell.getCellType() == CellType.NUMERIC) {
						cell.setCellType(CellType.STRING);
					}
					cellData = cell.getStringCellValue();
				}
				dataMap.put(excelSheet.getRow(0).getCell(i).getStringCellValue(), cellData);
			}
		return dataMap;
	}

	public static void main(String []args) throws Exception {
		Map<String,String> dataMap = new HashMap<String, String>();
		ArrayList<String> list = new <String>ArrayList(Arrays.asList("Bamboo Watch","Black Watch","Blue Band"));
		for(int i=0;i<list.size();i++)
		{
				dataMap = getData(list.get(i));
				for(Map.Entry<String, String> data: dataMap.entrySet()) {
					//LOG.info(data.getKey()+ " ==> " + data.getValue());
					System.out.println(data.getKey()+ " ==> " + data.getValue());
			}
		}
	}
}
