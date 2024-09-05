package tek.tdd.base;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import tek.tdd.page.AccountPage;
import tek.tdd.page.CreateAccountPage;
import tek.tdd.page.HomePage;
import tek.tdd.page.LoginPage;
import tek.tdd.page.PlansPage;
import tek.tdd.page.UserProfilePage;
import tek.tdd.utility.SeleniumUtility;

public class UIBaseClass extends SeleniumUtility {
    private static final Logger LOGGER = LogManager.getLogger(UIBaseClass.class);
    public HomePage homePage;
    public LoginPage loginPage;
    public AccountPage accountPage;
    public CreateAccountPage createAccountPage;
    public UserProfilePage userProfilePage;
    public PlansPage plansPage;

    @BeforeMethod
    public void setupTests(){
    LOGGER.info("Setup test and opening browser");
    setupBrowser();
    homePage = new HomePage();
    loginPage = new LoginPage();
    accountPage = new AccountPage();
    createAccountPage = new CreateAccountPage();
    userProfilePage = new UserProfilePage();
    plansPage = new PlansPage();

    }

    @AfterMethod
    public void testCleanUp(){
        LOGGER.info("Running after each test and closing browser");
       // quitBrowser();

    }
}
