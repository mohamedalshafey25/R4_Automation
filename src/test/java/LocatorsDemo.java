import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorsDemo {
    WebDriver driver = new ChromeDriver();

    By locator = By.cssSelector("[data-test='username']");

    @Test
    public void testLocators() {
        driver.findElement(locator);


    }
}

/**
 css selectors
     id - #id                 > By.cssSelector("#user-name");
     class - .className       > By.cssSelector(".input_error");
     tagname - tagName        > By.cssSelector("input");
     [attribute='value']      > By.cssSelector("[placeholder='Username']");

// xpath

     //tagName[@attribute='value']        > //input[@data-test='username']

    //tagName
    //tagName[@attribute]
    //*[@attribute='value']
    //tagName/childTagName
    //tagName//grandChildTagName
    //*[contains(@attribute,'partialValue')]    > //input[contains(@placeholder,'User')]
    //tagname[@attribute1='value1']/tagname[@attribute2='value2']    > //input[@data-test='username' and @placeholder='Username']


 */
