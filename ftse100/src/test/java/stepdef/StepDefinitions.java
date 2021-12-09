package stepdef;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class StepDefinitions {
	
	public static WebDriver driver;
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	double[] fallerRiserChanges = new double[2];
	
	@BeforeAll
	public static void init() throws Exception {
		driver = WebDriverFactory.createWebDriver();
	}
	
	@Given("I can access the FTSE100 Website")
	public void i_can_access_the_ftse100_website() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		try {
			driver.get(HomePage.url);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Did not load page\n");
		}
	}
	
	@When("I accept cookies")
	public void i_accept_cookies() {
		homePage.acceptCookies();
	}
	
	@And("Faller and Riser are searched")
	public void faller_and_riser_are_searched() {
		 fallerRiserChanges = homePage.findFallersRisers();
	}
	
	@Then("Faller and Riser percentages are returned as expected")
	public void faller_and_riser_percentages_are_returned_as_expected() {
		assertTrue(fallerRiserChanges[0] != 101d);
		assertTrue(fallerRiserChanges[1] != -101d);
	}
	
	@AfterAll
	public static void close() {
		driver.quit();
	}
	
	
}
