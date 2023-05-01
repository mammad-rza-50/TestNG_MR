package TestNG_Proje_05;

import Utility.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver_TestNG_Proje05 {

    public static WebDriver driver;  // burada static goturuldu cunki her classin oz driveri var
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

        Login();
    }


    public void Login (){
        TestNG_Proje05_POM tpp = new TestNG_Proje05_POM();
        driver.get("https://test.mersys.io/");
        tpp.username.clear();
        tpp.username.sendKeys("turkeyts");
        tpp.password.clear();
        tpp.password.sendKeys("TechnoStudy123");
        tpp.loginBtn.click();


    }


    @AfterClass
    public void FinishProsess() {

        Tools.Wait(3);
        driver.quit();
        System.out.println("Test finished");
    }
}