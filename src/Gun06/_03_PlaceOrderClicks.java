package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_PlaceOrderClicks extends BaseDriver {


    @Test
    void ProceedToCheckout() {

        _03_PlaceOrderElements elements = new _03_PlaceOrderElements();

        elements.searchInput.sendKeys("ipod");
        elements.searchBtn.click();
        elements.addToCart.click();
        elements.shoppingCart.click();
        elements.checkout.click();


        wait.until(ExpectedConditions.elementToBeClickable(elements.paymentAddress)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.shippingAddress)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.shippingMethod)).click();
        elements.checkbox.click();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", elements.paymentmethod);
        wait.until(ExpectedConditions.elementToBeClickable(elements.paymentmethod)).click();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", elements.confirmOrder);
        wait.until(ExpectedConditions.elementToBeClickable(elements.confirmOrder)).click();

        wait.until(ExpectedConditions.urlContains("success"));


        Assert.assertEquals(elements.message.getText(), "Your order has been placed!", "Qebul texti tapilmadi");

    }
}