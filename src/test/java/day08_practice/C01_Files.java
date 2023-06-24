package day08_practice;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files   {

    @Test
    public void test01() {

// masaustunde bir text dosyası olusturunuz



// masaustunde text dosyasının olup olmadıgını test ediniz

        String dosyaYolu="C:\\Users\\asus\\Desktop\\deneme.TXT";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //dinamik hale getirmek
        //C:\Users\asus     +   \Desktop\deneme.TXT
       String difrent= System.getProperty("user.home");
       String publicSection="\\Desktop\\deneme.TXT";

       String fileXpath=difrent+publicSection;
       Assert.assertTrue(Files.exists(Paths.get(fileXpath)));




    }
}
