package day02_DropDown;

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

public class C01_DropDown {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {

        driver.close();

    }

    @Test
    public void test01() throws InterruptedException {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        Thread.sleep(3000);


        // dropdown'dan "Books" secenegini secin

        //Dropdown 3 adimda handle edilir

        //1)Dropdown locate edilir
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));//locate ettik

        //2)Select objesi olusturulu
        Select select = new Select(ddm);//objeyi olusturduk

        //3) seceneklerden biri secilir
        //select.selectByVisibleText("Books");//nasil görünüyorsa o sekilde paranteze yazilmalidir.
        //select.selectByIndex(5);
        //select.selectByValue("search-alias=stripbooks-intl-ship");

        ddm.sendKeys("Books");

        Thread.sleep(3000);


        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        Thread.sleep(3000);


        // arama sonuclarinin Java icerdigini test edin

        WebElement aramaSonucElementi = driver.
                findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String aramaSonucGezisi = aramaSonucElementi.getText();

        Assert.assertTrue(aramaSonucGezisi.contains("Java"));

        Thread.sleep(3000);


    }
}