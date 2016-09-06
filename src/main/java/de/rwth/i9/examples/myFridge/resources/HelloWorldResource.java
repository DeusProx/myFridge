package de.rwth.i9.examples.myFridge.resources;

//import java.util.Collection;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import de.rwth.i9.examples.myFridge.models.Item;
import de.rwth.i9.examples.myFridge.services.interfaces.ItemDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/helloworld")
@Api(value="helloworld", description = "responds with 'hello world'", position = 1)
public class HelloWorldResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @ApiOperation(value="responds with 'hello world'")
  @ApiResponses( {
    @ApiResponse(code = 200, message = "OK")
  } )
  public Response listItems() {
    String output = "Jersey says 'Hello World!'";
    return Response.status(Status.OK).entity(output).build();
  }

}
