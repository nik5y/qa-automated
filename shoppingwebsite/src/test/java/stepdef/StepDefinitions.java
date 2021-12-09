package stepdef;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import drivers.WebDriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ResultsPage;

public class StepDefinitions {
	
	public static WebDriver driver;
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
	CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
	public String searchQuery = "dress";
	public String firstResultText = "";
	
	@BeforeAll
	public static void init() throws Exception {
		driver = WebDriverFactory.createWebDriver();
	}

	@Given("I can access the Clothing Website")
	public void i_can_access_the_clothing_website() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			driver.get(HomePage.url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Did not load page\n");
		}
	}
	
	
	/**
	 * Test for Searching for Dresses
	 */
	@When("I search for the {string}")
	public void i_search_for_the_dress(String string) {
		homePage.search(string);
	}
	
	@When("Get the text of the first result")
	public void get_the_text_of_the_first_result() {
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(3))
		.pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class)
		.until(ExpectedConditions.visibilityOf(resultsPage.firstSearchResult));
		
		firstResultText = resultsPage.getTextOfFirstSearchResult();
	}
	
	@Then("I am able to verify the first result is a type of {string}")
	public void i_am_able_to_verify_the_first_result_is_a_type_of_dress(String string) {
		assertTrue(firstResultText.toLowerCase().contains(string.toLowerCase()));
	}
	
	
	/**
	 * Test for buying Dress
	 */
	@When("Add the first result to cart")
	public void add_the_first_result_to_cart() {
		Actions moveMouse = new Actions(driver);
		moveMouse.moveToElement(resultsPage.firstSearchResult)
				 .moveToElement(resultsPage.firstSearchResultAddToCartButton)
				 .click().build().perform();
	}
	
	@When("Go to checkout from results page")
	public void go_to_checkout_from_results_page() {
		resultsPage.clickCheckoutButton();
	}
	
	@When("Continue checkout after Order Summary")
	public void continue_checkout_after_order_summary() {
		checkoutPage.clickCheckoutButtonAtFirstScreen();
	}
	
	@When("Log in")
	public void log_in() {
		if (checkoutPage.checkIfNeedToSignIn()) {
			checkoutPage.login("bob@sapp.com", "1234567");
		}
	}
	
	@When("Continue checkout after Order Address")
	public void continue_checkout_after_order_address() {
		checkoutPage.clickCheckoutButtonAfterAddress();
	}
	
	@When("Agree with Terms and Conditions")
	public void agree_with_terms_and_conditions() {
		checkoutPage.acceptTermsAndConditions();
	}
	
	@When("Continue checkout after Order Shipping")
	public void continue_checkout_after_order_shipping() {
		checkoutPage.clickCheckoutButtonAfterShipping();
	}
	
	@When("Choose payment as Bank Wire")
	public void choose_payment_as_bank_wire() {
		checkoutPage.clickBankWirePayment();
	}
	
	@When("Confirm Order")
	public void confirm_order() {
		checkoutPage.clickConfirmOrder();
	}
	
	@Then("I can see that Order is complete")
	public void i_can_see_that_order_is_complete() {
		assertEquals("Your order on My Store is complete.",
				 checkoutPage.getOrderResultHeadingText());
	}

	
	
	@AfterAll
	public static void close() {
		driver.close();
	}
	
}
