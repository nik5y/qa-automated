package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	public static String url = "https://www.hl.co.uk/shares/stock-market-summary/ftse-100";

	@FindBy(id = "acceptCookieButton")
	public WebElement acceptCookieButton;
	
	@FindBy(id = "view-constituents")
	public WebElement stockView;
	
	public void acceptCookies() {
		acceptCookieButton.click();
	}
	
	public void findFallersRisers() {
		System.out.println("Searching through elements...");
		List<WebElement> list = stockView.findElements(By.xpath("//span[@data-field='perc' and @class='box-block']"));
		
		String riserStockId = "";
		String fallerStockId = "";
		
		double riserChange = -100d;
		double fallerChange = 100d;
		
		for ( WebElement e : list) {
			double change = Double.parseDouble(e.getText().substring(0, e.getText().length()-1));

			if (riserChange < change) {
				riserChange = change;
				riserStockId = e.getAttribute("data-item").split("-")[0];
			} else if (fallerChange > change){
				fallerChange = change;
				fallerStockId = e.getAttribute("data-item").split("-")[0];
			}
		};
		
		System.out.println("Riser: " + riserStockId + " +" + riserChange + '%');
		System.out.println("Faller: " + fallerStockId + ' ' + fallerChange + '%');
	}
}
