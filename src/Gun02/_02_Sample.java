package Gun02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Sample extends BaseDriver {

    @Test
    void logonTest(){
        System.out.println("Test1 worked");

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement userName= driver.findElement(By.id("input-email"));
        userName.sendKeys("blackmamed246@gmail.com");

        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("Tna250111sdet");

        WebElement login = driver.findElement(By.cssSelector("input[type='submit']"));
        login.click();

       Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));
        // belede olur
        Tools.Wait(5);

    }


}
