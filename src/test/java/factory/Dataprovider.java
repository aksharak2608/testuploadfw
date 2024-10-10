package factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataprovider {
	public static  String readconfig(String input)
	{
		Properties pro=new Properties();
		String p = null;
		try {
			
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\Testdata\\Config.properties")));
			
			 p=(String) pro.get(input);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  p;
	}
	
	
	public static String exceldata(String sheetname, int rowno, int colno)
	{String result = null;
		File src= new File(System.getProperty("user.dir")+"\\Testdata\\datainput.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sh= wb.getSheet(sheetname);
			XSSFRow row=sh.getRow(rowno);
			XSSFCell cell=row.getCell(colno);
			
			if(cell.getCellType() == CellType.STRING)
			{
			System.out.println(cell.getStringCellValue());
			result=cell.getStringCellValue();
			}
			if(cell.getCellType() == CellType.NUMERIC)
			{
			System.out.println(cell.getNumericCellValue());
			result= String.valueOf(cell.getNumericCellValue());
			}
			
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		return result; }
}
	

