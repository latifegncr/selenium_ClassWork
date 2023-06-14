package automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class LoginUserWithCorrectEmailAndPassword extends TestBase {

    @Test
    public void test01() {

//        1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        driver.findElement(By.xpath("(//a[@href='/'])[2]"));

//4. Click on 'Signup / Login' button
        //driver.findElement(By.linkText("/login")).click();
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//5. Verify 'Login to your account' is visible
       WebElement loginVisible= driver.findElement(By.xpath("(//h2)[1]"));
       loginVisible.isDisplayed();
//6. Enter correct email address and password

//        7. Click 'login' button
//        8. Verify that 'Logged in as username' is visible
//        9. Click 'Delete Account' button
//        10. Verify that 'ACCOUNT DELETED!' is visible











    }
}
