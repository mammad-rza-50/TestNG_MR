package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_PlaceOrder extends BaseDriver {

    /*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan ilkini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Checkout yapınız.
   6- Continue butonalarına tıklatıp bilgileri giriniz.
   7- En confirm ile siparişi verdiğinizi doğrulayınız.
      doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
*/
    @Test
    void Test() {
        WebElement searchInput = driver.findElement(By
                .cssSelector("[name='search']"));
        searchInput.sendKeys("ipod");

        WebElement searchBtn = driver.findElement(By
                .cssSelector("[class='btn btn-default btn-lg"));
        searchBtn.click();

        WebElement addToCart = driver.findElement(By
                .xpath("//span[text()='Add to Cart']"));
        addToCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("shopping cart")));
        WebElement shoppingCart = driver.findElement(By.linkText("shopping cart"));
        shoppingCart.click();
        WebElement checkout = driver.findElement(By.linkText("Checkout"));
        checkout.click();
        WebElement contunie1 = wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//input[@id='button-payment-address']")));
        contunie1.click();
        WebElement contunie2 = wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//input[@id='button-shipping-address']")));
        contunie2.click();
        WebElement contunie3 = wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//input[@id='button-shipping-method']")));
        contunie3.click();
        WebElement checkbox=driver.findElement(By.xpath("//input[@name='agree']"));
        checkbox.click();
        WebElement contunie4 = wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//input[@id='button-payment-method']")));
        contunie4.click();
        WebElement confirmOrder = wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//input[@id='button-confirm']")));
        confirmOrder.click();

        wait.until(ExpectedConditions.urlContains("success"));

        WebElement message = driver.findElement(By.xpath("(//div[@id='content'])/h1"));

        Assert.assertEquals(message
                .getText(),"Your order has been placed!","Qebul texti tapilmadi");

    }
}