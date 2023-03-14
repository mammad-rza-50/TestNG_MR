package Gun01;

import org.testng.annotations.Test;

public class _01_Introduction {

    //    public static void main(String[] args) {
//        OpenWebsite();
//        DoLoginProsses();
//        driverClose();
//    }

//    @Test JUnit
//    public void Test1(){
//        OpenWebsite(); // beforeClass
//        DoLoginProsses();//
//        driverClose();  // afterClass
//    }

    // Eğer herhangi bir sıralama verilmezse metod isimlerinin alfabetik çalışıyor
    @Test(priority = 1)
    public void OpenWebsite(){
        System.out.println("driver tanımlandı ve webSitesiniAcildi");
    }

    @Test(priority = 2)
    public void DoLoginProsses(){
        System.out.println("LoginTest işlemi yapıldı");
    }

    @Test(priority = 3)
    public void driverClose(){
        System.out.println("driver kapatıldı.");
    }


}
