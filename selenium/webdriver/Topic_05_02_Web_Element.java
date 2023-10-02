package webdriver;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_02_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	By Email = By.id("mail");
	By Edu = By.id("edu");
	By Age = By.id("under_18");
	By User5 = By.xpath("//h5[text()='Name: User5']");
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TC_01_Display() {	
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		if(driver.findElement(Email).isDisplayed()) {
			driver.findElement(Email).sendKeys("Selenium WebDriver");
			System.out.println("Email Textbox is Displayed");
			} else {
				System.out.println("Email Textbox is not Displayed");
			}
		
		
		if(driver.findElement(Edu).isDisplayed()) {
			driver.findElement(Edu).sendKeys("Selenium Grid");
			System.out.println("Education Textbox is Displayed");
			} else {
				System.out.println("Education Textbox is not Displayed");
			}
		
		if(driver.findElement(Age).isDisplayed()) {
			driver.findElement(Age).click();
			System.out.println("Age is Displayed");
			} else {
				System.out.println("Age is not Displayed");
			}
		
		if(driver.findElement(User5).isDisplayed()) {
			System.out.println("User5 is Displayed");
		} else {
			System.out.println("User5 is not Displayed");
		}
	}
	
	@Test
	public void TC_02_Enable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		if(driver.findElement(Email).isEnabled()) {
			System.out.println("Email is Enabled");
			} else {
			System.out.println("Email is disabled");
		}
		
		if(driver.findElement(Age).isEnabled()) {
			System.out.println("Age is Enabled");
			} else {
			System.out.println("Age is disabled");
		}
		
		if(driver.findElement(Edu).isEnabled()) {
			System.out.println("Edu is Enabled");
			} else {
			System.out.println("Edu is disabled");
		}
		
		if(driver.findElement(By.id("job1")).isEnabled()) {
			System.out.println("Job1 is Enabled");
			} else {
			System.out.println("Job1 is disabled");
		}
		
		if(driver.findElement(By.id("job2")).isEnabled()) {
			System.out.println("Job2 is Enabled");
			} else {
			System.out.println("Job2 is disabled");
		}
	}
		
	
	@Test
	public void TC_03_Select() {
		
	}
	
	@Test
	public void TC_04_Register_function() {
		
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