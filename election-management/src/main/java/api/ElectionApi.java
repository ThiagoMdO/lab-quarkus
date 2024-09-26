package api;

import api.dto.out.Election;
import domain.ElectionService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class ElectionApi {
    private final ElectionService electionService;

    public void submit() {
        electionService.submit();
    }

    public List<Election> findAll() {
        return electionService.findAll()
        .stream()
        .map(Election::fromDomain)
        .toList();
    }
}
