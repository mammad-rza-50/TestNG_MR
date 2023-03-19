package GUn07;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_WishList extends BaseDriver {

    /*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */


    @Test
    @Parameters("findText")
    void Test(String text){

        WebElement searchInput = driver.findElement(By
                .name("search"));
        searchInput.sendKeys(text);

        WebElement searchBtn = driver.findElement(By
                .cssSelector("[class='btn btn-default btn-lg"));
        searchBtn.click();

        List<WebElement> ipodList =driver.findElements(By.
                xpath("(//button[@data-original-title='Add to Wish List'])/i"));
       WebElement randomIpod= ipodList.get((int)(Math.random()*3));
       randomIpod.click();



    }
}
