package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class CommonWaitMethods {

    WebDriver driver;

    public CommonWaitMethods(WebDriver driver){
        this.driver = driver;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement ele) {
        boolean flag = false;
        try {
            ele.isDisplayed();
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public WebElement elementToBePresent(By locator, int timeout) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeout)).until
                (ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    public WebElement elementToBeVisible(WebElement webElement, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
        return element;
    }

    public WebElement elementToBeVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public List<WebElement> elementsToBeVisible(List<WebElement> webElements, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
        return elements;
    }

    public List<WebElement> elementsToBeVisible(By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return elements;
    }

    public WebElement elementToBeClickable(WebElement webElement, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return element;
    }

    public WebElement elementToBeClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public Boolean elementToBeSelected(WebElement webElement, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Boolean selectedState = wait.until(ExpectedConditions.elementToBeSelected(webElement));
        return selectedState;
    }

    public void pageLoadTimeOut(WebDriver driver, Duration duration) {
        driver.manage().timeouts().pageLoadTimeout(duration);
    }

    public void implicitWait(Duration duration) {
        driver.manage().timeouts().implicitlyWait(duration);
    }

    public void sendKeysAfterExplicitWait(WebElement element, int timeout,String value){
        WebElement elementToSendValue = elementToBeVisible(element,timeout);
        elementToSendValue.sendKeys(value);
    }

    public void clickAfterExplicitWait(WebElement webElement, int timeout) {
        WebElement elementToClick = elementToBeClickable(webElement,timeout);
        elementToClick.click();
    }

    public WebElement waitForElementWithFluentWait(By locator, int timeout, int pollingTime) {
        // Define Fluent Wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))       // Maximum time to wait
                .pollingEvery(Duration.ofSeconds(pollingTime))  // Frequency to check the condition
                .ignoring(NoSuchElementException.class);        // Ignore specific exceptions

        // Define the condition to wait for (Usage of Fluent wait)
        WebElement fluentwaitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return fluentwaitElement;
    }

    public WebElement waitForElementWithFluentWait(WebElement element, int timeout, int pollingTime) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement fluentwaitElement = wait.until(ExpectedConditions.visibilityOf(element));
        return fluentwaitElement;
    }

    public WebElement waitForElementWithFluentWaitUpdated(By locator, int timeout, int pollingTime) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement fluentwaitElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return fluentwaitElement;
    }

}
