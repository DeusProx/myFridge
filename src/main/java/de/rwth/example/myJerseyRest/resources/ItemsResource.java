package de.rwth.example.myJerseyRest.resources;

//import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import de.rwth.example.myJerseyRest.models.Item;
import de.rwth.example.myJerseyRest.services.interfaces.ItemDAO;

@Path("/fridge/items")
@Api(value="/fridge/items", description = "Items in our fridge", position = 1)

public class ItemsResource {

  @Inject
  private ItemDAO itemDAO;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @ApiOperation(value="Verifies an accessToken.")
  @ApiResponses( {
    @ApiResponse(code = 200, message = "OK")
  } )
  public Response insertItemIntoFridge(Item item) {
    this.itemDAO.insertItem(item);
    return Response.status(Status.OK).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @ApiOperation(value="Verifies an accessToken.")
  @ApiResponses( {
    @ApiResponse(code = 200, message = "OK")
  } )
  public Response listItems() {
    return Response.status(Status.OK).entity(this.itemDAO.getAllItems()).build();
    //return Response.status(Status.OK).build();
  }

  @GET
  @Path("/{itemid}")
  @Produces(MediaType.APPLICATION_JSON)
  @ApiOperation(value="Verifies an accessToken.")
  @ApiResponses( {
    @ApiResponse(code = 200, message = "OK")
  } )
  public Response showFridgeItem(@PathParam("itemid") String itemid) {
    return Response.status(Status.OK).build();
  }

  @PUT
  @Path("/{itemid}")
  @Produces(MediaType.APPLICATION_JSON)
  @ApiOperation(value="Verifies an accessToken.")
  @ApiResponses( {
    @ApiResponse(code = 200, message = "OK")
  } )
  public Response updateFridgeItem(@PathParam("itemid") String itemid) {
    return Response.status(Status.OK).build();
  }

  @DELETE
  @Path("/{itemid}")
  @ApiOperation(value="Verifies an accessToken.")
  @ApiResponses( {
    @ApiResponse(code = 200, message = "OK")
  } )
  public Response deleteFridgeItem(@PathParam("itemid") String itemid) {
    return Response.status(Status.OK).build();
  }
}
