package session4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class HW3 {
	WebDriver driver;

	By USERNAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By LOGIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD = By.xpath("//div[@id='page-wrapper']/div[2]/div/h2");
	By CUSTOMERS_MENU_FIELD=By.xpath("//span[text()='Customers']");
	By ADD_CUSTOMER_FIELD=By.xpath("//a[text()='Add Customer']");
	By CONTACTS_HEADER_FIELD=By.xpath("//div[@id='page-wrapper']/div[2]/div/h2");
	By FULL_NAME_FIELD= By.xpath("//input[@id='account']");
	By COMPANY_DROPDOWN_FIELD=By.xpath("//select[@id='cid']");
	By EMAIL_FIELD= By.xpath("//input[@id='email']");
	By PHONE_NUMBER_FIELD=By.xpath("//input[@id='phone']");
	By ADDRESS_FIELD= By.xpath("//input[@id='address']");
	By CITY_FIELD=By.xpath("//input[@id='city']");
	By STATE_FIELD=By.xpath("//input[@id='state']");
	By ZIPCODE_FIELD= By.xpath("//input[@id='zip']");
	By COUNTRY_DROPDOWN_FIELD=By.xpath("//select[@id='country']");
	By CURRENCY_DROPDOWN_FIELD=By.xpath("//select[@id='currency']");
	By GROUP_DROPDOWN_FIELD=By.xpath("//select[@id='group']");
	By ACCOUNT_PASSWORD_FIELD= By.xpath("//input[@id='password']");
	By CONFIRM_ACCOUNT_PASSWORD_FIELD=By.xpath("//input[@id='cpassword']");
	By SAVE_BUTTON_FIELD= By.xpath("//button[@id='submit']");
	

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		
	}

	@Test
	public void loginAndAddContact() {
		driver.findElement(USERNAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON_FIELD).click();
		driver.findElement(DASHBOARD_HEADER_FIELD);
		Assert.assertEquals("Dashboard", driver.findElement(DASHBOARD_HEADER_FIELD).getText());
		
		driver.findElement(CUSTOMERS_MENU_FIELD).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(CUSTOMERS_MENU_FIELD)));
		
		driver.findElement(ADD_CUSTOMER_FIELD).click();
		driver.findElement(CONTACTS_HEADER_FIELD);
		Assert.assertEquals("Contacts", driver.findElement(CONTACTS_HEADER_FIELD).getText());
		driver.findElement(FULL_NAME_FIELD).sendKeys("Anna Radnaeva");
		
		Select sel=new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
		sel.selectByVisibleText("Apple");
		
		driver.findElement(COMPANY_DROPDOWN_FIELD);
		driver.findElement(EMAIL_FIELD).sendKeys("annar@gmail.com");
		driver.findElement(PHONE_NUMBER_FIELD).sendKeys("4125632545");
		driver.findElement(ADDRESS_FIELD).sendKeys("4523 Andalusia st");
		driver.findElement(CITY_FIELD).sendKeys("Irving");
		driver.findElement(STATE_FIELD).sendKeys("TX");
		driver.findElement(ZIPCODE_FIELD).sendKeys("75236");
		
		Select sel1=new Select(driver.findElement(COUNTRY_DROPDOWN_FIELD));
		sel1.selectByVisibleText("United States");
		
		Select sel2=new Select(driver.findElement(CURRENCY_DROPDOWN_FIELD));
		sel2.selectByVisibleText("USD");
		
		Select sel3=new Select(driver.findElement(GROUP_DROPDOWN_FIELD));
		sel3.selectByVisibleText("Selenium");
		
		driver.findElement(ACCOUNT_PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(CONFIRM_ACCOUNT_PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SAVE_BUTTON_FIELD).click();
		
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
