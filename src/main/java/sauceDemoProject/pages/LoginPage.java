package sauceDemoProject.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sauceDemoProject.utils.ElementActions;
public class LoginPage {
    WebDriver driver;

    // constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // locators
    By usernameField = By.id("user-name");
    By passwordField = By.name("password");
    By loginButton = By.className("submit-button");
    String url = "https://www.saucedemo.com/";

    // actions

    // navigate to loginPage
    public void navigateToLoginPage () {
        driver.get(url);
        System.out.println("");
    }

    // Enter Username
    public void enterUsername (String user) {
        ElementActions.type(driver, usernameField, user);
        System.out.println("");
    }
    // Enter Password
    public void enterPassword (String password) {
        ElementActions.type(driver, passwordField, password);
        System.out.println("");
    }

    // Submit
    public void submit(){
        ElementActions.click(driver, loginButton);
        System.out.println("");
    }

    public String getUrl () {
        return driver.getCurrentUrl();
    }


    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        ElementActions.click(driver, loginButton);
    }

    // assertions
    


}
