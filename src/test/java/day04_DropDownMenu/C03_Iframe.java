package day04_DropDownMenu;
/*
elenium'da Actions sınıfı, web tarayıcısında çeşitli eylemleri gerçekleştirmek için kullanılan bir sınıftır.
Bu sınıf, kullanıcıların fare ve klavye etkileşimlerini taklit etmelerine olanak tanır.
Actions sınıfı, web tarayıcısında fareyi hareket ettirme, tıklama, sağ tıklama, metin yazma,
sürükle ve bırak gibi bir dizi eylemi gerçekleştirmek için kullanılabilir.
Ayrıca klavye kısayolları, tuşa basma ve bırakma gibi klavye eylemlerini de taklit etmenizi sağlar.
Actions sınıfı, Selenium WebDriver API'sinin bir parçasıdır ve birden fazla eylemi bir araya getirerek
daha karmaşık etkileşimler oluşturmanıza olanak tanır. Örneğin, bir element üzerine fareyle tıkladıktan sonra
bir menüyü açabilir ve ardından menüdeki bir öğeye tıklayabilirsiniz.

        Play'i dogru locate edip click yamamıza ragmen videoyu calıstırmadı
        bunun üzerine HTML kodlarını inceleyince
        play'in aslında iframe icerisinde oldugunu gördük
        bu durumda once iframe'i locate edip
        switchTo() ile iframe gecmeliyiz
*/


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Iframe extends TestBase {
    @Test
    public void test01(){
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN , Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        driver.switchTo().frame(0);
        //****driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        WebElement play=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();
        // Videoyu calistirdiginizi test ediniz
        Assert.assertTrue(play.isEnabled());


         /*
        Play'i dogru locate edip click yamamıza ragmen videoyu calıstırmadı
        bunun üzerine HTML kodlarını inceleyince
        play'in aslında iframe icerisinde oldugunu gördük
        bu durumda once iframe'i locate edip
        switchTo() ile iframe gecmeliyiz
         */

        // Videoyu calistirdiginizi test ediniz
        Assert.assertTrue(play.isEnabled());
        //Assert.assertTrue(driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']")).isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']")).isDisplayed());


    }
}