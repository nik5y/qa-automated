package drivers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitTest {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void init() {
		driver = WebDriverFactory.createWebDriver();
	}
	
	@Before
	public void setup() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			driver.get("http://automationpractice.com/index.php");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Did not load page\n");
		}
	}

	@Test
	public void test() {

		WebElement wait = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/div[1]")));

		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
}
