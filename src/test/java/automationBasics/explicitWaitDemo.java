package automationBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class explicitWaitDemo {

    WebDriver driver;
    Wait<WebDriver> wait;

    By revealButtonLocator = By.id("reveal");
    By revealedInputLocator = By.id("revealed");
    String url = "https://www.selenium.dev/selenium/web/dynamic.html";

    @Test
    public void revealHiddenInputAndType() {
        driver.get(url);
        driver.findElement(revealButtonLocator).click();


        wait.until(d -> driver.findElement(revealedInputLocator).isDisplayed());
        driver.findElement(revealedInputLocator).sendKeys("After revealed");

        // explicit wait with expected conditions
        wait.until(ExpectedConditions.elementToBeClickable(revealButtonLocator)).click();
    }

    // helper method for clicking with explicit wait
    public void clicking(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        System.out.println("Clicked on element located by: " + locator);
    }

    // helper method for typing with explicit wait
    public void typing(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
        System.out.println("Typed '" + text + "' into element located by: " + locator);
    }

    // helper navigation method
    public void navigateToUrl(String url) {
        driver.get(url);
        System.out.println("Navigated to URL: " + url);
    }

    // using helper methods in the test
    @Test
    public void revealHiddenInputAndTypeWithHelpers() {
        navigateToUrl(url);
        clicking(revealButtonLocator);
        typing(revealedInputLocator, "After revealed with helpers");

    }

    // explicit wait with ExpectedConditions for multiple conditions
    @Test
    public void waitingForMultipleConditionsWithExpectedConditions() {
        navigateToUrl(url);
        clicking(revealButtonLocator);

        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(revealedInputLocator),
                ExpectedConditions.elementToBeClickable(revealedInputLocator)
        ));

        driver.findElement(revealedInputLocator).sendKeys("After waiting for multiple conditions");
    }



    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Initialize the explicit wait with a timeout of 10 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
