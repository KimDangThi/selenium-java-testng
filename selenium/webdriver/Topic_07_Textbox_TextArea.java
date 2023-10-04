package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Textbox_TextArea {
	WebDriver driver;
	Random rand;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String fullname, Firstname, lastname, emailaddress, password, confirmpassword;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		rand = new Random();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		Firstname = "Kim";
		lastname = "DangThi";
		fullname = Firstname + " " + lastname;
		password = "123456789";
		emailaddress = "automation" + rand.nextInt(9999) + "@gmail.com";
		
	}

	@Test
	public void TC_01_Textbox() {
		driver.get("http://live.techpanda.org/");
		sleepInSecond(1);
		
		driver.findElement(By.cssSelector("div.footer a[title='My Account']")).click();
		sleepInSecond(1);
		
		driver.findElement(By.cssSelector("form#login-form a[title='Create an Account']")).click();
		
		driver.findElement(By.cssSelector("input#firstname")).sendKeys(Firstname);
		driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastname);
		driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailaddress);
		driver.findElement(By.cssSelector("input#password")).sendKeys(password);
		driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
		driver.findElement(By.cssSelector("button[title='Register']")).click();
		sleepInSecond(2);
		
		Assert.assertEquals("driver.findElement(By.cssSelector(\"li.success-msg span\")).getText()", "Thank you for registering with Main Website Store");
		
		Assert.assertTrue("driver.findElement(By.xpath(\"//h3[text()='Contact Information']/parent::div/following-sibling::div/p\")).getText()".contains(fullname));
		
		Assert.assertTrue("driver.findElement(By.xpath(\"//h3[text()='Contact Information']/parent::div/following-sibling::div/p\")).getText()".contains(emailaddress));	
				
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']// span[text()='Account']")).click();
		
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
	
	}
	

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_() {
		
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