package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	WebDriver driver;
	Properties prop = new Properties();
	FileInputStream fis;
	public void driverInitialize() throws IOException
	{
		fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/browserConfig.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		switch (browserName)
		{
		case "chrome":
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver");
			driver = new ChromeDriver();
		}
		case "headlessChrome":
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver");
			ChromeOptions chromeOptionsObject = new ChromeOptions();
			chromeOptionsObject.addArguments("headless");
			driver = new ChromeDriver(chromeOptionsObject);
		}
		case "firefox":
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		}
		driver.manage().window().maximize();
		driver.get("---GET-THIS-FROM-EXCEL-READER-");
	}
}
