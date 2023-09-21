package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {
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
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void TC_01_() {
		// Các hàm đóng
		
		driver.close();
		driver.quit();    
		
		// Tìm element
		
		// có thể sd luôn ==== dùng dấu chấm+ action
		//có thể gán cho nó 1 biến để sd sau/sd nhiều lần ==== Bắt đầu bằng WebElement + tên biến
		// Nếu tìm nhiều element thì gán = List<WebElement> + tên biến số nhiều
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='email']"));
		List<WebElement> checkboxes = driver.findElements(By.xpath(osName));
		
		//Mở ra/lấy ra dữ liệu/url...
		//Có nhiều hàm GET để lấy dữ liệu ra======Trừ hàm get ko có j đằng sau, tất cả đều trả về dữ liệu
		driver.get("https://www.facebook.com/");
		
		// trả về URL của page hiện tại
		String VietnamepageURL =  driver.getCurrentUrl();
		
		// trả về source code HTML của page hiện tại === Dùng để Verify tương đối
		driver.getPageSource()
		
		Assert.assertTrue(driver.getPageSource().contains("Kim"));
		
		//trả về title của page hiện tại
		// xem trực tiếp trên Web bằng cách vào tab: Console tìm document.title
		driver.getTitle()
		
		//Lấy ra được ID của Window/Tab mà driver đang đứng (active), số nhiều thì lấy all windown
		String loginWindowID = driver.getWindowHandle();
		Set<String> all =driver.getWindowHandles();
		
		
		
		
		
		
		
		
		
		
	}
	

	@Test
	public void TC_02_() {
		
	}

	@Test
	public void TC_03_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}