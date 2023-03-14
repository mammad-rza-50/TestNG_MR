package Gun02;

import Utility.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _01_Enable {

    @Test
    void Test1() {

        System.out.println("Test1");

    }

    @Test(enabled = false)
    void Test2() {

        System.out.println("Test2");

    }

    @Test
    void Test3() {

        System.out.println("Test3");

    }

    public static WebDriver driver;

    @BeforeClass
    void InitialProsess() {
        System.out.println("Initial Prosess are being made");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);


        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //chromeOptions.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
        // System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        //  System.setProperty(SafariDriverService.SAFARI_DRIVER_EXE_PROPERTY,"true");

        //driver = new ChromeDriver();
        //driver=new EdgeDriver();
        // driver=new SafariDriver();

        // driver.manage().window().maximize(); // Ekranı max yapıyor.

        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
        // bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.:
        // 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklemez.

        driver.manage().timeouts().implicitlyWait(dr); // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi verilen mühlet yani süre. // eğer 2 sn yükler
    }

    @AfterClass
    void FinishProsess() {
        System.out.println("Finish Prosess are being made ");

        Tools.Wait(2);
        driver.quit();
    }

}
