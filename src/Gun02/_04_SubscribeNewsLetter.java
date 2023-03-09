package Gun02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class _04_SubscribeNewsLetter extends BaseDriver {

    /*
      Senaryo
      1- Siteyi açınız.
      2- Newsletter  Subscribe işlemini abone olunuz(YES)
      3 - ayri bir site ile siteden cikin
      4-NewsLetter subscribe durumunu kontrol edin Yes ise No , No ise Yes edin
     */

    By link = By.linkText("Newsletter");
    By sunYes = By.xpath("//input[@value='1']");
    By sunNo = By.xpath("//input[@value='0']");
    By contBtn = By.xpath("//input[@value='Continue']");

    @Test(priority = 1)
    void subscribeFunctionYes() {

        WebElement newLetterLink = driver.findElement(link);
        newLetterLink.click();

        WebElement subscribeYes = driver.findElement(sunYes);
        subscribeYes.click();

        WebElement contunieBtn = driver.findElement(contBtn);
        contunieBtn.click();

        Tools.successMessageValidation();

    }

    @Test(priority = 2)
    void subscribeFunctionNo() {

        WebElement newLetterLink = driver.findElement(link);
        newLetterLink.click();

        WebElement subscribeNo = driver.findElement(sunNo);
        subscribeNo.click();

        WebElement contunieBtn = driver.findElement(sunNo);
        contunieBtn.click();

        Tools.successMessageValidation();

    }

    @Test(priority = 3)
    void subscribeFunctionForBoth() {

        WebElement newLetterLink = driver.findElement(link);
        newLetterLink.click();

        WebElement subscribeYes = driver.findElement(sunYes);
        WebElement subscribeNo = driver.findElement(sunNo);

        if (subscribeYes.isSelected())
            subscribeNo.click();
        else subscribeYes.click();

        WebElement contunieBtn = driver.findElement(contBtn);
        contunieBtn.click();

        Tools.successMessageValidation();

    }
}