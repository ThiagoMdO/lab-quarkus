package infrastructure.repositories.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "elections")
@Setter
@Getter
public class Election {
    @Id
    private String id;

    public static Election fromDomain(domain.Election domain) {
        Election entity = new Election();

        entity.setId(domain.id());

        return entity;
    }
}
