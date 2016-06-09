package de.rwth.example.myJerseyRest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import de.rwth.example.myJerseyRest.InjectionBinder;

/**
 * Deployment class for a JAX-RS 2.0 (Jersey) application with Servlet 3.0.
 *
 * @author Gordon Lawrenz <lawrenz@dbis.rwth-aachen.de>
 */
@ApplicationPath("/api/*")
public class WebApplication extends ResourceConfig {

	/**
	 * Constructor of our WebApplication.
	 */
	public WebApplication() {
		System.out.println("myJerseyRest starts...");
		packages("de.rwth.example.myJerseyRest.resources");
		register(new InjectionBinder());

		packages("com.wordnik.swagger.jaxrs.json");
		register(com.wordnik.swagger.jersey.listing.ApiListingResource.class);
		register(com.wordnik.swagger.jersey.listing.JerseyApiDeclarationProvider.class);
		register(com.wordnik.swagger.jersey.listing.ApiListingResourceJSON.class);
		register(com.wordnik.swagger.jersey.listing.JerseyResourceListingProvider.class);

		register(new LoggingFilter());
		property(ServerProperties.TRACING, "ALL");
		System.out.println("... myJerseyRest has started!!!");
		System.out.println("");
	}

}
