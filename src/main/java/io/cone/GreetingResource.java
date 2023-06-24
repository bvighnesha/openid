package io.cone;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import io.quarkus.oidc.IdToken;
import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.inject.Inject;

@Path("/test")
public class GreetingResource {

    @Inject
    @IdToken
    JsonWebToken idToken;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello() {
        return
                "<html>\n" +
                        "    <body>\n" +
                        "        <h1>Hello " + idToken.toString() + "</h1>\n" +
                        "    </body>\n"+
                        "</html>\n";
    }

}






