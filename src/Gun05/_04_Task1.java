package Gun05;

import Utility.BaseDriver;
import Utility.BaseDriverParametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static Utility.BaseDriver.driver;

public class _04_Task1 extends BaseDriver {

    /**
     * Daha önceki derslerde yaptğımız Search fonksiyonunu
     * mac,ipod ve samsung için Dataprovider ile yapınız.
     */

    @Test(dataProvider = "phones")
    @Parameters()
    void SearchFunction(String text) {

        WebElement searchInput = driver.findElement(By
                .cssSelector("[name='search']"));
        searchInput.clear();
        searchInput.sendKeys(text);

        WebElement searchBtn = driver.findElement(By
                .cssSelector("[class='btn btn-default btn-lg"));
        searchBtn.click();
        List<WebElement> captions = driver.findElements(By.
                cssSelector("div[class='caption']>h4"));

        for (WebElement capt : captions)
            Assert.assertTrue(capt.getText().toLowerCase().contains(text.toLowerCase()));

    }

    @DataProvider
    public Object[] phones() {

        Object[] phone = {"mac", "samsung", "ipod"};

        return phone;
    }

}
