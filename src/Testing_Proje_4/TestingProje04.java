package Testing_Proje_4;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class TestingProje04 extends BaseDriver {


    @Test(priority = 1)
    @Parameters({"name", "lastname", "email", "password"})
    void RegistrationTest(String name, String lastname, String email, String password) {

        driver.get(" https://demo.nopcommerce.com/");

        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .id("gender-male"))).click();
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys(name);
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys(lastname);
        WebElement dateOfBirthDay = driver.findElement(By
                .xpath("//select[@name='DateOfBirthDay']"));
        Select selectDate = new Select(dateOfBirthDay);
        selectDate.selectByValue("16");
        WebElement dateOfBirthMonth = driver.findElement(By
                .xpath("//select[@name='DateOfBirthMonth']"));
        Select selectMonth = new Select(dateOfBirthMonth);
        selectMonth.selectByValue("8");
        WebElement dateOfBirthYear = driver.findElement(By
                .xpath("//select[@name='DateOfBirthYear']"));
        Select selectYear = new Select(dateOfBirthYear);
        selectYear.selectByValue("1980");
        WebElement mail = driver.findElement(By.id("Email"));
        mail.sendKeys(email);
        WebElement password1 = driver.findElement(By.id("Password"));
        password1.sendKeys(password);
        WebElement password2 = driver.findElement(By.id("ConfirmPassword"));
        password2.sendKeys(password);
        WebElement registerBtn = driver.findElement(By.id("register-button"));
        registerBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//div[text()='Your registration completed']")));
        WebElement message = driver.findElement(By.
                xpath("//div[text()='Your registration completed']"));

        Assert.assertEquals(message.getText(),
                "Your registration completed", "Your registration failed");

    }

    @Test(priority = 2, dependsOnMethods = {"RegistrationTest"})
    @Parameters({"email", "password"})
    void LoginTest(String email, String password) {

        driver.get("https://demo.nopcommerce.com/");
        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        WebElement mail = driver.findElement(By.id("Email"));
        mail.sendKeys(email);
        WebElement password1 = driver.findElement(By.id("Password"));
        password1.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.
                xpath("//button[text()='Log in']"));
        loginBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                xpath("//a[text()='Log out']")));
        WebElement message1 = driver.findElement(By.
                xpath("//a[text()='Log out']"));
        Assert.assertEquals(message1.getText(), "Log out", "Log in failed");
        message1.click();
    }

    @Test(priority = 3, dataProvider = "UserDatas")
    void DataProviderLogin(String mailru, String password11) {

        driver.get("https://demo.nopcommerce.com/");

        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();
        String loginStr = driver.getCurrentUrl();
        System.out.println("loginStr = " + loginStr);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        WebElement mail = driver.findElement(By.id("Email"));
        mail.clear();
        mail.sendKeys(mailru);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password")));
        WebElement password1 = driver.findElement(By.id("Password"));
        password1.sendKeys(password11);

        WebElement loginBtn = driver.findElement(By.
                xpath("//button[text()='Log in']"));
        loginBtn.click();

        String logoutStr = driver.getCurrentUrl();

        Assert.assertEquals(logoutStr, "https://demo.nopcommerce.com/", "Log out Failed");

        if (loginStr.equals(logoutStr)) {
            System.out.println("login = " + login);
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                    linkText("Log out")));
            WebElement logoutBtn = driver.findElement(By.
                    linkText("Log out"));
            logoutBtn.click();
        }
    }

    @DataProvider
    public Object[][] UserDatas() {

        Object[][] datas = {
                {"blackmamed_253@mail.ru", "1234567"},
                {"blackmamed_246@mail.ru", "1234567"},
                {"blackmamed_258@mail.ru", "1234567"},
                {"blackmamed_252@mail.ru", "2234567"}
        };
        return datas;
    }


    @Test(priority = 4, dependsOnMethods = "LoginTest")
    void TabMenuTest() {

        driver.get("https://demo.nopcommerce.com/");

        List<String> catagories = new ArrayList<>();
        catagories.add("Computers");
        catagories.add("Electronics");
        catagories.add("Apparel");
        catagories.add("Digital downloads");
        catagories.add("Books");
        catagories.add("Jewelry");
        catagories.add("Gift Cards");


        List<WebElement> tabMenu = driver.findElements(By.xpath("(//*[@class='top-menu notmobile'])/li/a"));
        for (WebElement tm : tabMenu) {

            System.out.println(tm.getText().trim());
            Assert.assertTrue(catagories.contains(tm.getText().trim()), "Test faield");
        }

    }

    @Test(priority = 5, dependsOnMethods = "TabMenuTest")
    void OrderGiftsTest() {

        driver.get("https://demo.nopcommerce.com/");

        WebElement giftCards = driver.findElement(By.linkText("Gift Cards"));
        giftCards.click();

        List<WebElement> physicalsGifts = driver.findElements(By.
                xpath("//*[contains(text(),'Physical')]"));
        physicalsGifts.get((int) (Math.random() * 2)).click();

        WebElement recipientName = driver.findElement(By.
                xpath("//input[@class='recipient-name']"));
        recipientName.sendKeys("Memmed");
        WebElement senderName = driver.findElement(By.
                xpath("//input[@class='sender-name']"));
        senderName.sendKeys("Memmed");
        WebElement messag = driver.findElement(By.
                xpath("//textarea[@class='message']"));
        messag.sendKeys("I study Tests Tools");
        WebElement addtoCartBtn = driver.findElement(By.
                xpath("//button[@class='button-1 add-to-cart-button']"));
        addtoCartBtn.click();

        WebElement messaj = driver.findElement(By.
                xpath("//p[text()='The product has been added to your ']"));
        Assert.assertTrue(messaj.getText().
                contains("The product has been added to your "), "Failed");

    }

    @Test(priority = 6, dependsOnMethods = "OrderGiftsTest")
    void OrdercomputerTest() {

        driver.get("https://demo.nopcommerce.com/");

        Actions actions = new Actions(driver);
        WebElement computers = driver.findElement(By.linkText("Computers"));
        actions.moveToElement(computers).build().perform();
        WebElement desktops = driver.findElement(By.linkText("Desktops"));
        actions.moveToElement(desktops).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                linkText("Build your own computer"))).click();
        WebElement ramSelect = driver.findElement(By.
                id("product_attribute_2"));
        Select selectRam = new Select(ramSelect);
        selectRam.selectByIndex((int) (Math.random() * 3) + 1);

        List<WebElement> hddSelect = driver.findElements(By.
                xpath("//input[@name='product_attribute_3']"));
        hddSelect.get((int) (Math.random() * 2)).click();

        WebElement addtoCartBtn1 = driver.findElement(By.
                xpath("//button[@class='button-1 add-to-cart-button']"));
        addtoCartBtn1.click();

        WebElement messaj1 = driver.findElement(By.
                xpath("//p[text()='The product has been added to your ']"));
        Assert.assertTrue(messaj1.getText().
                contains("The product has been added to your "), "Failed");
    }

    @Test(priority = 7, dependsOnMethods = "OrdercomputerTest")
    @Parameters({"textAdobePhCs4"})
    void ParametrSearchTest(String textAdobePhCS4) {

        driver.get("https://demo.nopcommerce.com/");

        WebElement search = driver.findElement(By.
                xpath("//input[@id='small-searchterms']"));
        search.sendKeys(textAdobePhCS4);
        WebElement searchBtn = driver.findElement(By.
                xpath("//button[@class='button-1 search-box-button']"));
        searchBtn.click();
        WebElement messajAdobe = driver.findElement(By.
                xpath("//a[text()='Adobe Photoshop CS4']"));
        Assert.assertTrue(messajAdobe.getText().contains(textAdobePhCS4), "Failed");

    }
}