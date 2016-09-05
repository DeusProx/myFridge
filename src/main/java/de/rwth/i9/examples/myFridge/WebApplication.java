package de.rwth.i9.examples.myFridge;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 * Deployment class for a JAX-RS 2.0 (Jersey) application with Servlet 3.0.
 *
 * @author Gordon Lawrenz <gordon@lawrenz.email>
 */
@ApplicationPath("/api/*")
public class WebApplication extends ResourceConfig {

	public WebApplication() {
		System.out.println("myFridge starts...");
		packages("de.rwth.i9.examples.myFridge.resources");
		register(new de.rwth.i9.examples.myFridge.InjectionBinder());
		register(de.rwth.i9.examples.myFridge.util.CORSFilter.class);

		packages("com.wordnik.swagger.jaxrs.json");
		packages("com.wordnik.swagger.jersey.listing");

		register(new LoggingFilter());
		property(ServerProperties.TRACING, "ALL");
		System.out.println("... myFridge has started!!!");
		System.out.println("");
	}

}
