package drivers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
	
	public static WebDriver createWebDriver() throws Exception {
		
		String newDriverString = System.getProperty("browser", "chrome");
		
		Map<String, Object> preferenceMap = new HashMap<String, Object>();
		
		BrowserEnum s = BrowserEnum.valueOf(newDriverString);
		System.out.println("Selected " + s);
		
		switch (s) {
		case firefox:
			preferenceMap.clear();
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/XX");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addPreference("network.cookie.cookieBehaviour", 2);
			return new FirefoxDriver(firefoxOptions);
		case chrome:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
			ChromeOptions cOptions = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			
			prefs.put("profile.default_content_setting_values.cookies", 2);
			prefs.put("network.cookie.cookieBehaviour", 2);
			prefs.put("profile.block_thirds_party_cookies", true);
			
			cOptions.setExperimentalOption("prefs", prefs);
			
            cOptions.setHeadless(false);
            cOptions.addArguments("disable-infobars");
            cOptions.addArguments("disable-notifications");
            
			return new ChromeDriver(cOptions);
		default:
			throw new Exception("Unknown browser");
		}		
		
	}

}
