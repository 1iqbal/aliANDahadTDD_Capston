package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.tdd.utility.SeleniumUtility;

public class UserProfilePage extends SeleniumUtility{
	public UserProfilePage() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath="//header[contains(text(),'Profile')]")
	public WebElement userProfieHeader;
	
	@FindBy(xpath="//button[contains(text(),'Logout')]")
	public WebElement userProfileLogoutBtn;

}
