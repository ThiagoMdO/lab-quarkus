package domain;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ElectionService {
    private final ElectionRepository electionRepository;

    public List<Election> findAll() {
        return electionRepository.findAll();
    }

    public void vote(String electionId, String candidateId) {
        Election election = electionRepository.findByiD(electionId);

        election.candidates().stream()
        .filter(candidate -> candidate.id().equals(candidateId))
        .findFirst()
        .ifPresent(candidate -> electionRepository.vote(electionId, candidate));

    }
}
