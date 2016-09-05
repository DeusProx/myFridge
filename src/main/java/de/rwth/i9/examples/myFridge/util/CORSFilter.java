package de.rwth.i9.examples.myFridge.util;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * This class provides additional Headers to each response made by Tethys to enable CORS (Cross Origin Resource Sharing).
 *
 * @author Gordon Lawrenz <gordon@lawrenz.email>
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {

    /**
     * Contains all valid methods for http requests to this server
     */
    public static String VALID_METHODS = "DELETE, HEAD, GET, OPTIONS, POST, PUT";

    /* (non-Javadoc)
     * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.container.ContainerRequestContext, javax.ws.rs.container.ContainerResponseContext)
     */
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add("Access-Control-Allow-Methods",VALID_METHODS);
        responseContext.getHeaders().add("Access-Control-Allow-Headers","Accept, Content-Type, Origin");
    }

}