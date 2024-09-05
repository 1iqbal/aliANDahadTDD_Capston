package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tek.tdd.base.UIBaseClass;

public class LoginTest extends UIBaseClass {

	/*
	 * ogin:
	 * 
	 * Scenario 1)
	 * 
	 * Navigate to login by clicking on Login button and enter valid csr user
	 * 
	 * Username: supervisor
	 * 
	 * Password: tek_supervisor
	 * 
	 * And validate user navigate to Customer Service Portal
	 */
	@Test
	public void loginTest() {

		loginPage.signIn("supervisor", "tek_supervisor");

		Assert.assertTrue(isElementDisplayed(accountPage.customerServicePortal));
	}
	@Test
	public void invalidUserLoginTest() {
		/*
		 * Scenario 2)
		 * 
		 * Navigate to login and enter wrong credentials and validate error message as
		 * expected
		 * 
		 * Note both wrong username and wrong password should tested
		 */

		loginPage.signIn("supervisor1", "tek_supervisor");
		
		Assert.assertTrue(isElementDisplayed(loginPage.userErrorMessage));
		System.out.println("Wrong User Name");

		sendText(loginPage.userNameInput, "supervisor");
		sendText(loginPage.passwordIpt, "tek_supervisor1");
		click(loginPage.signInBtn);
	
		Assert.assertTrue(isElementDisplayed(loginPage.passwordErrorMessage));
		System.out.println("Password not Matched");

	}
	@Test
	public void loginAndLogoutTest() {
		/*
		 * Navigate to login and enter valid CSR credentials and navigate to Customer
		 * Service Portal then click on profile button and then click on Logout button
		 * make sure user navigate to home page
		 */
		loginPage.signIn("supervisor", "tek_supervisor");

		click(accountPage.profileIcon);
		click(userProfilePage.userProfileLogoutBtn);
		
		Assert.assertTrue(isElementDisplayed(homePage.homePageMainTitle));
	}
}
