package TestNG_Proje_05;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Proje05 extends BaseDriver_TestNG_Proje05 {

    TestNG_Proje05_POM tpp = new TestNG_Proje05_POM();

    @Test(priority = 1)
   // @Parameters({"username", "password"})
    void TestCase1() {

      //  driver.get("https://test.mersys.io/");

//        tpp.username.clear();
//        tpp.username.sendKeys(usernameStr);
//        tpp.password.clear();
//        tpp.password.sendKeys(passwordStr);
//        tpp.loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(tpp.messajTechnoStudy));
        Assert.assertTrue(tpp.messajTechnoStudy.getText().
                contains("Techno Study"), "Log in failed");
    }

//    @Test(priority = 2)
//    void TestCase2() {
//
//        wait.until(ExpectedConditions.visibilityOf(tpp.leftMenuList.get(0)));
//
//        for (WebElement lm : tpp.leftMenuList) {
//
//            lm.click();
//            for (WebElement ulm : tpp.underLeftMenuList) {
//
//                Assert.assertTrue(ulm.isDisplayed());
//            }
//        }

//   }
}
