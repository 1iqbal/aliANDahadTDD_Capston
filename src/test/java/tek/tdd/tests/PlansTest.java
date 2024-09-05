package tek.tdd.tests;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tek.tdd.base.UIBaseClass;

public class PlansTest extends UIBaseClass {

	@Test
	public void sigin() {

		loginPage.signIn("supervisor", "tek_supervisor");

		click(plansPage.planButton);
	}

	@Test
	public void validatePlansPage() {
		/*
		 * Plans
		 * 
		 * Scenario 1)
		 * 
		 * Navigate to Customer Service Portal with valid CSR credentials and navigate
		 * to Plans Page. Validate 4 row of data is present.
		 */

		sigin();
		List<WebElement> pageTable = getElements(plansPage.rowsOfthePlansData);
		Assert.assertEquals(pageTable.size(), 4);
		System.err.println("4 rows of data should be present");
	}

	@Test
	public void creatDate() {
		/*
		 * Scenario 2)
		 * 
		 * Navigate to Customer Service Portal with valid CSR credentials and navigate
		 * to Plans Page.
		 * 
		 * Then validate Create Date is todays date in (EST Time zone) and Date Expire
		 * is a day after (EST Time Zone)
		 */
		sigin();
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM/d/yyyy HH:mm:ss");
		//LocalDateTime now = LocalDateTime.now();
		//System.out.println(dtf.format(now))
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		//LocalDateTime now = LocalDateTime.now();
		//System.out.println(dtf.format(now));

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(getText(plansPage.dateCreated), dtf.format(LocalDate.now()));
		
		softAssert.assertEquals(getText(plansPage.dateExpire), dtf.format(LocalDate.now().plusDays(1)));
		
		}

	}

