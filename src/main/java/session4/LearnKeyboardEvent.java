package session4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class LearnKeyboardEvent {
	public class LearnDropDown {
		WebDriver driver;

		By USER_NAME_FIELD = By.xpath("//input[@id='username']");
		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
		By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id='page-wrapper']/div[2]/div/h2");// *represents all that's before
		By CUSTOMER_MENU_FIELD = By.xpath("//span[contains(text(), 'Customers')]");
		By ADD_CUSTOMER_MENU_FIELD = By.xpath("//a[contains(text(), 'Add Customer')]");
		By FULL_NAME_FIELD = By.xpath("//*[@id='account']");
		By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");

		@Before
		public void init() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://techfios.com/billing/?ng=admin/");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

		@Test
		public void loginTest() throws InterruptedException {

			String userName = "demo@techfios.com";

			driver.findElement(USER_NAME_FIELD).clear();
			driver.findElement(USER_NAME_FIELD).sendKeys(userName);
			driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
			// driver.findElement(SIGNIN_BUTTON_FIELD).click();

			Actions action = new Actions(driver);// Actions cl is used instead of click()
			action.sendKeys(Keys.ENTER).build().perform();
			action.sendKeys(Keys.RETURN).build().perform();

		}

		@After
		public void tearDown() {
			driver.close();
			driver.quit();
		}
	}
}
