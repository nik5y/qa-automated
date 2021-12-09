package stepdef;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;

public class StepDefinitions {
	
	public static WebDriver driver;
	public boolean cookieAccepted = false; 
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	
	@io.cucumber.java.BeforeAll
	public static void setDriver() throws Exception {
		driver = WebDriverFactory.createWebDriver();
//		driver.manage().window().setSize(new Dimension(1000,800));
	}
	
	@Given("I can access the PHP website")
	public void i_can_access_the_php_website() {
		driver.get(homePage.url);
		if (!driver.manage().getCookies().toString().contains("disclaimer=true")) {
			homePage.acceptCookies();
		}
	}
	
	@When("I click on login button")
	public void i_click_on_login_button() {
		homePage.navToLogin();
	}
	
	@When("Enter credentials and press login")
	public void enter_credentials() {
		loginPage.login("user@phptravels.com", "demouser");
	}
	
	@Then("I am able to log in")
	public void i_am_able_to_log_in() {
		assertTrue(dashboardPage.getWelcomeHeadingText().contains("Welcome Back"));
	}

	@AfterAll
	public static void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
