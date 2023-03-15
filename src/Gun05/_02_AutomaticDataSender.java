package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_AutomaticDataSender {

    @Test(dataProvider = "myDatas")
    void UserNameTest(String nameUser) {
        System.out.println("Name user= " + nameUser);
    }

    @DataProvider
    public Object[] myDatas() {

        Object[] users = {"Memmed", "Nuru", "Ayhan", "Aynur"};

        return users;
    }

    /*******************************************************************/

    @Test(dataProvider = "myDatas1")
    void UserNameTest1(int numbers) {
        System.out.println("Nambers= " + numbers);
    }

    @DataProvider
    public Object[] myDatas1() {

        Object[] numbers = {85,12,43,20,37,14,80,25};

        return numbers;
    }
}
