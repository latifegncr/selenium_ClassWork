package day04_DropDownMenu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    @Test
    public void test01() {
// 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String sayfa1Handle=driver.getWindowHandle();

// 2- url'in 'amazon' icerdigini test edelim
        String actualTitle=driver.getCurrentUrl();
        assert actualTitle.contains("amazon");

// 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        String sayfa2Handle=driver.getWindowHandle();

// 4- title'in 'Best Buy' icerdigini test edelim
       String actualTitleBestbuy= driver.getTitle();
        assert actualTitleBestbuy.contains("Best Buy");

// 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(sayfa1Handle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);

// 6- arama sonuclarının 'Java' icerdigini test edelim
       WebElement aramaSonucu= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
       Assert.assertTrue(aramaSonucu.getText().contains("java"));


// 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(sayfa2Handle);

// 8- logonun gorundugunu test edelim
       WebElement logo= driver.findElement(By.xpath("(//img)[1]"));
        Assert.assertTrue(logo.isDisplayed());

    }
}
