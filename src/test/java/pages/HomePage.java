package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utility.util;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a/span[text()='My Info']")WebElement myinfo;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void clickonMyInfo()
	{
		util.waitforelementWE(driver, myinfo);
		myinfo.click();
	}
	
	 public void verify_Myinfopage()
	 {
		 Assert.assertTrue( driver.getCurrentUrl().contains("viewPersonalDetails"));
		
	 }
}
