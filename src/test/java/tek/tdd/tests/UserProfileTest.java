package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tek.tdd.base.UIBaseClass;

public class UserProfileTest extends UIBaseClass {
	/*
	 * User Profile:
	 * 
	 * Scenario 1)
	 * 
	 * Navigate to login and enter valid CSR credentials and navigate to Customer
	 * Service Portal then click on profile button validate information is in
	 * Profile Side Drawer is correct.
	 */
	@Test
	public void validateUserProfile() {
		
		loginPage.signIn("supervisor", "tek_supervisor");
		
		click(accountPage.profileIcon);
		Assert.assertTrue(isElementDisplayed(userProfilePage.userProfieHeader));
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
