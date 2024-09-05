package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tek.tdd.base.UIBaseClass;

public class HomeTest extends UIBaseClass {

	/*
	 * // Validate When user navigate to home page title is TEK Insurance UI // and
	 * create Primary Account Button is Exist
	 */
	@Test
	public void validateHomePage() {
		String atualtTitle = getTitle();
		String expectedTitle = "Tek Insurance UI";
		Assert.assertEquals(atualtTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(homePage.tekInsuracePageName));

		boolean isDisplayedCreateAC = isElementDisplayed(homePage.createPrimaryAccountBtn);
		Assert.assertTrue(isDisplayedCreateAC, "Create Primary Account is displayed ");
		System.out.println(isDisplayedCreateAC);
	}
	@Test
	public void validateCreatePrimaryAccount() {
		
		click(homePage.createPrimaryAccountBtn);
		boolean isCreatAccountDisplay = isElementDisplayed(homePage.creatAccountTitle);
		System.out.println(isCreatAccountDisplay);
	}

	/*
	 * Create Account:
	 * 
	 * Scenario 2)
	 * 
	 * Navigate to Home page then click on Create Primary Account Button.
	 * 
	 * User should navigate to Create Account form page validate Form Title as
	 * 
	 * Expected “Create Primary Account Holder”
	 */

}
