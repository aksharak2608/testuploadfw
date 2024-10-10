package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class util {
	static WebDriver driver;
	public static WebDriver launchapplication(String url)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\training\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get(url);
		//Thread.sleep(20000);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000));
		
		return driver;
		
	}
	public static WebDriver launchbrowser(String url)
	{
		//WebDriver driver;
		WebDriverManager.chromedriver().setup();

		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("start-maximized");
		driver= new ChromeDriver(opt);
		 driver.get(url);
		 return driver;
	}
	
	public static WebDriver waitforelementBy(WebDriver driver, By ele)
	{
		
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(45));
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		
		return driver;
		
	}
	
	public static WebDriver waitforelementWE(WebDriver driver, WebElement ele)
	{
		
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		return driver;
		
	}
	public static String screenshot(WebDriver driver)
	{
		String formate=util.DateToString();
		TakesScreenshot ts=((TakesScreenshot)driver);
		File src= ts.getScreenshotAs(OutputType.FILE);
		String op_path=System.getProperty("user.dir")+"\\screenshots\\screenshot_"+formate+".png";
		File dest= new File(op_path);
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return op_path;
	} 
	public static String DateToString()
	{
		//Date date=Calendar.getInstance().getTime();
		//DateFormat df= new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		String sdat= new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(Calendar.getInstance().getTime());
			return sdat;
	}

}
