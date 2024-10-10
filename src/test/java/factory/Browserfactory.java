package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserfactory {
  public static WebDriver StartBrowser(String browser, String url)
  {
	  WebDriver driver=null;
	
if(browser.equalsIgnoreCase("chrome"))
{
	  WebDriverManager.chromedriver().setup();
	ChromeOptions opt=new ChromeOptions();
		opt.addArguments("start-maximized");
		driver= new ChromeDriver(opt);
		 driver.get(url);
		
}
else if(browser.equalsIgnoreCase("ie"))
{
	  WebDriverManager.iedriver().setup();
	  driver=new InternetExplorerDriver();
	  
}
	 return driver; 
  }

public static void CloseBrowser(WebDriver driver) {
	// TODO Auto-generated method stub
	driver.close();
}
}
