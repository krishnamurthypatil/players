package AllPages;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {

	public  WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
 
String browserName="chrome";
System.out.println(browserName);

if (browserName.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", "/Users/krishnamurthypatil/Documents/chromedriver"); //System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver");
	driver = new ChromeDriver();
	
}
else if (browserName.equals("firefox"))
{
	 //driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}

}
