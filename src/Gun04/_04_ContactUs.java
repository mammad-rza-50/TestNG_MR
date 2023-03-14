package Gun04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _04_ContactUs extends BaseDriver {

    /*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */
    @Test
    @Parameters("message")// XMl-deki pametre name-i ile eyni olmali
    void contactUs(String incomingMessage){

        WebElement contactUsBtn = driver.findElement(By
                .linkText("Contact Us"));
        contactUsBtn.click();

        WebElement enquiry = driver.findElement(By
                .id("input-enquiry"));
        enquiry.sendKeys(incomingMessage);

        WebElement submit = driver.findElement(By
                .cssSelector("[type='submit']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",submit);
        js.executeScript("arguments[0].click();",submit);

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));


    }
}
