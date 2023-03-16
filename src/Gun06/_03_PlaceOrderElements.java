package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_PlaceOrderElements  {


    public _03_PlaceOrderElements(){

        // Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
        // bunun için aşağıdaki consructor eklendi ve için PageFatory ile
        // driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
        // Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
        // anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
        // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
        // gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.

        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(css = "[name='search']")
    public WebElement searchInput;

    @FindBy(css = "[class='btn btn-default btn-lg']")
    public WebElement searchBtn;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addToCart;

    @FindBy(linkText = "Shopping Cart")
    public WebElement shoppingCart;

    @FindBy(linkText = "Checkout")
    public WebElement checkout;

    @FindBy(xpath = "//input[@id='button-payment-address']")
    public WebElement paymentAddress;

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    public WebElement shippingAddress;

    @FindBy(xpath = "//input[@id='button-shipping-method']")
    public WebElement shippingMethod;

    @FindBy(xpath = "//input[@name='agree']")
    public WebElement checkbox;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    public WebElement paymentmethod;

    @FindBy(xpath = "//input[@id='button-confirm']")
    public WebElement confirmOrder;

    @FindBy(xpath = "(//div[@id='content'])/h1")
    public WebElement message;

}