import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ASimpleTest {

    @Test
    public void test1() {
        System.out.println("Testing if 1 equals 1");
        assertEquals(1,1);
    }

    @Test(expected=java.lang.AssertionError.class)
    public void test2() {
        System.out.println("Testing if object is null");
       Object notNullObject = new Object();
       assertNull(notNullObject);
    }
}