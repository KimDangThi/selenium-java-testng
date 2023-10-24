package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_DropdownList {
	WebDriver driver;
	Random rand;
	Select select;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String FirstName, LastName, Email, CompanyName, Password;
	
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
		
		FirstName = "Kim";
		LastName = "Dang";
		Email = FirstName+ LastName+ rand.nextInt(999) + "@gmail.com";
		CompanyName = "VTIGroup";
		Password = "Dangkim123@";
	}
	@Test
	public void TC_04_Register() {
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.name("FirstName")).sendKeys(FirstName);
		driver.findElement(By.name("LastName")).sendKeys(LastName);
		driver.findElement(By.name("Email")).sendKeys(Email);
		driver.findElement(By.name("Company")).sendKeys(CompanyName);
		driver.findElement(By.name("Password")).sendKeys(Password);
		driver.findElement(By.name("ConfirmPassword")).sendKeys(Password);
		
		
		Select Day = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Select Month =new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Select Year= new Select(driver.findElement(By.name("DateOfBirthYear")));
		
		Assert.assertEquals(32, Day.getOptions().size());
		Assert.assertEquals(13, Month.getOptions().size());
		Assert.assertEquals(112, Year.getOptions().size());
		
		Day.selectByVisibleText("1");
		Month.selectByVisibleText("May");
		Year.selectByVisibleText("1980");
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		
		driver.findElement(By.xpath("//a[text()='My account']")).click();
	
		driver.findElement(By.name("Email")).sendKeys(Email);
		driver.findElement(By.name("Password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Assert.assertEquals(driver.findElement(By.name("FirstName")).getAttribute("value"), FirstName);
		Assert.assertEquals(driver.findElement(By.name("LastName")).getAttribute("value"), LastName);
		
		//chỗ này không dùng biến day,month,year bên trên được vì đã chuyển sang trang mới => Đoạn đặt biến Day,month,year bên trên không cần thiết
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), "1");
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), "May");
		Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), "1980");
		Assert.assertEquals(driver.findElement(By.name("Email")).getAttribute("value"), Email);
		Assert.assertEquals(driver.findElement(By.name("Company")).getAttribute("value"), CompanyName);
	}
	

	@Test
	public void TC_05_Add_Address() {
		driver.findElement(By.cssSelector("li.customer-addresses>a")).click();
		driver.findElement(By.xpath("//button[text()='Add new']")).click();
		
		driver.findElement(By.name("Address.FirstName")).sendKeys(FirstName);
		driver.findElement(By.name("Address.LastName")).sendKeys(LastName);
		driver.findElement(By.name("Address.Email")).sendKeys(Email);
		driver.findElement(By.name("Address.Company")).sendKeys(CompanyName);
		new Select(driver.findElement(By.name("Address.CountryId"))).selectByVisibleText("United States");
		new Select(driver.findElement(By.name("Address.StateProvinceId"))).selectByVisibleText("California");
		driver.findElement(By.name("Address.City")).sendKeys("Miami");
		driver.findElement(By.name("Address.Address1")).sendKeys("25 PO");
		driver.findElement(By.name("Address.ZipPostalCode")).sendKeys("100000");
		driver.findElement(By.name("Address.PhoneNumber")).sendKeys("+1358914898");
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();	
		
		//Verify
		Assert.assertEquals(driver.findElement(By.cssSelector("li.name")).getText(), FirstName + " "+ LastName);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.email")).getText().contains(Email));
		Assert.assertTrue(driver.findElement(By.cssSelector("li.phone")).getText().contains("+1358914898"));
		Assert.assertEquals(driver.findElement(By.cssSelector("li.company")).getText(),CompanyName);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.address1")).getText(),"25 PO");
		Assert.assertTrue(driver.findElement(By.cssSelector("li.city-state-zip")).getText().contains("Miami"));
		Assert.assertTrue(driver.findElement(By.cssSelector("li.city-state-zip")).getText().contains("California"));
		Assert.assertTrue(driver.findElement(By.cssSelector("li.city-state-zip")).getText().contains("100000"));
		Assert.assertEquals(driver.findElement(By.cssSelector("li.country")).getText(),"United States");
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