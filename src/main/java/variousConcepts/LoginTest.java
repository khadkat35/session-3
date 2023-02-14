package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	
	WebDriver driver;
	
	@Before
	public void init(){
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=loging/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void logingTest() {
		
		////h2[text()= ' Dashboard ']
		////h2[contains  (text(), 'Dashboard ')]
		
		//storing web-element in WebElement class
		WebElement usernameElement = driver.findElement(By.xpath("//*[@id=\'username\']"));
		WebElement passwordElemet = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement signinElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
		
		
		
		//storing in By class
		By username_field = By.xpath("//*[@id=\'username\']");
		By password_field = By.xpath("//*[@id=\'password\']");
		By signin_field = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By dashboardField = By.xpath("h2[contains (text()= ' Dashboard ')]");
		
		
		driver.findElement(username_field).sendKeys("demo@techfios.com");
		usernameElement.clear();
		usernameElement.sendKeys("demo@techfios.com");
		driver.findElement(password_field).sendKeys("abc123");
		driver.findElement(signin_field).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dashboardField));
		
		WebElement dashboardElement = driver.findElement(By.xpath("h2[contains (text()= ' Dashboard ')]"));
		
		//assert works with web Element
		Assert.assertTrue("dashboard", dashboardElement.isDisplayed());
		 
		
		
	}

}
