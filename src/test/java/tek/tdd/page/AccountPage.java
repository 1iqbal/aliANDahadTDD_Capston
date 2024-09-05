package tek.tdd.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.tdd.utility.SeleniumUtility;

public class AccountPage extends SeleniumUtility {

	public AccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//button[@class='chakra-button chakra-button css-1lzp9bh']")
    public WebElement profileIcon;
	
	@FindBy(xpath= "//p[text()='FULL NAME']")
	public WebElement profileFullName;
	
	@FindBy(xpath="//h2[text()='Customer Service Portal']")
	public WebElement customerServicePortal;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div/div/table/tbody/tr")
	public List<WebElement> accountTableRows;
	
	@FindBy(xpath="//select[@class='chakra-select css-161pkch']")
	public WebElement accountShowBarDropDown;
	
	@FindBy(xpath="//div[@id=\"root\"]/div/div[3]/div/div/div/div[2]/table/tbody/tr/td[1]/button")
	public List<WebElement> accoutTableRows10;
	
	@FindBy(xpath="//button[@class='chakra-button css-1kcf87u']")
	public List<WebElement> accountTableRows25;
	
	@FindBy(xpath="//button[@class='chakra-button css-1kcf87u']")
	public List<WebElement> accountTableRows50;
}

