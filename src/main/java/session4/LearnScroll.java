package session4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnScroll {
	
	WebDriver driver;
	@Before
	public void init() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	@Test
	public void learnIframe() throws InterruptedException {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("scroll(0, 3000)");
	Thread.sleep(6000);
	js.executeScript("scroll(0, 0)");
	
	}
	
}
