package sauceDemoProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sauceDemoProject.pages.LoginPage;

public class LoginTest {
    WebDriver driver;

   @Test
   public void validLogin() {
       LoginPage loginPage = new LoginPage(driver);

       loginPage.navigateToLoginPage();
       loginPage.enterUsername("standard_user");
       loginPage.enterPassword("secret_sauce");
       loginPage.submit();
       System.out.println(loginPage.getUrl());
   }

   @BeforeMethod
    public void setup(){
       driver= new ChromeDriver();
       driver.manage().window().maximize();

   }
}
