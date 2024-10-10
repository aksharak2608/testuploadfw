package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import factory.Dataprovider;
import factory.baseclass;
import pages.HomePage;
import pages.Login_page;
import utility.util;

public class homepagetest extends baseclass {
	//WebDriver driver;
	@Test
	public void test()
	{
		logger=reports.createTest("Homepage validation");
		Login_page login= PageFactory.initElements(driver, Login_page.class);
		String usernamevalue=Dataprovider.exceldata("usercredentials", 1, 0);
		login.enterusername( usernamevalue);
		String passwordvalue=Dataprovider.exceldata("usercredentials", 1, 1);
		login.enterpassword(passwordvalue);
		login.clickLogin();
		login.verify_homepage();
		HomePage Hp= PageFactory.initElements(driver, HomePage.class);
		Hp.clickonMyInfo();
		Hp.verify_Myinfopage();
		
	}

	
	
	
	
	
	
	
}
