package GUn07;

import Gun06._03_PlaceOrderElements;
import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_WishListPom extends BaseDriver {

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

        _03_PlaceOrderElements poe=new _03_PlaceOrderElements();

        poe.searchInput.sendKeys(text);
        poe.searchBtn.click();
        _02_WishListElements wle =new _02_WishListElements();

        int randomIpod = Tools.RandomGenerate(wle.ipodList.size());

        String ipodText = wle.ipodList.get(randomIpod).getText();
        System.out.println("ipodText = " + ipodText);

        wle.wishbtnList.get(randomIpod).click();
        wait.until(ExpectedConditions.
                elementToBeClickable(wle.wishListBtn)).click();


        Tools.ListContainsString(wle.ipodConfirmMessage, ipodText);

    }
}
