package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _03_DataProvide_Many {

    @Test(dataProvider = "UserData")
    void UserNameTest(String username, String password) {

        System.out.println("User= " + username + "--> " + password);
    }

    @DataProvider
    public Object[][] UserData() {

        Object[][] data = {
                {"Memmed", "1980"},
                {"Aynur", "1985"},
                {"Nuru", "2007"},
                {"Ayhan", "2008"}
        };
        return data;
    }
}
