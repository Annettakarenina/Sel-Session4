package session4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlertPopup {
	
	WebDriver driver;
	@Before
	public void init() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	@Test
	public void learnAlert() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		Thread.sleep(3000);
		String alertText=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertText);
	}
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
