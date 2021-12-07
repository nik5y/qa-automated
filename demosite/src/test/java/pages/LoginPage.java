package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]")
	public WebElement usernameInput;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]")
	public WebElement passwordInput;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[3]/button[1]/span[1]")
	public WebElement loginButton;

	public void inputUsername(String username) {
		usernameInput.sendKeys(username);
	}
	
	public void inputPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void login(String username, String password) {
		inputUsername(username);
		inputPassword(password);
		loginButton.click();
	}
}
