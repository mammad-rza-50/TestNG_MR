package GUn07;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_WishListElements {

    /*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */

    public _02_WishListElements() {

        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "(//div[@class='caption'])//a[text()]")
    List<WebElement> ipodList;

    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    List<WebElement> wishbtnList;

    @FindBy(id = "wishlist-total")
    WebElement wishListBtn;

    @FindBy(css = "[class='text-left']>a")
    List<WebElement> ipodConfirmMessage;

}

