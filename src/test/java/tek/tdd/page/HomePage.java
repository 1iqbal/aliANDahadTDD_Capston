package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class HomePage extends SeleniumUtility {
    //At Constructor level, We have to initialize these elements with Instance of WebDriver.
    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(className = "top-nav__logo")
    public WebElement topLeftLogo;
    @FindBy(id = "signinLink")
    public WebElement signInLink;
    @FindBy(id = "accountLink")
    public WebElement accountLink;
    
    @FindBy(xpath="//title[text()='Tek Insurance UI']")
    public WebElement takeInsuraceApp;
    @FindBy(xpath="//*[@class='chakra-heading css-1at26de']")
    public WebElement tekInsuracePageName;
    @FindBy(xpath="//*[@class='chakra-button css-1jp0m7c']")
    public WebElement createPrimaryAccountBtn;
    @FindBy(xpath="//*[@class='chakra-button css-ez23ye']")
    public WebElement loginBtn;
    
    @FindBy(xpath="//*[text()='Create Primary Account Holder']")
    public WebElement creatAccountTitle;
    
    @FindBy(xpath="//h2[text()='Lets get you started']")
    public WebElement homePageMainTitle;
    
	@FindBy(linkText="Accounts")
	public WebElement accountsLink;
}
