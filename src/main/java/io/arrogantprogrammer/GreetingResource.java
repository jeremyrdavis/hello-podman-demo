package io.arrogantprogrammer;

import io.quarkus.logging.Log;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestForm;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting addGreeting(Greeting greeting) {
        Log.debugf("Adding greeting: %s from %s", greeting.author, greeting.greeting);
        return new Greeting(greeting.author, greeting.greeting);
    }
}
