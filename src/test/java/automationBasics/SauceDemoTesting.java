package automationBasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceDemoTesting {


    @Test
    public void login() {
        System.out.println("Test 1");

        // capture the actual number of items on cart and store it in a variable N
    }

    @Test (dependsOnMethods = "login")
    public void addToCart1() {
        System.out.println("Test 2");
    }
    @Test (dependsOnMethods = {"login","addToCart1"})
    public void addToCart2() {
        System.out.println("Test 2");
    }
    @Test (dependsOnMethods = {"login","addToCart1","addToCart2"})
    public void removeFromCart1() {
        System.out.println("Test 2");
    }
    @Test (dependsOnMethods = "removeFromCart1")
    public void removeFromCart2() {
        System.out.println("Test 2");
    }

    @Test (dependsOnMethods = "removeFromCart2")
    public void logout() {
        System.out.println("Test 1");

        // capture the actual number of items on cart and store it in a variable N
    }




    public void clickWithWait() {

    }
    public void typeWithWait() {

    }


    @BeforeClass
    public void setup() {
        System.out.println("Before class");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After class");
    }
}
