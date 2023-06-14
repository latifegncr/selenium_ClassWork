package automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase01_RegisterUser {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
    driver.close();
    }

    @Test
    public void test01() {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
          driver.get("http://automationexercise.com");


//        3. Verify that home page is visible successfully
WebElement home=driver.findElement(By.xpath("//*[@sytle='color']"));
Assert.assertTrue(home.isDisplayed());

//        4. Click on 'Signup / Login' button
driver.findElement(By.xpath("a[@href='/login']")).click();

//        5. Verify 'New User Signup!' is visible
WebElement newsingUp=driver.findElement(By.xpath("//h2)[3]"));
Assert.assertTrue(newsingUp.isDisplayed());

//        6. Enter name and email address
//        7. Click 'Signup' button
driver.findElement(By.name("name")).sendKeys("latife", Keys.TAB,"gencer",Keys.TAB,Keys.ENTER);

//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
WebElement account=driver.findElement(By.xpath("//b"));
Assert.assertTrue(account.isDisplayed());

//        9. Fill details: Title, Name, Email, Password, Date of birth
WebElement radioButton=driver.findElement(By.id("id_gender1"));
radioButton.click();
radioButton.sendKeys(Keys.TAB,"latife@gmail.com",Keys.TAB,"password",Keys.TAB);

WebElement ddm=driver.findElement(By.id("days"));
Select select=new Select(ddm);
select.selectByIndex(4);
ddm.sendKeys(Keys.TAB,"May",Keys.TAB,"2023");


//WebElement title=driver.findElement(By.xpath("//label[text()='Title']"));
//driver.findElement(with(By.tagName("div")).below(title)).click();
//10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.cssSelector("input[id='newsletter']")).click();

//11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkBox= driver.findElement(By.cssSelector("input#optin"));
        checkBox.click();//
// 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
checkBox.sendKeys(Keys.TAB,"TAB",Keys.TAB,"CAN",Keys.TAB,"TAB COMPANY",Keys.TAB,"company",Keys.TAB,"canada",Keys.TAB,"Zipcode",Keys.TAB,"Zipcode",Keys.TAB,"Zipcode4",Keys.TAB,"NUMBER",Keys.TAB,"Mobile Number");

//        13. Click 'Create Account button'
WebElement createdAccount=driver.findElement(By.xpath("//b"));
Assert.assertTrue(createdAccount.isDisplayed());

//        14. Verify that 'ACCOUNT CREATED!' is visible


//        15. Click 'Continue' button



//        16. Verify that 'Logged in as username' is visible



//        17. Click 'Delete Account' button



//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button




    }
}
