package commons;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.jetty.util.LifeCycleListener;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.DefaultDriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPage {

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}
	
	public void waitForControlVisible(WebDriver driver, String locator) {
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}
	
	public void waitForControlInvisible(WebDriver driver, String locator) {
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
	}
	
	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
return select.getFirstSelectedOption().getText();
		
	}
	
	public int getSizeElement(WebDriver driver, String locator) {

		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}
	
	public void checkToCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		
		if (!element.isSelected()) {
			element.click();
		}
		
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		if (element.isSelected()) {
			element.click();
		}
		
	}
	
	public boolean isControlDisplay(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
	return	element.isDisplayed();
	}
	
	public boolean isControlEnable(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
	return	element.isEnabled();
	}
	
	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
	return	element.isSelected();
	}
	
	public void acceptToAlert(WebDriver driver) {
		Alert  alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	public void cancelToAlert(WebDriver driver) {
		Alert  alert = driver.switchTo().alert();
		alert.dismiss();
		
	}
	
	public void hoverToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
	
	public void uploadFile(WebDriver driver, String fileName) {
		String proDir = System.getProperty("user.dir");

		String filePath = proDir + "\\fileUpload\\" + fileName;
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys(filePath);
	}
	
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	private int timeOut = 30;


	
}
