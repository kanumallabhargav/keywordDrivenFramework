package excelReaderHelpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import excelReaders.GreenKart_TC_reader;

public class GreenKart_TC_reader_helper 
{	
	public static ArrayList<String> getValueFromFile() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/gk_tcReaderConfig.properties");
		prop.load(fis);
		ArrayList<String> list = new ArrayList<String>();
		list.add(prop.getProperty("stepName1"));
		list.add(prop.getProperty("stepName2"));
		list.add(prop.getProperty("stepName3"));
		return list;
	}

	public String getFirstRow(String requiredField, String stepName) throws IOException
	{
		ArrayList<String> list2 = getValueFromFile();
		String stepName1 = list2.get(0);
		String stepName2 = list2.get(1);
		String stepName3 = list2.get(2);
		String cellValue;
		if(stepName.equalsIgnoreCase(stepName1))
		{
			cellValue = splitList(requiredField, stepName1);
			return cellValue;
		}
		else if(stepName.equalsIgnoreCase(stepName2))
		{
			cellValue = splitList(requiredField, stepName2);
			return cellValue;
		}
		else if(stepName.equalsIgnoreCase(stepName3))
		{
			cellValue = splitList(requiredField, stepName3);
			return cellValue;
		}
		return null;
	}
	public static String splitList(String requiredField, String stepName) throws IOException
	{
		ArrayList<String> firstRowList = GreenKart_TC_reader.gc_tcReader(stepName);
		String testSteps = firstRowList.get(0);
		String objectName = firstRowList.get(1);
		String locatorType = firstRowList.get(2);
		String testData = firstRowList.get(3);
		String assertionType = firstRowList.get(4);
		String expectedValue = firstRowList.get(5);
		String actualValue = firstRowList.get(6);

		switch (requiredField)
		{
		case "testSteps":
			return testSteps;
		case "objectName":
			return objectName;
		case "locatorType":
			return locatorType;
		case "testData":
			return testData;
		case "assertionType":
			return assertionType;
		case "expectedValue":
			return expectedValue;
		case "actualValue":
			return actualValue;
		default:
			return null;
		}
	}
}
