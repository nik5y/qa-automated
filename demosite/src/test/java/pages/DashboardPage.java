package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	@FindBy(xpath = "//body/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]")
	public WebElement welcomeHeading;
	
	public String getWelcomeHeadingText() {
		return welcomeHeading.getText();
	}
	
}
