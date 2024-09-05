package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class LoginPage extends SeleniumUtility {

    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath="//*[@class='chakra-button css-ez23ye']")
    public WebElement loginBtn;
    
    @FindBy(xpath="//*[@id=\"username\"]")
    public WebElement userNameInput;
    @FindBy(css="#password")
    public WebElement passwordIpt;
    @FindBy(xpath="//button[text()='Sign In']")
    public WebElement signInBtn;
    
    @FindBy(xpath="//div[@class='chakra-alert banner-error css-1ykemat']")
    public WebElement userErrorMessage;
    @FindBy(xpath="//div[text()='Password not matched']")
    public WebElement passwordErrorMessage;

    

    public void signIn(String userName, String password) {
    	click(loginBtn);
		sendText(userNameInput,userName);
		sendText(passwordIpt, password);
		click(signInBtn);
		
}
}