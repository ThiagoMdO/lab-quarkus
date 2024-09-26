package api;

import api.dto.out.Election;
import domain.ElectionService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ElectionApi {
    private final ElectionService service;

    public List<Election> findAll() {
        return service.findAll().stream().map(Election::fromDomain).toList();
    }

    public void vote(String electionId, String candidateId) {
        service.vote(electionId, candidateId);
    }
}
