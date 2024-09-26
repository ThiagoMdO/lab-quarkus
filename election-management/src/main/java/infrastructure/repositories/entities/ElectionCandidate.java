package infrastructure.repositories.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Setter
@Getter
@Entity(name = "election_candidate")
public class ElectionCandidate {
    @EmbeddedId
    private ElectionCandidateId id;

    private Integer votes;

    public static ElectionCandidate fromDomain(domain.Election election, domain.Candidate candidate, Integer votes) {
        ElectionCandidate entity = new ElectionCandidate();

        ElectionCandidateId id = new ElectionCandidateId();

        id.setElectionId(election.id());
        id.setCandidateId(candidate.id());

        entity.setId(id);
        entity.setVotes(votes);

        return  entity;
    }
}
