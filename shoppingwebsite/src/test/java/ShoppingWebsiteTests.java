import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import drivers.WebDriverFactory;
import org.openqa.selenium.support.ui.FluentWait;
import pages.HomePage;
import pages.ResultsPage;

public class ShoppingWebsiteTests {
	
	public static WebDriver driver;
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
	
	@BeforeClass
	public static void init() throws Exception {
		driver = WebDriverFactory.createWebDriver();
	}
	
	@Before
	public void setup() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			driver.get(HomePage.url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Did not load page\n");
		}
	}
	
	@Test
	public void searchForDress() {
		String searchQuery = "dress";
		
		homePage.search(searchQuery);
		
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(3))
		.pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class)
		.until(ExpectedConditions.visibilityOf(resultsPage.firstSearchResult));
		
		String firstResultText = resultsPage.getTextOfFirstSearchResult();
		
		assertTrue(firstResultText.toLowerCase().contains(searchQuery.toLowerCase()));
	}

	
	//	@Test
//	public void test() {
//		WebElement wait = new WebDriverWait(driver, 10)
//				.until(ExpectedConditions.presenceOfElementLocated(
//						By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/div[1]")));
//	}
	
	
	@AfterClass
	public static void close() {
		driver.quit();
	}
}
