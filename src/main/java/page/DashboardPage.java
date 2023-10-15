package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage extends BasePage{
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//element
	@FindBy(how = How.CSS, using = ".loader-overlay.loaded") WebElement LOADER_ELEMENT;
	@FindBy(how = How.CSS, using = "//*[@id=\"summary\"]") WebElement PROFILE_VALIDATION_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]") WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement ADD_CUSTOMER_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement LIST_CUSTOMER_MENU_ELEMENT;
	
	//Intractable methods
	public void verifyDashboardPage(String dashboard) {
		verifyElemnt(DASHBOARD_HEADER_ELEMENT, dashboard, "Dashboard page not found.");
	}

	public void clickOnCustomerMenuButton() throws InterruptedException {
//		waitForElement(driver, 5, LOADER_ELEMENT);
		Thread.sleep(2000);
		CUSTOMER_MENU_ELEMENT.click();
	}
	
	public void clickOnAddCustomerMenuButton() {
		ADD_CUSTOMER_MENU_ELEMENT.click();
	}
	
	public void clickOnListCustomerMenuButton() throws InterruptedException {
//		Thread.sleep(5000);
		waitForElement(driver, 5, LOADER_ELEMENT);
		LIST_CUSTOMER_MENU_ELEMENT.click();
	}
	
	public void validateProfilePage() {
		Assert.assertTrue(PROFILE_VALIDATION_ELEMENT.isDisplayed(), "Profile page is not available");
	}
	
	

}
