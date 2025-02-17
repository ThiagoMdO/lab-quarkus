package domain;

import java.util.List;

public interface ElectionRepository {
    Election findByiD(String id);

    List<Election> findAll();

    void vote(String electionId, Candidate candidate);
}
