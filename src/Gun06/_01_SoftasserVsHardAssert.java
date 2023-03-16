package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftasserVsHardAssert {

    @Test
    void hardAssert() {

        String s1 = "Hello";
        System.out.println("Hard Assert before");
        Assert.assertEquals("Hello1", s1, "Actual != Expected");
        //Xeta olanda testi kirir
        System.out.println("Hard Assert after");
    }

    @Test
    void softAssert() {
        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cartpage";
        String strEdirAccount = "www.facebook.com/editaccountpage";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals("www.facebook.com/homepage", strHomePage);
        //true
        System.out.println("soft Assert 1");

        softAssert.assertEquals("www.facebook.com/profile", strCartPage);
        //false
        System.out.println("soft Assert 2");

        softAssert.assertEquals("www.facebook.com/setting", strEdirAccount);
        //false
        System.out.println("soft Assert 3");

        softAssert.assertAll();// butun assertleri neticelerini isleme koyur
        System.out.println("soft AsserAll : akticlik sonrasi");
        // bu bolum assertAll-dan sonra oldugu ve oncesinde xeta oldugu icin
        // ekrana cikmayacaq


    }
}
