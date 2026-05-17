package automationBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsClassDemo {
    // locators
    By user1 = By.xpath("//div[@class='example']/div[1]");
    By user2 = By.xpath("//div[@class='example']/div[2]");
    By user3 = By.xpath("//div[@class='example']/div[3]");

    WebDriver driver;
    Actions action;

    @Test
    public void HoveringTest() {
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");
        WebElement user1Element = driver.findElement(user1);

        action.moveToElement(user1Element).perform(); // hover over the element
        System.out.println(driver.findElement(By.linkText("View profile")).getText()); // get the text of the link that appears after hovering
        driver.findElement(By.linkText("View profile")).click(); // click on the link that appears after hovering
    }

    @Test
    public void draggingAndDroppingTest() throws InterruptedException {
        driver.navigate().to("https://crossbrowsertesting.github.io/drag-and-drop.html");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        action.dragAndDrop(source, target).perform(); // drag source and drop it on target
        Thread.sleep(5000);
    }

    @Test
    public void rightClickTest() {
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform(); // right click on the box
    }

    @Test
    public void doubleClickTest() {
        driver.navigate().to("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0); // switch to the iframe that contains the element to double click
        WebElement box = driver.findElement(By.cssSelector("body > div"));
        action.doubleClick(box).perform(); // double click on the box
    }


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        action = new Actions(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

