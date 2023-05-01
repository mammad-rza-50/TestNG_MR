package TestNGProje5_1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestNGProje5_1_POM {

    public TestNGProje5_1_POM() {
        PageFactory.initElements(BaseDriver_TesNGProje5_1.
                driver,this);
    }

    @FindBy(id = "Email")
    public WebElement emailBox;

    @FindBy(id = "SearchEmail")
    public WebElement searchEmail;

    @FindBy(id = "Password")
    public WebElement passwordBox;

    @FindBy(id = "FirstName")
    public WebElement firstNameBox;

    @FindBy(id = "SearchFirstName")
    public WebElement searchFirstName;

    @FindBy(id = "LastName")
    public WebElement lastNameBox;

    @FindBy(id = "SearchLastName")
    public WebElement searchLastName;

    @FindBy(id = "Gender_Male")
    public WebElement maleCheckbox;

    @FindBy(id = "Gender_Female")
    public WebElement femaleCheckbox;

    @FindBy(id = "DateOfBirth")
    public WebElement birthDate;

    @FindBy(id = "Company")
    public WebElement companyName;

    @FindBy(id = "IsTaxExempt")
    public WebElement taxExemptBox;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginBtn;

    @FindBy(xpath = "//ul[@role='menu']/li[@class='nav-item has-treeview']")
    public List<WebElement> leftnavMenus;

    @FindBy(xpath = "//ul[@class='nav nav-treeview' and @style='display: block;']/li")
    public List<WebElement> underLeftnavMenus;

    @FindBy(linkText = "Add new")
    public WebElement addNewCustomer;

    @FindBy(css = "div[class='k-multiselect-wrap k-floatwrap']")
    public WebElement newsLetter;

    @FindBy(xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
    public WebElement customerRole; // su an kullanilmadi istenildigi taktirde locator ile degistirilebilir

    @FindBy(id = "VendorId")
    public WebElement vendorSelect;

    @FindBy(id = "AdminComment")
    public WebElement commentBox;

    @FindBy(css = "button[name='save']")
    public WebElement saveButton;

    @FindBy(css = "div[class='alert alert-success alert-dismissable']")
    public WebElement successMsg;

    @FindBy(id = "search-customers")
    public WebElement customerSearchBtn;

    @FindBy(xpath = "(//tr[@class='odd']/td)[2]")
    public WebElement customerMailSearchResult;

    @FindBy(linkText = "Edit")
    public WebElement editBtn;

    @FindBy(id = "customer-delete")
    public WebElement customerDeleteBtn;

    @FindBy(css = "[class='btn btn-danger float-right']")
    public WebElement customerDeleteBtn2;

    @FindBy(css = "[placeholder='Search']")
    public WebElement homepageSearch;

    @FindBy(css = "strong[class='tt-highlight']")
    public WebElement shipmentSearchOption;

    @FindBy(css = "h1[class='float-left']")
    public WebElement displayText;

    @FindBy(xpath = "//div[@data-hideattribute='CustomerListPage.HideSearchBlock']")
    public WebElement searchRowCustomer;

    @FindBy(id = "customer-info")
    public WebElement customerCard;
}
