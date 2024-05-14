package io.arrogantprogrammer;

import io.quarkus.logging.Log;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/hello")
public class GreetingResource {

    private List<Greeting> greetingList = new ArrayList<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Greeting greeting = greetingList.get(new Random().nextInt(greetingList.size()));
        return "%s says, '%s'".formatted(greeting.author, greeting.text);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting addGreeting(Greeting greeting) {
        if (greetingList == null || greetingList.isEmpty()) {
            greetingList = new ArrayList() {
                {
                    add(new Greeting("Roger", "Hi, there!"));
                    add(new Greeting("Norman", "Hey, everyone!"));
                }
            };
        }
        Log.debugf("Adding greeting: %s from %s", greeting.author, greeting.text);
        greetingList.add(greeting);
        return new Greeting(greeting.author, greeting.text);
    }
}
