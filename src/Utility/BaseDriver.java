package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverInfo;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void InitialProsess() {
        System.out.println("Initial Prosess are being made ");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //chromeOptions.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
        // System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        //  System.setProperty(SafariDriverService.SAFARI_DRIVER_EXE_PROPERTY,"true");

//      System.setProperty(OperaDriverService.OPERA_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
//      OperaOptions options = new OperaOptions();


        //driver = new ChromeDriver();
        //driver=new EdgeDriver();
        // driver=new SafariDriver();

        driver.manage().window().maximize(); // Ekranı max yapıyor.

        Duration dr = Duration.ofSeconds(25);
        driver.manage().timeouts().pageLoadTimeout(dr);
        // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
        // bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.:
        // 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklemez.

        driver.manage().timeouts().implicitlyWait(dr); // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi verilen mühlet yani süre. // eğer 2 sn yükler

        wait = new WebDriverWait(driver, Duration.ofSeconds(12));
        EnterMyAcc();
    }

    void EnterMyAcc() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement userName = driver.findElement(By.id("input-email"));
        userName.sendKeys("blackmamed246@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Tna250111sdet");

        WebElement login = driver.findElement(By.cssSelector("input[type='submit']"));
        login.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertEquals(driver.getTitle(),"My Account", "Login is failed");
        //Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));
    }

    @AfterClass
    public void FinishProsess() {

        Tools.Wait(5);
        driver.quit();
    }
}