package de.rwth.example.myJerseyRest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.wordnik.swagger.annotations.*;

@Path("/examples")
@Api(value="/examples", description = "Root Resource", position = 0)
public class Example {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @ApiOperation(value="Says that this is the root of the web application")
  @ApiResponses( {
    @ApiResponse(code = 200, message = "OK")
  } )
  public Response getMsg() {
    String output = "{\"Message\":\"This is ROOT!\"}\n";
    return Response.status(Status.OK).entity(output).build();
  }

  @GET
  @Path("/{param}")
  @Produces(MediaType.APPLICATION_JSON)
  @ApiOperation(value="Says what you said")
  @ApiResponses( {
    @ApiResponse(code = 200, message = "OK")
  } )
  public Response getMsg(@PathParam("param") String msg) {
    String output = "{\"Message\":\"You said " + msg +"\"}\n";
    return Response.status(Status.OK).entity(output).build();
  }
}
