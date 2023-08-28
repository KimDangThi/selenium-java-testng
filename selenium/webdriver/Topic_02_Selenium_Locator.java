package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Open Register
		driver.get("https://demo.nopcommerce.com/register")	
	}

	// Code HTML của FirstName Textbox
	//<input type="text" data-val="true" 
	//data-val-required="First name is required." id="FirstName" name="FirstName">
	
	
	//Tên thẻ của element (Tagname HTML): input
	//Tên thuộc tính (Attribute name):          type, data-val, data-val-required      , id       , name
	//Giá trị của thuộc tính (Attribute value): text, true    , First name is required., FirstName, FirstName
	
	@Test
	public void TC_01_ID() {
		driver.findElement(By.);
	}
	

	@Test
	public void TC_02_Class() {
		
	}

	@Test
	public void TC_03_Name() {
		
	}
	@Test
	public void TC_04_TagName() {
	}
	

	@Test
	public void TC_05_LinkText() {
		
	}

	@Test
	public void TC_06_ParialLinkText() {
		
	}	
	
	@Test
	public void TC_07_Css() {
	}
	

	@Test
	public void TC_08_XPath() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}