package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]")
	public WebElement checkoutButtonAtFirstScreen;
	
	@FindBy(xpath = "//input[@id='email']")
	public WebElement usernameInput;
	
	@FindBy(xpath = "//input[@id='passwd']")
	public WebElement passwordInput;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]")
	public WebElement checkoutButtonAfterAddress;
		
	@FindBy(xpath = "//input[@id='cgv']")
	public WebElement termsAndConditionCheckbox;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]")
	public WebElement checkoutButtonAfterShipping;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]")
	public WebElement selectPaymentBankWire;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]")
	public WebElement confirmOrderButton;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/p[1]")
	public WebElement orderResultHeading;
	
	@FindBy(xpath = "//header/div[2]")
	public WebElement navigationBar;

	public void clickCheckoutButtonAtFirstScreen() {
		checkoutButtonAtFirstScreen.click();
	}
	
	public void login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
	}
	
	public void clickCheckoutButtonAfterAddress() {
		checkoutButtonAfterAddress.click();
	}
	
	public void acceptTermsAndConditions() {
		termsAndConditionCheckbox.click();
	}

	public void clickCheckoutButtonAfterShipping() {
		checkoutButtonAfterShipping.click();
	}
	
	public void clickBankWirePayment() {
		selectPaymentBankWire.click();
	}
	
	public void clickConfirmOrder() {
		confirmOrderButton.click();
	}
	
	public boolean checkIfNeedToSignIn() {
		System.out.println(navigationBar.getText());
		return navigationBar.getText().contains("Sign in");
	}
	
	public String getOrderResultHeadingText() {
		return orderResultHeading.getText();
	}
	
}
