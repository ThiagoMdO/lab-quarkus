package infrastructure.resources;

import api.ElectionApi;
import api.dto.out.Election;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/voting")
public class VotingResource {
    private final ElectionApi api;

    @GET
    public List<Election> elections() {
        return api.findAll();
    }

    @Path("/elections/{electionId}/candidates/{candidateId}")
    @ResponseStatus(RestResponse.StatusCode.CREATED)
    @Transactional
    @POST
    public void vote(@PathParam("electionId") String electionId, @PathParam("candidateId") String candidateId) {
        api.vote(electionId, candidateId);
    }

}
