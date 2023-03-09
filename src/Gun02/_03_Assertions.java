package Gun02;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void EqualsSample() {

        String s1 = "Hello";
        String s2 = "Hello";

        //Actual (faktiki), Expected(gozlenen), Message(optional)

        Assert.assertEquals(s1, s2, "Qarsilasma ugursuz oldu");
        // burada mesaj      s1-->s2-ye beraber deyilse mesaj "Qarsilasma ugursuz oldu" yaz
    }

    @Test
    void NotEqualsSample() {

        String s1 = "Hello";
        String s2 = "Hello TestNG";

        //Actual (faktiki), Expected(gozlenen), Message(optional)

        Assert.assertNotEquals(s1, s2, "Qarsilasma ugurlu oldu");
    }

    @Test
    void TrueSample() {

        int s1 = 12;
        int s2 = 14;

        Assert.assertTrue(s1 == s2, "Beraber olmadi");

    }

    @Test
    void NullSample() {

        String s1 = null;


        //Actual (faktiki), Expected(gozlenen), Message(optional)

        Assert.assertNotEquals(s1, "Netice Null olmadi");
    }

    @Test
    void DirectFail() {

        int a = 12;

        if (a == 12)
            Assert.fail();
    }
}