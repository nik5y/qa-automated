import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import drivers.WebDriverFactory;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;

public class DemoSiteTests {
	
	public static WebDriver driver;
	public boolean cookieAccepted = false; 
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
	
	@BeforeClass
	public static void setDriver() throws Exception {
		driver = WebDriverFactory.createWebDriver();
//		driver.manage().window().setSize(new Dimension(1000,800));
	}
	
	@Before
	public void openSite() {
		driver.get(homePage.url);
		if (!driver.manage().getCookies().toString().contains("disclaimer=true")) {
			homePage.acceptCookies();
		}
	}
	
//	@Test
//	public void loginTest() {
//		homePage.navToLogin();
//	}
	
	@Test
	public void navToLoginAndAttempLogin() {
		homePage.navToLogin();
		loginPage.login("user@phptravels.com", "demouser");
		assertTrue(dashboardPage.getWelcomeHeadingText().contains("Welcome Back"));
	}
	
	@AfterClass
	public static void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	

}
