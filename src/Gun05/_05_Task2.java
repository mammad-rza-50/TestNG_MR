package Gun05;

import Utility.BaseDriverParametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _05_Task2 extends BaseDriverParametrs {

    /**
     * Bir önceki task da yapılan testi PARAMETERDRIVER ile yapınız
     * sonrasında fakrlı tarayıcılar ile çalıştırınız. (crossbrowser)
     * sonrasında paralel çalıştırınız.(parallel)
     */

    @Test(dataProvider = "phones")
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
