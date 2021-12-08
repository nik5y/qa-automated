package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(id = "search_query_top")
	public WebElement searchBar;
	
	@FindBy(name = "submit_search")
	public WebElement searchButton;
	
	public static String url = "http://automationpractice.com/index.php";
	
	public void search(String input) {
		searchBar.sendKeys(input);
		searchButton.click();
	}
}
