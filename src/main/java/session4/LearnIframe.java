package session4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnIframe {
	WebDriver driver;
	@Before
	public void init() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	@Test
	public void iframe() {
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt")).click();
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("Adjustable"));
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//a[contains(text(), 'HORIZONTAL')]")).click();
	}
	
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
