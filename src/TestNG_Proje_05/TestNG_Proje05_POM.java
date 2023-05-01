package TestNG_Proje_05;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestNG_Proje05_POM {

    public TestNG_Proje05_POM() {
        PageFactory.initElements(BaseDriver_TestNG_Proje05.driver, this);
    }

    @FindBy(css = "[formcontrolname='username']")
    WebElement username;
    @FindBy(css = "[formcontrolname='password']")
    WebElement password;
    @FindBy(css = "button[aria-label='LOGIN']")
    WebElement loginBtn;

    @FindBy(xpath = "//span[text()='Techno Study']")
    WebElement messajTechnoStudy;

    @FindBy(xpath = "//div[@class='group-items ng-star-inserted']" +
            "/fuse-nav-vertical-collapsable/a")
    List<WebElement> leftMenuList;

    @FindBy(css = "div[class='group-items ng-star-inserted']" +
            ">fuse-nav-vertical-collapsable>a svg[data-icon='folder-open']")
    List<WebElement> underLeftMenuList;
}
