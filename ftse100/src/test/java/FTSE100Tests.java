import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverFactory;
import pages.HomePage;

public class FTSE100Tests {

	public static WebDriver driver;
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	
	@BeforeClass
	public static void init() throws Exception {
		driver = WebDriverFactory.createWebDriver();
	}
	
	@Before
	public void setup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			driver.get(HomePage.url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Did not load page\n");
		}
	}	
	
	@Test
	public void fallersRisers() {
		homePage.acceptCookies();
		double[] fallerRiserChanges = homePage.findFallersRisers();
		//Asserting the faller and riser %changes were updated from initial impossible values
		assertTrue(fallerRiserChanges[0] != 101d);
		assertTrue(fallerRiserChanges[1] != -101d);
	}
	
	@AfterClass
	public static void close() {
		driver.quit();
	}
	
}
