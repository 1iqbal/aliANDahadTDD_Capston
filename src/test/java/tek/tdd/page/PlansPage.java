package tek.tdd.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.tdd.utility.SeleniumUtility;

public class PlansPage extends SeleniumUtility {
	public PlansPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(linkText = "Plans")
	public WebElement planButton;

	@FindBy(xpath = "//td[@class='css-xumdn4']")
	public List<WebElement> rowsOfthePlansData;

	@FindBy(xpath = "//h2[@class='chakra-heading css-1jb3vzl']")
	public WebElement todayPlanPriceTitle;

	@FindBy(xpath = "(//td[@class='css-132p0l1'])[3]")
	public WebElement dateCreated;

	@FindBy(xpath = "(//td[@class='css-132p0l1'])[4]")
	public WebElement dateExpire;
	
	
	
	

}
