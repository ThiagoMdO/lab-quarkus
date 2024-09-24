package domain;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    public Candidate findById(String id) {
        return candidateRepository.findById(id).orElseThrow();
    }
}
