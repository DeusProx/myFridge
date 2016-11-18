package de.rwth.i9.examples.myFridge.resources;

//import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import de.rwth.i9.examples.myFridge.models.Item;
import de.rwth.i9.examples.myFridge.services.interfaces.ItemDAO;

@Path("/items")
@Api(value = "items", description = "Fridge API", position = 2)
public class ItemsResource {
    @Inject
    private ItemDAO itemDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Insert an item into the fridge.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "CREATED")
    })
    public Response insertItem(Item item) {
        item = this.itemDAO.insertItem(item);
        return Response.status(Status.CREATED).entity(item).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Lists all items in the fridge.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    public Response listItems() {
        return Response.status(Status.OK).entity(this.itemDAO.getAllItems()).build();
    }

    @GET
    @Path("/{itemid}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Gets one specific item from the fridge.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    public Response getItem(@PathParam("itemid") int itemid) {
        Item item = this.itemDAO.getItemById(itemid);
        if(item == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.status(Status.OK).entity(item).build();
    }

    @DELETE
    @Path("/{itemid}")
    @ApiOperation(value = "Removes an item from the fridge.")
    @ApiResponses({
            @ApiResponse(code = 204, message = "NO_CONTENT"),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    public Response deleteItem(@PathParam("itemid") int itemid) {
        if (this.itemDAO.getItemById(itemid) == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        this.itemDAO.deleteItemById(itemid);
        return Response.status(Status.NO_CONTENT).build();
    }
}
