package infrastructure.repositories.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Optional;

@Setter
@Getter
@Entity(name = "candidates")
public class Candidate {
    @Id
    private String id;

    private String photo;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "family_name")
    private String familyName;

    private String email;

    private String phone;

    @Column(name = "job_title")
    private String jobTitle;

    public static Candidate fromDomain(domain.Candidate domain) {
        Candidate entity = new Candidate();

        entity.setId(domain.id());
        entity.setPhoto(domain.photo().orElse(null));
        entity.setGivenName(domain.givenName());
        entity.setFamilyName(domain.familyName());
        entity.setEmail(domain.email());
        entity.setPhone(domain.phone().orElse(null));
        entity.setJobTitle(domain.jobTitle().orElse(null));

        return entity;
    }

    public domain.Candidate toDomain() {
        return new domain.Candidate(
                        getId(),
                        Optional.ofNullable(getPhoto()),
                        getGivenName(),
                        getFamilyName(),
                        getEmail(),
                        Optional.ofNullable(getPhone()),
                        Optional.ofNullable(getJobTitle())
                        );
    }
}

