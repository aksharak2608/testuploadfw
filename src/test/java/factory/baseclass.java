package factory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utility.util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class baseclass {
	
	public static ExtentHtmlReporter html;
	public static ExtentReports reports;
	public static ExtentTest logger;
	public static WebDriver driver;
	
	//this is before suite
	@BeforeSuite
	public void statusReports()
	{
		System.out.println("Starting the suite");
		String formate=util.DateToString();
		 html= new ExtentHtmlReporter(System.getProperty("user.dir")+"\\reports\\"+formate+"Extent.html");
		 reports = new ExtentReports();
		 reports.attachReporter(html);
		 System.out.println("reporting variables created");
			
	}
	@AfterMethod
	public void output(ITestResult result) 
	{
		int status=result.getStatus();
		if(status==ITestResult.SUCCESS)
		{
			try {
				logger.log(Status.PASS, "Test Passes",MediaEntityBuilder.createScreenCaptureFromPath(util.screenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(status==ITestResult.FAILURE)
		{
			try {
				logger.log(Status.FAIL, "Test Failed",MediaEntityBuilder.createScreenCaptureFromBase64String(util.screenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//;
		}
		else if(status==ITestResult.SKIP)
		{
			logger.log(Status.SKIP, "Test Passes");
		}
			reports.flush();
	}
	
	@BeforeClass
	public void startSession()
	{
		System.out.println("retriving the browser type and url");
		String browser=Dataprovider.readconfig("browser");
		String url=Dataprovider.readconfig("url");
		driver=Browserfactory.StartBrowser(browser, url);
		
	}
	
	
	@AfterClass
	public void endSession()
	{
		
		Browserfactory.CloseBrowser(driver);
		
	}
}
