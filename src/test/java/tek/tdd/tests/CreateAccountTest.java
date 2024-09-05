package tek.tdd.tests;

import org.testng.Assert;


import org.testng.annotations.Test;

import net.datafaker.Faker;
import tek.tdd.base.UIBaseClass;
import tek.tdd.utility.DataGenUtility;

public class CreateAccountTest extends UIBaseClass {
	
    String outPut = new Faker().name().username();
    String userName1 = outPut;
    String userName2 = outPut;

    @Test
	public void emailTextOnSignUpAC() {
		/*
		 * Scenario 2)
		 * 
		 * On Create primary account holder form fill up the form and click on create
		 * Account Button
		 * 
		 * Validate user navigate to page and email address shows as expected.
		 */
		click(createAccountPage.createPrimaryAccountBtn);
		sendText(createAccountPage.emailInput, DataGenUtility.data("email"));
		sendText(createAccountPage.firstNameInput, DataGenUtility.data("firstName"));
		sendText(createAccountPage.lastNameInput, DataGenUtility.data("lastName"));
		sendText(createAccountPage.employmentStatus, DataGenUtility.data("employmentStatus"));
		selectByVisibleText(createAccountPage.genderDropDown, "Male");
		selectByVisibleText(createAccountPage.titleDropDown, "Mr.");
		selectByVisibleText(createAccountPage.maritalStatusDropDown, "Married");
		sendDateToInput(createAccountPage.dateOfBirth, "05/06/1999");
		//SoftAssert softA = new SoftAssert();
		//String actualEmailOnSignUp = getElementText(createAccountPage.emailTextOnSignUpAc);
		Assert.assertTrue(isElementDisplayed(createAccountPage.emailTextOnSignUpAc));
	}
    @Test
	public void createACwithExistingEmail() {
		/*
		 * Scenario 3) Create account with existing email address
		 * 
		 * and validate error message as expected
		 */
		click(createAccountPage.createPrimaryAccountBtn);
		sendText(createAccountPage.emailInput, "ahad11@yahoo.com");
		sendText(createAccountPage.firstNameInput, "Ahad");
		sendText(createAccountPage.lastNameInput, "Iqbal");
		sendText(createAccountPage.employmentStatus, "Jobless");
		selectByVisibleText(createAccountPage.genderDropDown, "Male");
		selectByVisibleText(createAccountPage.titleDropDown, "Mr.");
		selectByVisibleText(createAccountPage.maritalStatusDropDown, "Married");

		sendDateToInput(createAccountPage.dateOfBirth, "05/06/1999");
		//click(createAccountPage.createAccountBtn);
		//SoftAssert softA = new SoftAssert();
		//String actualEmailExistError = getElementText(createAccountPage.emailExistError);
		Assert.assertTrue(isElementDisplayed(createAccountPage.emailExistError));
	}

	@Test
	public void creatACwithLessThan18() {
		/*
		 * Scenario 4)
		 * 
		 * Create Account with Age less that 18 Years Old, Error should display as
		 * "you must be 18 years or older to create account"
		 */
		click(createAccountPage.createPrimaryAccountBtn);
		sendText(createAccountPage.emailInput, DataGenUtility.data("email"));
		sendText(createAccountPage.firstNameInput, DataGenUtility.data("firstName"));
		sendText(createAccountPage.lastNameInput, DataGenUtility.data("lastName"));
		sendText(createAccountPage.employmentStatus, DataGenUtility.data("employmentStatus"));
		selectByVisibleText(createAccountPage.genderDropDown, "Male");
		selectByVisibleText(createAccountPage.titleDropDown, "Mr.");
		selectByVisibleText(createAccountPage.maritalStatusDropDown, "Married");

		sendDateToInput(createAccountPage.dateOfBirth, "05/06/2010");

		//click(createAccountPage.createAccountBtn);
		//SoftAssert softA = new SoftAssert();
		//String actualUnder18AgeError = getElementText(createAccountPage.ageError);
		Assert.assertTrue(isElementDisplayed(createAccountPage.ageError));
	}
	
	@Test
	public void signIn() throws InterruptedException  {
		/*
		 * Scenario 5)
		 * 
		 * Navigate To Create Account Page, Create a valid account,
		 * 
		 * User navigated to Sign Up page, Sign up for the Account, user will redirect
		 * to sign in page in few second, then sign in with credential created for
		 * account, user should navigate to "Primary Account Portal"
		 * 
		 * Validate Full Name display at Profile Section by clicking on profile Icon.
		 */
		click(createAccountPage.createPrimaryAccountBtn);
		sendText(createAccountPage.emailInput, DataGenUtility.data("email"));
		sendText(createAccountPage.firstNameInput, DataGenUtility.data("firstName"));
		sendText(createAccountPage.lastNameInput, DataGenUtility.data("lastName"));
		Thread.sleep(2000);
		sendText(createAccountPage.employmentStatus, DataGenUtility.data("employmentStatus"));
		Thread.sleep(3000);
		selectByVisibleText(createAccountPage.genderDropDown, "Male");
		selectByVisibleText(createAccountPage.titleDropDown, "Mr.");
		selectByVisibleText(createAccountPage.maritalStatusDropDown, "Married");
		sendDateToInput(createAccountPage.dateOfBirth, "05/06/1999");
		
		sendText(createAccountPage.userNameInput, userName1);
//		clearTextUsingSendKeys(createAccountPage.passwordInput);
		sendText(createAccountPage.passwordInput, "Ahad2112233");
		sendText(createAccountPage.confirmPasswordPage, "Ahad2112233");
		click(createAccountPage.submitBtn);
		Thread.sleep(4000);
		//getDriver().switchTo().alert().accept();
		
		sendText(loginPage.userNameInput, userName2);
		sendText(loginPage.passwordIpt, "Ahad2112233");
		Thread.sleep(3000);
		click(loginPage.signInBtn);
		Thread.sleep(3000);
		
		click(accountPage.profileIcon);
		Thread.sleep(3000);
		//SoftAssert softA = new SoftAssert();
		//String actualProfileFullName = getElementText(accountPage.profileFullName);
		Assert.assertTrue(isElementDisplayed(accountPage.profileFullName));
	}

	
}
