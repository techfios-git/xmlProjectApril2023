package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	
	WebDriver driver;
	
	String userName;
	String password;
	String dashboardHeader;
	
	
	@Test
	@Parameters({"userName", "password", "dashboardHeader"})
	public void validUserShouldBeAbleToLogin(String username, String password, String dashboardHeader) {
		
		driver = BrowserFactory.setup();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(username);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage(dashboardHeader);
		BrowserFactory.tearDown();
		
	}

}
