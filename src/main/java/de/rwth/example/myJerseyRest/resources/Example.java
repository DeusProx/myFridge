package de.rwth.example.myJerseyRest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.wordnik.swagger.annotations.*;

@Path("/examples")
@Api(value="/examples", description = "Root Resource", position = 0)
public class Example {

  @GET
  @ApiOperation(value="Says that this is the root of the web application")
  @ApiResponses( {
    @ApiResponse(code = 200, message = "OK")
  } )
  public String getMsg() {
    String output = "This is ROOT!";
    return output;
  }

  @GET
  @Path("/{param}")
  @ApiOperation(value="Says what you said")
  @ApiResponses( {
    @ApiResponse(code = 200, message = "OK")
  } )
  public String getMsg(@PathParam("param") String msg) {
    String output = "You said: " + msg;
    return output;
  }
}
