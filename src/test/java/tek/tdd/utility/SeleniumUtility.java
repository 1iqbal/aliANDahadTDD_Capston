package tek.tdd.utility;

import java.time.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tek.tdd.base.BaseSetup;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);
    protected WebDriverWait getWait(){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(WAIT_TIME_IN_SECOND));
    }
    public WebElement waitTillClickable(WebElement element) {
        return this.getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement waitTillClickable(By by) {
        return this.getWait().until(ExpectedConditions.elementToBeClickable(by));
    }
    public WebElement waitTillPresence(WebElement element) {
        return this.getWait().until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitTillPresence(By by) {
        return this.getWait().until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public String getTitle() {
        String title = getDriver().getTitle();
        return title;
    }
    public byte[] takeScreenShotAsBytes() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public String getElementText(By locator){
        LOGGER.debug("Returning element text {} ", locator);
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getText();
    }

    //Overload the method
    public String getElementText(WebElement element){
        LOGGER.debug("Returning element text {} ", element);
        return getWait().until(ExpectedConditions.visibilityOf(element)).getText();
    }
    public String getElementValue(WebElement element){
        LOGGER.debug("Returning element vlaue {} ", element);
        return getWait().until(ExpectedConditions.visibilityOf(element)).getAttribute("value");
    }

    public boolean isElementEnabled(By locator){
        LOGGER.debug("Checking element enable status {} ", locator);
        boolean isEnabled = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator))
                .isEnabled();
        LOGGER.debug("element is enabled status {}",isEnabled);
        return isEnabled;
    }

    public boolean isElementEnabled(WebElement element){
        LOGGER.debug("Checking elements enable status {}", element);
        boolean isEnabled = getWait().until(ExpectedConditions.visibilityOf(element))
                .isEnabled();
        LOGGER.debug("elements is enabled status {}", isEnabled);
        return isEnabled;
    }

    public void sendText(WebElement element, String text){
        LOGGER.debug("Sending text {} to Element {}", text, element);
        WebElement targetElement = getWait().until(ExpectedConditions.visibilityOf(element));
        targetElement.clear();
        targetElement.sendKeys(text);
    }

    public void click(WebElement element){
        LOGGER.debug("Clicking on Element {}", element);
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean isElementDisplayed(WebElement element){
        LOGGER.debug("Checking element for isDisplayed {} ", element);
        return getWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed();

    }
    
    public void selectByIndex(WebElement ele, int index) {
    	Select select = new Select(ele);
    	select.selectByIndex(index);
    }
    public void selectByValue(WebElement ele, String value) {
        Select select = new Select(ele);
        select.selectByValue(value);
    }
    public void selectByVisibleText(WebElement ele, String visibleText) {
        Select select = new Select(ele);
        select.selectByVisibleText(visibleText);
    }
    public  void deselectByIndex(WebElement ele, int index) {
        Select deselect = new Select(ele);
        deselect.deselectByIndex(index);
    }
    public  void deselectByValue(WebElement ele, String value) {
        Select deselect = new Select(ele);
        deselect.deselectByValue(value);
    }
    public  void deselectByVisibleText(WebElement ele, String visibleText) {
        Select deselect = new Select(ele);
        deselect.deselectByVisibleText(visibleText);
    }
    public String getAttribute(WebElement ele, String value) {
        String attribute = ele.getAttribute(value);
        return attribute;
    }
    public  String getTagname(WebElement ele) {
        return ele.getTagName();
    }
    public  String getText(WebElement ele) {
        String text = ele.getText();
        return text;
    }
    public void HighlightElement(WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", ele);
        js.executeScript("arguments[0].style.border='1px white'", ele);
    }
    public void dragAndDropAction(WebElement elementToHover, WebElement elementToClick) {
        Actions action = new Actions(getDriver());
        action.dragAndDrop(elementToHover, elementToClick).build().perform();
    }

    public  boolean isElementSelected(WebElement ele) {
        if (ele.isSelected()) {
            return true;
        } else {
            return false;
        }
    }
    public void moveToElementAction(WebElement ele) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(ele);
        actions.build().perform();
    }
    public WebElement fluientWaitforElement(WebElement element, int timoutSec, int pollingSec) {
        FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class, TimeoutException.class)
                .ignoring(StaleElementReferenceException.class);
        for (int i = 0; i < 2; i++)
            fWait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    public void switchwindow(String pageTitle) {
        String currentWindow = getDriver().getWindowHandle();
        Set<String> handles = getDriver().getWindowHandles();
        for (String winHandle : handles) {
            String currentWindowTitle = getDriver().switchTo().window(winHandle).getTitle();
            if (currentWindowTitle.equals(pageTitle)) {
                break;
            } else {
                getDriver().switchTo().window(currentWindow);
            }
        }
    }
    public void selectCalendarDateWithJS(String date, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("arguments[0].setAttribute('value','" + date + "');", element);
        
    }
    public void clickElementWithJS(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("arguments[0].click();", element);
    }
    public void scrollPageDownWithJS() {
        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public void dateTimeNow() {
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM/d/yyyy HH:mm:ss");
		  LocalDateTime now = LocalDateTime.now();
		  System.out.println(dtf.format(now)); 
    }
    public void sendDateToInput(WebElement element,String year){
        LOGGER.info("Sending {}, {}, {} to {}",element, year);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click().sendKeys(year).sendKeys(Keys.ENTER).perform();
    }
    public List<WebElement> getElements(List<WebElement> elements){
        LOGGER.info("getting all elements {}", elements);
        return getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public void clearTextUsingSendKeys(WebElement toClear) {
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
    }

    }

    
    

