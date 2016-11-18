import java.net.URI;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.test.JerseyTest;
import javax.ws.rs.client.Client;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.rwth.i9.examples.myFridge.WebApplication;
import de.rwth.i9.examples.myFridge.models.Item;
import de.rwth.i9.examples.myFridge.models.Nutritions;

import java.util.*;
import javax.ws.rs.core.GenericType;

public class CItemsResourceTest extends JerseyTest{

  private static final URI BASE_URI = UriBuilder.fromUri("http://localhost/").port(9998).build();
  private final JerseyWebTarget wt =  (JerseyWebTarget) JerseyClientBuilder.newClient().target(BASE_URI);
  private final ItemInterface itemProxy = WebResourceFactory.newResource(ItemInterface.class, wt);

  @Override
  protected Application configure() {
    return new WebApplication();
  }

  @Path("/items")
  public interface ItemInterface {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response insertItem(Item item);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response listItems();

    @GET
    @Path("/{itemid}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getItem(@PathParam("itemid") int itemid);

    @DELETE
    @Path("/{itemid}")
    Response deleteItem(@PathParam("itemid") int itemid);
  }

  @Test
  public void getAllItems() {
    Response response = itemProxy.listItems();
    assertEquals(response.getStatusInfo(), Status.OK);
    List<Item> list = response.readEntity(new GenericType<List<Item>>(){});
    assertNotNull(list);
    System.out.println("List of all saved Items:");
    System.out.println(list);
  }

  @Test
  public void insertItem() {
    Response response;
    Nutritions nut = new Nutritions(1,1,1,1);
    Item item = new Item("TestItem","2017-01-15","This Item is used for testing purposes","Tester","Virtuality",nut);

    //insert Item
    response = itemProxy.insertItem(item);
    assertEquals(response.getStatusInfo(), Status.CREATED);
    item = response.readEntity(Item.class);

    //get Item
    response = itemProxy.getItem(item.getId());
    assertEquals(response.getStatusInfo(), Status.OK);
    
    Item item2 = response.readEntity(Item.class);
    assertTrue("Objects doesn't match!",item.equals(item2));

    //tidy up & delete Item
    response = itemProxy.deleteItem(item.getId());
    assertEquals(response.getStatusInfo(),Status.NO_CONTENT);
  }

}
