package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	
	public int generateRandomNum(int boundryNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundryNum);
		return generatedNum;
	}
	
	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public void verifyElemnt(WebElement element, String expectedText, String errorMsg) {
		Assert.assertEquals(element.getText(), expectedText, errorMsg);
	}
	
	public void waitForElement(WebDriver driver, int timeInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}


}
