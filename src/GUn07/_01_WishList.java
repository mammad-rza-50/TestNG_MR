package GUn07;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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
    void Test(String text) {

        WebElement searchInput = driver.findElement(By
                .name("search"));
        searchInput.sendKeys(text);

        WebElement searchBtn = driver.findElement(By
                .cssSelector("[class='btn btn-default btn-lg"));
        searchBtn.click();
        List<WebElement> ipodList = driver.findElements(By.
                xpath("(//div[@class='caption'])//a[text()]"));
        int randomIpod = Tools.RandomGenerate(ipodList.size());

        String ipodText = ipodList.get(randomIpod).getText();// tiklanacaq elementin adini almaq
        System.out.println("ipodText = " + ipodText);

        List<WebElement> wishbtnList = driver.findElements(By.
                xpath("//button[@data-original-title='Add to Wish List']"));
        wishbtnList.get(randomIpod).click(); //random elementin wish ine tiklatmaq

        wait.until(ExpectedConditions.elementToBeClickable(By.
                id("wishlist-total"))).click();

        List<WebElement> ipodConfirmMessage = driver.findElements(By.
                cssSelector("[class='text-left']>a"));

        Tools.ListContainsString(ipodConfirmMessage, ipodText);

    }
}
