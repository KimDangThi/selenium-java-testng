package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_CustomDropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_JQuery() {
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		
		SelectDroplist("span#speed-button", "ul#speed-menu div[role=\"option\"]", "Medium");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(), "Medium");

		SelectDroplist("span#speed-button", "ul#speed-menu div[role=\"option\"]", "Slower");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(), "Slower");
		
		SelectDroplist("span#speed-button", "ul#speed-menu div[role=\"option\"]", "Faster");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button span.ui-selectmenu-text")).getText(), "Faster");
	}
	
	@Test
	public void TC_02_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		SelectDroplist("div[role=\"listbox\"]", "span.text", "Elliot Fu");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div[role=\"listbox\"] div")).getText(), "Elliot Fu");

		SelectDroplist("div[role=\"listbox\"]", "span.text", "Matt");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div[role=\"listbox\"] div")).getText(), "Matt");
	}

	@Test
	public void TC_03_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		SelectDroplist("div.btn-group", "ul.dropdown-menu a", "Second Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.btn-group>li")).getText().trim(), "Second Option");

		SelectDroplist("div.btn-group", "ul.dropdown-menu a", "First Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.btn-group>li")).getText().trim(), "First Option");
	}
	
	@Test
	public void TC_04_Editable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		
		SelectDroplist("input.search", "div[role=\"option\"] span", "Angola");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div[aria-atomic=\"true\"]")).getText(), "Angola");

		SelectDroplist("input.search", "div[role=\"option\"] span", "Bangladesh");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div[aria-atomic=\"true\"]")).getText(), "Bangladesh");
	}
	
	public void SelectDroplist(String parentList, String item, String ExpectedText) {
	
		driver.findElement(By.cssSelector(parentList)).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(parentList)));
		
		List<WebElement> SpeedDropdownlist =driver.findElements(By.cssSelector(item));
		for (WebElement temptItem : SpeedDropdownlist) {
			String itemText = temptItem.getText();
			if (itemText.equals(ExpectedText)){
				temptItem.click();
			}
			
		}
	}

	public void EditableDroplist(String parentList, String item, String ExpectedText) {
		
		driver.findElement(By.cssSelector(parentList)).clear();
		driver.findElement(By.cssSelector(parentList)).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(parentList)));
		
		driver.findElement(By.cssSelector(parentList)).sendKeys("ang");
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(parentList)));
		
		List<WebElement> SpeedDropdownlist =driver.findElements(By.cssSelector(item));
		for (WebElement temptItem : SpeedDropdownlist) {
			String itemText = temptItem.getText();
			if (itemText.equals(ExpectedText)){
				temptItem.click();
			}
			
		}
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}