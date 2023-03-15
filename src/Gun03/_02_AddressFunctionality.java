package Gun03;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AddressFunctionality extends BaseDriver {

    /*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son adresi siliniz.
 */

    @Test
    void addAddress() {

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();
        WebElement newAddress = driver.findElement(By.linkText("New Address"));
        newAddress.click();
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Memmed");
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Rzayev");
        WebElement company = driver.findElement(By.id("input-company"));
        company.sendKeys("MR");
        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.sendKeys("Saray teze mehelle");
        WebElement address2 = driver.findElement(By.id("input-address-2"));
        address2.sendKeys("Saray Heyder Eliyev");
        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("Abseron");
        WebElement postCode = driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("0121");
        WebElement webCountry = driver.findElement(By.id("input-country"));
        Select county = new Select(webCountry);
        county.selectByVisibleText("Azerbaijan");
        // selectByVisibleText : findElement kimi islediyinden
        // implicity waiti istifade edirik

        // second path
        wait.until(ExpectedConditions.elementToBeClickable(webCountry));

        // first path

//        WebElement options =driver.findElement(By
//                .cssSelector("select[id=input-zone]>option"));
        //        // state secmek ucun
//        wait.until(ExpectedConditions.stalenessOf(options));
        WebElement webState = driver.findElement(By.id("input-zone"));
        Select state = new Select(webState);
        // state.selectByVisibleText("Abseron");
        // state.selectByValue("209");
        // selectByValue : findElement kimi islediyinden
        // implicity waiti istifade edirik
        state.selectByIndex(1);
        //tez tapdim erken itirdim
        //selectByIndex: implicity waitle islemir ancaq
        // Explicity wait ile isleyir

        WebElement defaultAddress = driver.findElement(By
                .xpath("//input[@value='1']"));
        defaultAddress.click();

        WebElement contunieBtn = driver.findElement(By
                .xpath("//input[@value='Continue']"));
        contunieBtn.click();

        Tools.successMessageValidation();

    }

    @Test(dependsOnMethods = {"addAddress"})
    void editAddress() {

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement edit = driver.findElement(By.linkText("Edit"));
        edit.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("Mammad");
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
        lastName.sendKeys("Rza");
        WebElement contunieBtn = driver.findElement(By
                .xpath("//input[@value='Continue']"));
        contunieBtn.click();

        Tools.successMessageValidation();

    }

    @Test(dependsOnMethods = {"editAddress"})
    void deleteAddress() {

        WebElement addressBook = driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> deleteAll = driver.findElements(By.linkText("Delete"));
        WebElement eraseableAddress = deleteAll.get(deleteAll.size() - 2);// siline bilir ikinci
        eraseableAddress.click();

        Tools.successMessageValidation();

    }
}
