package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileHandle {

	
	public static void writeDataInExcel(int i,int j,int k,String str) throws IOException
	{
		
	FileInputStream file=new FileInputStream(".\\Data\\GrowwdTataStock.xlsx");
	
	XSSFWorkbook wb=new XSSFWorkbook(file);
	
	XSSFSheet sh1=wb.getSheetAt(k);
	
	FileOutputStream out= new FileOutputStream(".\\Data\\GrowwdTataStock.xlsx");
	
	sh1.createRow(i).createCell(j).setCellValue(str);
	
	wb.write(out);
	
	out.close();
	
	}
}
