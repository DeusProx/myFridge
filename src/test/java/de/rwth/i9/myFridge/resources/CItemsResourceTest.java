
import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import de.rwth.i9.examples.myFridge.WebApplication;



import java.net.URI;

public class CItemsResourceTest extends JerseyTest{

    @Override
    protected Application configure() {
        return new WebApplication();
    }

    @Test
    public void test3() {
        //assertNull
        System.out.println("testing");
        assertEquals(1,1);
        System.out.println("test worked");
    }

    @Test
    public void test4() {
        System.out.println("testing");
    }

}