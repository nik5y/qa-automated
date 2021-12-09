package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {
	
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/h1[1]")
	public WebElement searchHeading;
	
	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]")
	public WebElement firstSearchResult;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/a[1]")
	public WebElement firstSearchResultAddToCartButton;
	
	@FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]")
	public WebElement checkoutButton;

	public String getTextOfFirstSearchResult() { 
		return firstSearchResult.getText();
	}
	
	public void clickFirstSearchResultAddToCart() {
		firstSearchResultAddToCartButton.click();
	}
	
	public void clickCheckoutButton() {
		checkoutButton.click();
	}
	


	
}
