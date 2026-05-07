import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitDemo {

    WebDriver driver;
    Wait<WebDriver> wait;

    String url = "https://www.selenium.dev/selenium/web/dynamic.html";
    By revealInputButtonLocator = By.id("reveal");
    By revealedInputLocator = By.id("revealed");

    // test method to demonstrate custom explicit wait using FluentWait
    @Test
    public void testCustomExplicitWait() {
        driver.navigate().to(url);
        driver.findElement(revealInputButtonLocator).click();
        wait.until(d -> {
            driver.findElement(revealedInputLocator).sendKeys("Hello after Fluent Wait!");
            return true;
        });

    }

    @BeforeMethod
    public void beforeMethod() {
        // Initialize your WebDriver and FluentWait here

        driver = new ChromeDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    @AfterMethod
    public void afterMethod() {
        // Quit the WebDriver here
        if (driver != null) {
            driver.quit();
        }
    }
}


