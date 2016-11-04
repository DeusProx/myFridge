import java.net.URI;
import java.lang.invoke.MethodHandles;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.eclipse.jetty.server.Server;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import de.rwth.i9.examples.myFridge.resources.HelloWorldResource;

public class BHelloWorldResourceTest {

    private static Server server;
    private static final URI BASE_URI = UriBuilder.fromUri("http://localhost/").port(8080).build();
    private static final ResourceConfig rc = new ResourceConfig(HelloWorldResource.class);
    private final WebTarget wt = ClientBuilder.newClient().target(BASE_URI);


    @BeforeClass
    public static void initServer() throws Exception {
        System.out.println("Start Server!");
        server = JettyHttpContainerFactory.createServer(BASE_URI, rc);
        server.start();
    }

    @AfterClass
    public static void destroyServer() throws Exception {
        server.stop();
        System.out.println("Destroying Server!");
    }

    @Test
    public void helloWorldText() {
        System.out.println(server.getURI());
        System.out.println(wt.path("helloworld").getUri());
        Response response = wt.path("helloworld")
            .request(MediaType.TEXT_PLAIN)
            .get();
        assertEquals(response.getStatusInfo(), Status.OK);
        assertEquals(response.readEntity(String.class),"Jersey says 'Hello World!'");
    }

    @Test
    public void helloWorldHTML() {
        System.out.println(server.getURI());
        System.out.println(wt.path("helloworld").getUri());
        Response response = wt.path("helloworld")
            .request(MediaType.TEXT_HTML)
            .get();
        assertEquals(response.getStatusInfo(), Status.OK);
        assertEquals(response.readEntity(String.class),"<html><head><title>myFridge</title></head><body>Jersey yells <h1>'Hello World!'</h1></body></html>");
    }
}