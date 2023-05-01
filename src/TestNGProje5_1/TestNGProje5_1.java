package TestNGProje5_1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;

public class TestNGProje5_1 extends BaseDriver_TesNGProje5_1{
    
    TestNGProje5_1_POM tpp = new TestNGProje5_1_POM();

    @Test
    void Test1() {
        Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
    }

    @Test
    void Test2() {

        wait.until(ExpectedConditions.visibilityOf(tpp.leftnavMenus.get(0)));

        for (WebElement a : tpp.leftnavMenus) {
            a.click();
      
            for (WebElement b : tpp.underLeftnavMenus) {
                Assert.assertTrue(b.isDisplayed());
            }
        }

    }

    @Test
    @Parameters("mail")
    void Test3(String text) throws AWTException {
        Robot rbt = new Robot();
        
        wait.until(ExpectedConditions.visibilityOf(tpp.leftnavMenus.get(0)));
        tpp.leftnavMenus.get(2).click();
        wait.until(ExpectedConditions.elementToBeClickable(tpp.underLeftnavMenus.get(0)));
        tpp.underLeftnavMenus.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(tpp.addNewCustomer));
        tpp.addNewCustomer.click();
        if(tpp.customerCard.getAttribute("class").contains("collapsed")) {
            tpp.customerCard.click();
        }
        wait.until(ExpectedConditions.visibilityOf(tpp.emailBox));
        tpp.emailBox.sendKeys(text);
        tpp.passwordBox.sendKeys("group10");
        tpp.firstNameBox.sendKeys("Memmed");
        tpp.lastNameBox.sendKeys("Rzayev");
        tpp.maleCheckbox.click();
        tpp.birthDate.sendKeys("08.16.1980");
        tpp.companyName.sendKeys("Group10");
        tpp.taxExemptBox.click();
        tpp.newsLetter.click();
        rbt.keyPress(KeyEvent.VK_DOWN);
        rbt.keyRelease(KeyEvent.VK_DOWN);
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);
        Select vendor = new Select(tpp.vendorSelect);
        vendor.selectByIndex(1);
        tpp.commentBox.sendKeys("group10");
        tpp.saveButton.click();
        Assert.assertTrue(tpp.successMsg.getText().contains("successfully"));
    }

    @Test
    @Parameters("mail")
    void Test4(String text) {
 
        wait.until(ExpectedConditions.visibilityOf(tpp.leftnavMenus.get(0)));
        tpp.leftnavMenus.get(2).click();
        tpp.underLeftnavMenus.get(0).click();
        if(!tpp.searchRowCustomer.getAttribute("class").contains("opened")) {
            tpp.searchRowCustomer.click();
        }
        wait.until(ExpectedConditions.visibilityOf(tpp.searchEmail));
        tpp.searchEmail.sendKeys(text);
        tpp.searchFirstName.sendKeys("Memmed");
        tpp.searchLastName.sendKeys("Rzayev");
        tpp.customerSearchBtn.click();
        tpp.editBtn.click();
        if(tpp.customerCard.getAttribute("class").contains("collapsed")) {
            tpp.customerCard.click();
        }
        wait.until(ExpectedConditions.visibilityOf(tpp.firstNameBox));
        tpp.firstNameBox.clear();
        tpp.firstNameBox.sendKeys("Nuru");
        tpp.saveButton.click();
        Assert.assertTrue(tpp.successMsg.getText().contains("successfully"));
    }

    @Test
    @Parameters("mail")
    void Test5(String text) {
  
        wait.until(ExpectedConditions.visibilityOf(tpp.leftnavMenus.get(0)));
        tpp.leftnavMenus.get(2).click();
        tpp.underLeftnavMenus.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(tpp.searchEmail));
        tpp.searchEmail.sendKeys(text);
        tpp.searchFirstName.sendKeys("Memmed");
        tpp.searchLastName.sendKeys("Rzayev");
        tpp.customerSearchBtn.click();
        tpp.editBtn.click();
        if(tpp.customerCard.getAttribute("class").contains("collapsed")) {
            tpp.customerCard.click();
        }
        wait.until(ExpectedConditions.visibilityOf(tpp.customerDeleteBtn));
        tpp.customerDeleteBtn.click();
        tpp.customerDeleteBtn2.click();
        Assert.assertTrue(tpp.successMsg.getText().contains("successfully"));
    }

    @Test
    void Test6() {

        tpp.homepageSearch.sendKeys("Shipments");
        tpp.shipmentSearchOption.click();
        Assert.assertTrue(tpp.displayText.getText().contains("Shipments"));
    }

}
