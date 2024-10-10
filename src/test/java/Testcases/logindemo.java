package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factory.Dataprovider;
import factory.baseclass;
import pages.Login_page;
import utility.util;

public class logindemo extends baseclass {
	//WebDriver driver;
	@Test
	public void test()
	{
		logger=reports.createTest("Valid login validation");
		Login_page login= PageFactory.initElements(driver, Login_page.class);
		String usernamevalue=Dataprovider.exceldata("usercredentials", 1, 0);
		login.enterusername( usernamevalue);
		String passwordvalue=Dataprovider.exceldata("usercredentials", 1, 1);
		login.enterpassword(passwordvalue);
		login.clickLogin();
		login.verify_homepage();
		login.logout();
	}
	@Test
	public void test2()
	{
		//driver=util.launchbrowser("https://opensource-demo.orangehrmlive.com/auth/login");
		//"https://demo.guru99.com/test/newtours/index.php");
		//Login_page login=new Login_page(driver);
		logger=reports.createTest("Inalid login validation");
		Login_page login= PageFactory.initElements(driver, Login_page.class);
		String usernamevalue=Dataprovider.exceldata("usercredentials", 2, 0);
		login.enterusername( usernamevalue);
		String passwordvalue=Dataprovider.exceldata("usercredentials", 2, 1);
		login.enterpassword(passwordvalue);
		login.clickLogin();
		login.verify_unsucessfull_login();
	}
	
	
	
	
	
	
	
}
