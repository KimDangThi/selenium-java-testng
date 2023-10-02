package webdriver;

import static org.testng.Assert.assertFalse;
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
	By java =By.id("java");
	
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
		
		if(driver.findElement(By.id("development")).isEnabled()) {
			System.out.println("Interests (Development) Checkbox is Enabled");
			} else {
			System.out.println("Interests (Development) Checkbox is disabled");
		}
		
		if(driver.findElement(By.id("slider-1")).isEnabled()) {
			System.out.println("Slider 01 is Enabled");
			} else {
			System.out.println("Slider 01 is disabled");
		}
		
		if(driver.findElement(By.id("disable_password")).isEnabled()) {
			System.out.println("Password is Enabled");
			} else {
			System.out.println("Password is disabled");
		}
		
		if(driver.findElement(By.id("radio-disabled")).isEnabled()) {
			System.out.println("Age Radio button is Enabled");
			} else {
			System.out.println("Age Radio button is disabled");
		}
		
		if(driver.findElement(By.id("bio")).isEnabled()) {
			System.out.println("Biography is Enabled");
			} else {
			System.out.println("Biography is disabled");
		}
		
		
		if(driver.findElement(By.id("job3")).isEnabled()) {
			System.out.println("Job3 is Enabled");
			} else {
			System.out.println("Job3 is disabled");
		}
		
		if(driver.findElement(By.id("check-disbaled")).isEnabled()) {
			System.out.println("Interests checkbox3 is Enabled");
			} else {
			System.out.println("Interests checkbox3 is disabled");
		}
		
		if(driver.findElement(By.id("slider-2")).isEnabled()) {
			System.out.println("Slider 02 is Enabled");
			} else {
			System.out.println("Slider 02 is disabled");
		}
	}
		
	
	@Test
	public void TC_03_Select() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(Age).click();
		driver.findElement(java).click();
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(Age).isSelected());
		Assert.assertTrue(driver.findElement(java).isSelected());
		
		driver.findElement(java).click();
		Assert.assertFalse(driver.findElement(java).isSelected());
	}
	
	@Test
	public void TC_04_Register_Mailchimp() {
		driver.get("https://login.mailchimp.com/signup/");
		
		driver.findElement(By.id("email")).sendKeys("hahahaokiwu@gmail.com");
		
		By PasswordTC4 =By.id("new_password");
		
		driver.findElement(PasswordTC4).sendKeys("abc");
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

		
		driver.findElement(PasswordTC4).clear();
		driver.findElement(PasswordTC4).sendKeys("ABC");
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		driver.findElement(PasswordTC4).clear();
		driver.findElement(PasswordTC4).sendKeys("123");
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());

		
		
		driver.findElement(PasswordTC4).clear();
		driver.findElement(PasswordTC4).sendKeys("%$$");
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		driver.findElement(PasswordTC4).clear();
		driver.findElement(PasswordTC4).sendKeys("123A6&3#$");
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());

		
		
		driver.findElement(PasswordTC4).clear();
		driver.findElement(PasswordTC4).sendKeys("123A6&3#$ab");
		sleepInSecond(3);
		
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
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