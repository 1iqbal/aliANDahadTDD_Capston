package tek.tdd.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tek.tdd.base.UIBaseClass;

public class AccountTest extends UIBaseClass {

	@Test
	public void signIn() {

		loginPage.signIn("supervisor", "tek_supervisor");
	}
	@Test
	public void validateAccountsOnProfile() {
		/*
		 * Accounts
		 * 
		 * Scenario 1)
		 * 
		 * Navigate to Customer Service Portal with valid CSR credentials and navigate
		 * to Accounts verify 5  row /page is default * click(loginPage.loginBtn);
		 * 
		 * sendText(loginPage.userNameInput, "supervisor");
		 * sendText(loginPage.passwordIpt, "tek_supervisor");
		 * click(loginPage.signInBtn);
		 * 
		 * click(plansPage.planButton);
		 */
		signIn();

		click(homePage.accountLink);
		List<WebElement> accountItems = getElements(accountPage.accountTableRows);
		Assert.assertEquals(accountItems.size(), 5);
		
		Reporter.log(getTitle()+" 5 rows are present on account page");
	}

	@Test
	public void accountShowPerPage() throws InterruptedException {
		/*
		 * Scenario 2)
		 * 
		 * Navigate to Customer Service Portal with valid CSR credentials and navigate
		 * to Accounts change show per page to 10, 25, 50 and validate table records per
		 * page according to selected show per page.
		 */
		signIn();

		click(homePage.accountLink);

		click(accountPage.accountShowBarDropDown);
		selectByVisibleText(accountPage.accountShowBarDropDown, "Show 10");
		Thread.sleep(2000);
		List<WebElement> accountItems = getElements(accountPage.accoutTableRows10);
		Assert.assertEquals(accountItems.size(), 10);

		click(accountPage.accountShowBarDropDown);
		selectByVisibleText(accountPage.accountShowBarDropDown, "Show 25");
		List<WebElement> accountItems25 = getElements(accountPage.accountTableRows25);
		Assert.assertEquals(accountItems25.size(), 25);

		click(accountPage.accountShowBarDropDown);
		selectByVisibleText(accountPage.accountShowBarDropDown, "Show 50");
		List<WebElement> accountItems50 = getElements(accountPage.accountTableRows50);
		Assert.assertEquals(accountItems50.size(), 50);

	}

}
