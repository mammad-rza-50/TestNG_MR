package Gun01;

import org.testng.annotations.Test;

public class _01_Introduction {

    //    public static void main(String[] args) {
//        webSitesiniAc();
//        LoginIsleminiYap();
//        driveriKapat();
//    }

//    @Test JUnit
//    public void Test1(){
//        webSitesiniAc(); // beforeClass
//        LoginIsleminiYap();//
//        driveriKapat();  // afterClass
//    }

    // Eğer herhangi bir sıralama verilmezse metod isimlerinin alfabetik çalışıyor
    @Test(priority = 1)
    public void webSitesiniAc(){
        System.out.println("driver tanımlandı ve webSitesiniAcildi");
    }

    @Test(priority = 2)
    public void loginIsleminiYap(){
        System.out.println("LoginTest işlemi yapıldı");
    }

    @Test(priority = 3)
    public void driveriKapat(){
        System.out.println("driver kapatıldı.");
    }


}
