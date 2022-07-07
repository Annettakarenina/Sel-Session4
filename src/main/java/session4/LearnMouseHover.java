package session4;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {
	
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
	public void mouseHover() {
		By PRODUCT_MENU_FIELD= By.xpath("//span[contains(text(), 'Products')]");
		By NETWORKING_FIELD= By.xpath("//a[text()='Networking']");
		By FOR_HOME_NETWORKING_MENU_FIELD= By.xpath("//a[text()='For Home' and @data-tier-id='1']/ancestor::li/descendant::li[27]");
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(PRODUCT_MENU_FIELD)).build().perform();
		action.moveToElement(driver.findElement(NETWORKING_FIELD)).build().perform();
		
		driver.findElement(NETWORKING_FIELD).click();
		
		
		
		
	}
	
}
