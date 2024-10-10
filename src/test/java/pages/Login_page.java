package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import factory.Dataprovider;
import utility.util;

public class Login_page {
	
	@FindBy(xpath="//*[contains(@class,'oxd-input oxd')][@name='username']")
	WebElement Username;
	@FindBy(xpath="//*[contains(@class,'oxd-input oxd')][@name='password']|//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']|//input[@name='submit']")
	WebElement Login_button;
	@FindBy(xpath="//p[text()='Invalid credentials']") WebElement invalidbanner;
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']") WebElement userprofile;

	@FindBy(xpath="//a[text()='Logout']") WebElement logout;
	//p[@class='oxd-userdropdown-name']
	WebDriver driver;
	public Login_page(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void enterusername(String usernamevalue)
	{
		
		driver=util.waitforelementWE(driver, Username);
				
		Username.clear();

		Username.sendKeys(usernamevalue);
	}
	
	public void enterpassword(String passwordvalue)
	{
		driver=util.waitforelementWE(driver, password);
		password.clear();
		
		password.sendKeys(passwordvalue);
	}
	public void clickLogin()
	{
		driver=util.waitforelementWE(driver, Login_button);
		Login_button.click();
	}
	 public void verify_homepage()
	 {
		 Assert.assertTrue( driver.getCurrentUrl().contains("dashboard"));
		
	 } public void verify_unsucessfull_login()
	 {
		util.waitforelementWE(driver, invalidbanner);
		 Assert.assertTrue(invalidbanner.isDisplayed());
		
	 }
	 public void logout()
	 {
		 driver=util.waitforelementWE(driver,userprofile );
		 userprofile.click();
		 driver=util.waitforelementWE(driver,logout );
		 logout.click();
		 Assert.assertTrue( driver.getCurrentUrl().contains("login"));
		 
		
	 }

}
