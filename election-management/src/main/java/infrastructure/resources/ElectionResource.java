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
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/elections")
public class ElectionResource {
    private final ElectionApi api;

    @POST
    @ResponseStatus(RestResponse.StatusCode.CREATED)
    @Transactional
    private void submit() {
        api.submit();
    }

    @GET
    public List<Election> list() {
        return api.findAll();
    }
}
