package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Polaznik;
import me.fit.model.client.PolaznikKurs;
import me.fit.repository.PolaznikRepository;

@Path("/polaznik/")
public class PolaznikResource {

    @Inject
    private PolaznikRepository polaznikRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createPolaznik")
    public Response createPolaznik(Polaznik polaznik) {
        Polaznik p = polaznikRepository.createPolaznik(polaznik);
        return Response.ok().entity(p).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("createPolaznikKurs")
    public Response createPolaznikKurs(PolaznikKurs polaznikKurs) {
        PolaznikKurs pk = polaznikRepository.createPolaznikKurs(polaznikKurs);
        return Response.ok().entity(pk).build();
    }
}