package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;

//import org.junit.Test;

import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;
	
	//login data	
	String userName = "demo@techfios.com";
	String password = "abc123";
	
	//Test data
	String fullName ="Java Selenium";
	String company = "Amazon";
	String email = "abc@techfios.com";
	String phoneNum = "123456 ";
	/*
	 * String address; String city; String state; String zip; String country;
	 */
	
	@Test
	public void validUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.inserUserName(userName);
		loginPage.inserPassword(password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver,DashboardPage.class );
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver,AddCustomerPage.class );
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phoneNum);
		/*
		 * addCustomerPage.insertAddress(address); addCustomerPage.insertCity(city);
		 * addCustomerPage.insertState(state); addCustomerPage.insertZip(zip);
		 * addCustomerPage.selectCountryDropdown(country);
		 */
		
		
		//BrowserFactory.tearDown();
	
	}
		
}
