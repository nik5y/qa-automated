package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	public String url = "https://phptravels.net/";
	
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[2]")
	public WebElement login;
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[1]/button[1]")
	public WebElement acceptCookiesButton;
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]")
	public WebElement signup;
	
	public void navToLogin() {	
		login.click();
	}
	
	public void navToSignup() {
		signup.click();
	}
	
	public void acceptCookies() {
		acceptCookiesButton.click();
	}
	
	
}
