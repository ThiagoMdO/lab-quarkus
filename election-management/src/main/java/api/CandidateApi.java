package api;

import domain.Candidate;
import domain.CandidateService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CandidateApi {
    private final CandidateService candidateService;

    public void create(api.dto.in.CreateCandidate dto) {
        candidateService.save(dto.toDomain());
    }

    public api.dto.out.Candidate update(String id, api.dto.in.UpdateCandidate dto) {
        candidateService.save(dto.toDomain(id));

        return api.dto.out.Candidate.fromDomain(candidateService.findById(id));
    }

    public List<api.dto.out.Candidate> list() {
        return candidateService.findAll().stream().map(api.dto.out.Candidate::fromDomain).toList();
    }

}
