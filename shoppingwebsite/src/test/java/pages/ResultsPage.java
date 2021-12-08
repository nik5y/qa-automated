package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {
	
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/h1[1]")
	public WebElement searchHeading;
	
	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]")
	public WebElement firstSearchResult;

	public String getTextOfFirstSearchResult() { 
		return firstSearchResult.getText();
	}
	

	
	
}
