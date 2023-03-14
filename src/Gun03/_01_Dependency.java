package Gun03;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {

    @Test
    void startCar() {
        System.out.println("startCar");
        //Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar"})
    void driveCar() {  // bu testin islemesi startCar-in xetasiz islemesine baglidir
        System.out.println("driveCar");
      // Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar", "driveCar"})
    void parkCar() {
        System.out.println("parkCar");
       // Assert.fail();
    }
    // alwaysRun=true  asiliqlilari var amma xeta cikarsa da yene de isleyir
    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true)
    void stoptCar() {
        System.out.println("stopCar");
        //Assert.fail();
    }
    // aynı seviyedeki testleri için priority verilebilir.
    // bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
    // 2 üste kadar ototmatik çağırıp çalışabilir.
}
