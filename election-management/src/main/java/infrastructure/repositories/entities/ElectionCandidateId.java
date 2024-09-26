package infrastructure.repositories.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
public class ElectionCandidateId implements Serializable {
    @Column(name = "election_id")
    private String electionId;

    @Column(name = "candidate_id")
    private String candidateId;
}
