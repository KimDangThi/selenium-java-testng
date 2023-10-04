package javaTester;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Topic_05_Random {
	
	public static void main(String[] args) {
		//utilities = tiện ích
		//1. import thư viện driver/random
		WebDriver driver;
		Random rand;
		
		//tạo biến
		String emailAddress;
		
		//2. khởi tạo dữ liệu
		
		rand = new Random();
		driver = new ChromeDriver();
		
		
		//3. Khai báo biến
		
		emailAddress = "automation" + rand.nextInt(9999) +"@gmail.com";
		
		
		
		
		
		
		
							
	}
}