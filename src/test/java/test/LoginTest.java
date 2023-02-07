package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;

//import org.junit.Test;

import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	
	//login data
	
	String userName = "demo@techfios.com";
	String password = "abc123";
	
	@Test
	public void validUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.inserUserName(userName);
		loginPage.inserPassword(password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver,DashboardPage.class );
		dashboardPage.validateDashboardPage();
		
		BrowserFactory.tearDown();
	
	}
		
}
