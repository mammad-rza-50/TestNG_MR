package TestNGProje5_1;


import Utility.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver_TesNGProje5_1 {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserType")
    public void InitialProsess(String browserType) {
        System.out.println("Initial Prosess are being made ");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (browserType.equals("chrome")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else {
            System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();

        Duration dr = Duration.ofSeconds(25);
        driver.manage().timeouts().pageLoadTimeout(dr);

        driver.manage().timeouts().implicitlyWait(dr);

        wait = new WebDriverWait(driver, dr);
        LoginTest();

    }

    public void LoginTest() {
        driver.get("https://admin-demo.nopcommerce.com/login?");
        TestNGProje5_1_POM tpp = new TestNGProje5_1_POM();
        tpp.loginBtn.click();

    }


    @AfterClass
    public void FinishProsess() {

        Tools.Wait(5);
        driver.quit();
        System.out.println("Test finished");
    }
}
