package domain;

import io.quarkus.test.junit.QuarkusTest;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public abstract class CandidateRepositoryTest {
    public abstract CandidateRepository candidateRepository();

    @Test
    void save() {
        Candidate candidate = Instancio.create(Candidate.class);
        candidateRepository().save(candidate);

        Optional<Candidate> result = candidateRepository().findById(candidate.id());

        assertTrue(result.isPresent());
        assertEquals(candidate, result.get());
    }

    @Test
    void findAll() {
        List<Candidate> candidates = Instancio.stream(Candidate.class).limit(10).toList();
        candidateRepository().save(candidates);

        candidateRepository().findAll();

        List<Candidate> result = candidateRepository().findAll();

        assertEquals(result.size(), candidates.size());
    }


}
