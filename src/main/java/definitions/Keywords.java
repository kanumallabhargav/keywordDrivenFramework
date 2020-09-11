package definitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Keywords 
{
	WebDriver driver;
	
	//GetURL
	public void enterURL(WebDriver driver, String url)
	{
		driver.get(url);
	}
	
	//Get current URL
	public String get_currentURL(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	//Get Title
	public void getTitle(WebDriver driver)
	{
		driver.getTitle();
	}
	
	//AssertEquals
	public void assertEquals(String actualValue, String expectedValue)
	{
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	//AssertContains
	public void assertContains(String partialValue, String completeValue)
	{
		Assert.assertTrue(completeValue.contains(partialValue));
	}
	
	//Click
	public void click(WebDriver driver, String locatorType, String currentURL, String homeURL, String checkoutURL, String objectName) throws IOException
	{
		driver.findElement(LocatorFramer.getObject(driver, locatorType, currentURL, homeURL, checkoutURL, objectName)).click();
	}
	
	//Assertion
	public void assertElement(String assertionType, WebDriver driver, String locatorType, String currentURL, String homeURL, String checkoutURL, String objectName) throws IOException
	{
		switch (assertionType)
		{
			case "displayed":
			{
				Assert.assertEquals(true, driver.findElement(LocatorFramer.getObject(driver, locatorType, currentURL, homeURL, checkoutURL, objectName)).isDisplayed());
			}
			case "enabled":
			{
				Assert.assertEquals(true, driver.findElement(LocatorFramer.getObject(driver, locatorType, currentURL, homeURL, checkoutURL, objectName)).isEnabled());
			}
			case "selected":
			{
				Assert.assertEquals(true, driver.findElement(LocatorFramer.getObject(driver, locatorType, currentURL, homeURL, checkoutURL, objectName)).isSelected());
			}
		}
	}
	
	//Type
	public void type(WebDriver driver, String locatorType, String currentURL, String homeURL, String checkoutURL, String objectName, String testData) throws IOException
	{
		driver.findElement(LocatorFramer.getObject(driver, locatorType, currentURL, homeURL, checkoutURL, objectName)).sendKeys(testData);
	}
	
	//Hit enter
	public void hitEnter(WebDriver driver, String locatorType, String currentURL, String homeURL, String checkoutURL, String objectName) throws IOException
	{
		driver.findElement(LocatorFramer.getObject(driver, locatorType, currentURL, homeURL, checkoutURL, objectName)).sendKeys(Keys.ENTER);
	}
	
	//Implicit wait
	public void implicitWait(WebDriver driver, int testData)
	{
		driver.manage().timeouts().implicitlyWait(testData, TimeUnit.SECONDS);
	}
}
