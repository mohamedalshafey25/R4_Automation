package automationBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GetElementsInfo {

    WebDriver driver;
    WebDriverWait wait;

    // get element info like tag name, text, attribute value, css value, location, size, etc.
    @Test
    public void getElementInfo() {
        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.name("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));
        WebElement logo = driver.findElement(By.className("login_logo"));

        // getting the placeholder to verify it is Username and Password
        String userNamePlaceholder = userName.getDomAttribute("placeholder");
        System.out.println(userNamePlaceholder);

        String passwordPlaceholder = password.getDomAttribute("placeholder");
        System.out.println(passwordPlaceholder);

        // typing into username and password fields
        userName.sendKeys("Mohamed");
        password.sendKeys("secret_password");

        // getting the run time value of the type attribute to verify it is password field
        String userNameRunTime = userName.getDomProperty("value");
        System.out.println(userNameRunTime);

        String passwordRunTime = password.getDomProperty("value");
        System.out.println(passwordRunTime);

        System.out.println(submitButton.getText());
        System.out.println(logo.getText());
        String actualErrorColor = logo.getCssValue("color");
        String expectedErrorColor = "#fff";
        Assert.assertEquals(actualErrorColor, expectedErrorColor );

    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

