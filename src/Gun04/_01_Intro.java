package Gun04;

import org.testng.annotations.*;

public class _01_Intro {

    @BeforeSuite
    void bSuite(){

        System.out.println("Before Suite");
    }

    @BeforeTest
    void bTest()
    {
        System.out.println("Before Test");
    }
    @BeforeGroups
    void bGroups(){
        System.out.println("Before group");// group olmasa islemir
    }

    @BeforeClass
    void bClass(){
        System.out.println("Before class");
    }

    @BeforeMethod
    void bMethod(){
        System.out.println("Before method");
    }

    @Test
    void Intro1_Test1(){
        System.out.println("Intro1 -->Test 1");
    }

    @Test
    void Intro1_Test2(){
        System.out.println("Intro1 -->Test 2");
    }

    @AfterMethod
    void aMethod(){
        System.out.println("After method");
    }

    @AfterClass
    void aClass(){
        System.out.println("After class");
    }

    @AfterGroups
    void aGroups(){
        System.out.println("After groups");// gruop olmasa islemir
    }
    @AfterTest
    void aTest()
    {
        System.out.println("After Test");
    }
    @AfterSuite
    void aSuite(){

        System.out.println("After Suite");
    }
}
