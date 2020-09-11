package definitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorFramer
{
	public static By getObject(WebDriver driver, String locatorType, String currentURL, String homeURL, String checkoutURL, String objectName) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = null;
		if(currentURL.equals(homeURL))
			 fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/pageObjects/homePageObjects.properties");
		else if(currentURL.equals(checkoutURL))
			 fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/pageObjects/checkoutPageObjects.properties");
			prop.load(fis);
			String locatorProperty = objectName+locatorType;
			String locatorValue = prop.getProperty(locatorProperty);
		 
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			return By.xpath(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("css"))
		{
			return By.cssSelector(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("id"))
		{
			return By.id(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("linkText"))
		{
			return By.linkText(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			return By.partialLinkText(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("className"))
		{
			return By.className(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("tagName"))
		{
			return By.tagName(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("name"))
		{
			return By.name(locatorValue);
		}
		else
		{
			return null;
		}
			
	}
}
