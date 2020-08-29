package excelReaders;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GreenKart_TC_reader 
{
	public void gc_tcReader() throws IOException
	{
		FileInputStream gc_tcFile = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/excelFiles/GreenKart_TC.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(gc_tcFile);
		
		int sheetCount = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheetCount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TC_1_Verify_title"))
			{
				
			}
		}
	}
}
