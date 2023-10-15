package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ListCustomerPage extends BasePage{

	WebDriver driver;

	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// element
	@FindBy(how = How.CSS, using = ".loader-overlay.loaded") WebElement LOADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]")
	WebElement ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='foo_filter']") WebElement SEARCH_BAR_LIST_CUSTOMER_ELEMENT;
	
	public void validateListCustomerPage() {
		Assert.assertTrue(ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT.isDisplayed(), "List Customer Page is not avaiable.");
	}
	
	public void clickOnAddCustomerOnListCustomer() throws InterruptedException {
//		Thread.sleep(1000);
		
		waitForElement(driver, 5, LOADER_ELEMENT);
		ADD_CUSTOMER_ON_LIST_CUSTOMER_ELEMENT.click();
	}
	
	public void insertNameOnSearchBar() {
		SEARCH_BAR_LIST_CUSTOMER_ELEMENT.sendKeys(AddCustomerPage.getInsertedName());
	}

	

}
