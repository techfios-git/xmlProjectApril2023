package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {

	WebDriver driver;


	@Test
	@Parameters({"userName", "password", "dashboardHeader", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State", "Zip", "Country", "AddContactValidationText" })
	public void userShouldBeAbleToAddCustomer(String username, String password, String dashboardHeader, String fullName, String company, String email, String phone, String address, String city, String state, String zip, String country, String addCustomerHeader) throws InterruptedException {

		driver = BrowserFactory.setup();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage(dashboardHeader);
		dashboardPage.clickOnCustomerMenuButton();
		dashboardPage.clickOnAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddCustomerPage(addCustomerHeader);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertCompany(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.insertCountry(country);
		addCustomerPage.clickSaveButton();
		
		dashboardPage.clickOnListCustomerMenuButton();
		
		addCustomerPage.validateInsertedNameAndDelete();
	}

}
