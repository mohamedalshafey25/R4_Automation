package sauceDemoProject.utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ElementActions {
    // waits
    // wait for element to be visible and enabled
    public static WebElement waitForVisibleAndEnabled(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> {
                        WebElement element = d.findElement(locator);
                        return (element.isDisplayed() && element.isEnabled()) ? element : null;
                });
    }

    // click with wait for visibility and enabled
    public static void click(WebDriver driver, By locator) {
        WebElement element = waitForVisibleAndEnabled(driver, locator);

        element.click();
        System.out.println("Clicked on element located by: " + locator);
    }

    // type with wait for visibility and enabled
    public static void type(WebDriver driver, By locator, String text) {
        WebElement element = ElementActions.waitForVisibleAndEnabled(driver, locator);
        element.clear();
        element.sendKeys(text);
        System.out.println("Typed '" + text + "' into element located by: " + locator);
    }

    // getText of element

    // getDomProperty


}



