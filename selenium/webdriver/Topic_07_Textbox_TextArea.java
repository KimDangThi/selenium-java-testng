package webdriver;

import static org.testng.Assert.assertEquals;

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
	String fullname, Firstname, lastname, emailaddress, password, confirmpassword, number, user;
	
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
		
		Firstname = "Kim";
		lastname = "DangThi";
		fullname = Firstname + " " + lastname;
		user = "user12";
		password = "abc12345";
		emailaddress = "automation" + rand.nextInt(9999) + "@gmail.com";
		number = String.valueOf(rand.nextInt(99999999));
	}

	//@Test
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
		
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText().contains(fullname));
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText().contains(emailaddress));	
				
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']// span[text()='Account']")).click();
		
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'logo.png')]")).isDisplayed());
	}
	

	@Test
	public void TC_02_() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		sleepInSecond(3);
		//step5
		driver.findElement(By.name("firstName")).sendKeys(Firstname);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		
		String EmployeeId = driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).getAttribute("value");
		
		driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div//span")).click();
		
		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(user);
		driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
		driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		//step7 -verify firstname, lastname, emmployID
		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), Firstname);
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), lastname);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),EmployeeId);
		//step8
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button")).click();
		
		driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(number);
		driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys("My name's Kim\n Dang");
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		
		//step11
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']")).click();
		
		//step12- verify number, comment
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), number);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), "My name's Kim\n Dang");
		
		//step14 logout
		driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		sleepInSecond(2);
		
		//step 15 nhập lại thông tin ở step5
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		sleepInSecond(5);
		
		//step 16 vào màn hình My Info
		//step 17 verify firstname, lastname
		//step 18 vaof màn hình immigration, chọn edit
		//step 19 verìy lại  number và comment
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
		//driver.quit();
	}
}