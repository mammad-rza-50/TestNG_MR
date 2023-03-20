package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Tools {

    public static void Wait(int sn) {
        try {
            Thread.sleep(1000 * sn); // ms beklediği
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void successMessageValidation() {

        WebElement msjLabel = BaseDriver.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(msjLabel.getText().toLowerCase().contains("success"));
    }

    public static int RandomGenerate(int max) {
        return (int) (Math.random() * max);
    }

    public static void ListContainsString(List<WebElement> list, String searchWord) {

        boolean isHave = false;
        for (WebElement we : list) {
            if (we.getText().toLowerCase().
                    contains(searchWord.toLowerCase())) {

                isHave = true;
                break;
            }
        }
        if (isHave == false) {
            Assert.fail();
        }
    }
}
