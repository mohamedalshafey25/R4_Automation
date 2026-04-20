package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverMethods {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.navigate().to("https://www.selenium.dev/documentation/webdriver/getting_started/");
        driver.close();
        driver.close();
        driver.get("");
        driver.navigate().refresh();
        String ps = driver.getPageSource();
        String ActualTitle = driver.getTitle();
        String expectedTitle = "Getting Started | Selenium";

        System.out.println(ActualTitle);

        driver.navigate().refresh();
        driver.navigate().forward();
        driver.navigate().back();

        driver.quit();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String wh = driver.getWindowHandle();
        driver.switchTo().window(wh);
        driver.getWindowHandles();

        driver.getCurrentUrl();
        driver.findElement(By.id("123")).click();
        WebElement searchButton = driver.findElement(By.className("searchClass"));
        searchButton.click();
        searchButton.sendKeys("Selenium WebDriver");
        driver.findElements(By.name("searchResuls")).size();

        driver.navigate().to("https://www.selenium.dev/documentation/webdriver/getting_started/");
        By searchBoxLocator = By.id("searchBox");
        By searchButtonLocator = By.className("searchButton");
        driver.findElement(searchBoxLocator).sendKeys("Selenium WebDriver");
        driver.findElement(searchButtonLocator).click();
//        Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title does not match expected value.");
        driver.quit();




    }
}
