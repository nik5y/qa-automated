package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage {
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]")
	public WebElement firstNameInput;
	
	
}
