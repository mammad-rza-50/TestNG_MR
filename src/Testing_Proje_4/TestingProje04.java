package Testing_Proje_4;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

    @Test(dependsOnMethods = {"RegistrationTest"})
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
        WebElement message1= driver.findElement(By.
                xpath("//a[text()='Log out']"));
        Assert.assertEquals(message1.getText(),"Log out","Log in failed");

    }
}
