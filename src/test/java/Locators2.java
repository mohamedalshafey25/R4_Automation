import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Locators2 {
    WebDriver driver;
    Wait<WebDriver> wait;

    // X using WebElement to save element itself after finding it
    // WebElement userName = driver.findElement(By.id("user-name"));
    // userName.sendKeys(); // WebElement

    // saving static locators
    By userNameLocator = By.id("user-name");
    By passwordLocator = By.name("password");
    By loginButtonLocator = By.className("submit-button");
    String url = "https://www.selenium.dev/selenium/web/dynamic.html";

    @Test (enabled = false)
    public void validLoginTest() {
        driver.get(url);
        driver.findElement(userNameLocator).sendKeys("standard_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(loginButtonLocator).click();

        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Wrong Title");
    }

    @Test
    public void addNewBoxAndClick()  {
        driver.get(url);
        driver.findElement(By.id("adder")).click();
//        Thread.sleep(5000);
        driver.findElement(By.id("box0")).click();

    }


    @Test
    public void clickRevealedInputX(){
        By revealButtonLocator = By.id("reveal");
        By revealedInputLocator = By.id("revealed");

        driver.get(url);
        driver.findElement(revealButtonLocator).click();
        driver.findElement(revealedInputLocator).sendKeys("Hello");
    }

    @Test
    public void clickRevealedInput(){
        By revealButtonLocator = By.id("reveal");
        By revealedInputLocator = By.id("revealed");

        driver.get(url);
        driver.findElement(revealButtonLocator).click();
        WebElement revealed = driver.findElement(revealedInputLocator);

        wait.until(d -> revealed.isDisplayed());
        revealed.sendKeys("Hello");

    }


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();

        //implicitlyWait
//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // explicitWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
