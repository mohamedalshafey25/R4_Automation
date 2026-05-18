package sauceDemoProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import sauceDemoProject.base.DriverFactory;
import sauceDemoProject.pages.LoginPage;
public class LoginDataProvider {

    WebDriver driver;

    @Test (dataProvider = "loginData")
    public void LoginTest(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.navigateToLoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.submit();
        System.out.println(loginPage.getUrl());
        System.out.println("Username: " + username + " | Password: " + password);
    }

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
        System.out.println("Browser: " + browser);
    }
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }
}
