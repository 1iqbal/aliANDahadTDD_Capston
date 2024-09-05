package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.tdd.utility.SeleniumUtility;

public class CreateAccountPage extends SeleniumUtility {
	public CreateAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//*[@class='chakra-button css-1jp0m7c']")
	public WebElement createPrimaryAccountBtn;
	@FindBy(xpath = "//*[text()='Create Primary Account Holder']")
	public WebElement creatAccountTitle;
	@FindBy(css = "#email")
	public WebElement emailInput;
	@FindBy(css = "#firstName")
	public WebElement firstNameInput;
	@FindBy(css = "#lastName")
	public WebElement lastNameInput;

	@FindBy(css = "#title")
	public WebElement titleDropDown;
	@FindBy(css = "#gender")
	public WebElement genderDropDown;
	@FindBy(css = "#maritalStatus")
	public WebElement maritalStatusDropDown;
	@FindBy(css = "#employmentStatus")
	public WebElement employmentStatus;
	@FindBy(xpath = "//input[@id='dateOfBirth']")
	public WebElement dateOfBirth;
	
//	@FindBy(id="document.querySelector('#dateOfBirth').value='1999-05-05'")
//	public WebElement dOBOld;
//	
//	@FindBy(id="document.getElementById('dateOfBirth').value='2010-05-01'")
//	public WebElement dOByang;
	
	@FindBy(xpath="//*[@class='chakra-button css-jut409']")
	public WebElement createAccountBtn;
	@FindBy(xpath="//*[@class='chakra-button css-1x18d5s']")
	public WebElement clearFormBtn;
	
	@FindBy(xpath="//div[@class='chakra-alert banner-error css-1ykemat']")
	public WebElement emailExistError;
	
	@FindBy(xpath="//div[text()='you must be 18 years or older to create account']")
	public WebElement ageError;
	
	@FindBy(xpath="//p[text()='FULL NAME']")
	public WebElement fullNameTextOnProfile;
	@FindBy(xpath="(//div[@class='chakra-stack css-1pqwvz2']/h2)[3]")
	public WebElement emailTextOnSignUpAc;
	
	

    @FindBy(xpath = "//*[@id=\"username\"]") 
    public WebElement userNameInput;
	@FindBy(xpath = "//*[@id=\"password\"]") 
	public WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"confirm\"]") 
    public WebElement confirmPasswordPage;
    
    @FindBy(xpath = "//button[text()='Submit']") 
    public WebElement submitBtn;
//    
//    @FindBy(xpath = "//*[@id=\"username\"]") 
//    public WebElement userNameInput;
//	@FindBy(xpath = "//*[@id=\"password\"]") 
//	public WebElement passwordInput;
//    @FindBy(xpath = "//*[@id=\"confirm\"]") 
//    public WebElement confirmPasswordPage;
//    
//    @FindBy(xpath = "//button[text()='Submit']") 
//    public WebElement submitBtn;

}
