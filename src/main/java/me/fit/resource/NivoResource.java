package me.fit.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Nivo;
import me.fit.repository.NivoRepository;

@Path("/nivo")
public class NivoResource {

	@Inject
	private NivoRepository NivoRepository;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addLevel")
	public Response createNivo(Nivo nivo) {
		Nivo n = NivoRepository.createNivo(nivo);
		return Response.ok().entity(n).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllLevels")
	public Response getAllLevels () {
		List<Nivo> levels = NivoRepository.getAllLevels();
		
		return Response.ok().entity(levels).build();
	}
}