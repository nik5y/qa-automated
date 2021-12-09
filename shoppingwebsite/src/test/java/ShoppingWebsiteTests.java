import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import drivers.WebDriverFactory;
import org.openqa.selenium.support.ui.FluentWait;

import pages.CheckoutPage;
import pages.HomePage;
import pages.ResultsPage;

public class ShoppingWebsiteTests {
	
	public static WebDriver driver;
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
	CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
	
	@BeforeClass
	public static void init() throws Exception {
		driver = WebDriverFactory.createWebDriver();
	}
	
	@Before
	public void setup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			driver.get(HomePage.url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Did not load page\n");
		}
	}
	
//	@Test
//	public void searchForDress() {
//		String searchQuery = "dress";
//		
//		homePage.search(searchQuery);
//		
//		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(3))
//		.pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class)
//		.until(ExpectedConditions.visibilityOf(resultsPage.firstSearchResult));
//		
//		String firstResultText = resultsPage.getTextOfFirstSearchResult();
//		
//		assertTrue(firstResultText.toLowerCase().contains(searchQuery.toLowerCase()));
//	}

	@Test
	public void buyDress() {
		String searchQuery = "dress";
		
		homePage.search(searchQuery);
		
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(3))
		.pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class)
		.until(ExpectedConditions.visibilityOf(resultsPage.firstSearchResult));
		
		// move mouse to item and click add cart
		Actions moveMouse = new Actions(driver);
		moveMouse.moveToElement(resultsPage.firstSearchResult)
				 .moveToElement(resultsPage.firstSearchResultAddToCartButton)
				 .click().build().perform();

		// continue checkout
	    resultsPage.clickCheckoutButton();
				 
		// continue checkout
		checkoutPage.clickCheckoutButtonAtFirstScreen();
		
		// login in checkout
		if (checkoutPage.checkIfNeedToSignIn()) {
			checkoutPage.login("bob@sapp.com", "1234567");
		}
		
		// continue after address
		checkoutPage.clickCheckoutButtonAfterAddress();
		
		// accept t&c
		checkoutPage.acceptTermsAndConditions();
		
		// continue checkout
		checkoutPage.clickCheckoutButtonAfterShipping();
		
		// choose payment option
		checkoutPage.clickBankWirePayment();
		
		// buy
		checkoutPage.clickConfirmOrder();
		
		assertEquals("Your order on My Store is complete.",
					 checkoutPage.getOrderResultHeadingText());
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
