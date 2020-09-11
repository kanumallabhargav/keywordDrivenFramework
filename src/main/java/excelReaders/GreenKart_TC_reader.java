package excelReaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GreenKart_TC_reader 
{
	public static ArrayList<String> gc_tcReader(String stepName) throws IOException
	{
		ArrayList<String> list = new ArrayList<String>();
		FileInputStream gc_tcFile = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/excelFiles/GreenKart_TC.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(gc_tcFile);

		int sheetCount = workbook.getNumberOfSheets();

		for(int i=0;i<sheetCount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TC_1_Verify_title"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> ce=firstrow.iterator();
				int col=0, grab=0;
				while (ce.hasNext())
				{
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("testSteps"))
					{
						col=grab;

					}
					grab++;
				}
				while (rows.hasNext())
				{
					Row r = rows.next();
					if(r.getCell(col).getStringCellValue().equals(stepName))
					{
						Iterator<Cell> ci = r.cellIterator();
						while (ci.hasNext())
						{
							list.add(ci.next().getStringCellValue());
						}
					}
				}
			}
		}
		return list;
	}
}
