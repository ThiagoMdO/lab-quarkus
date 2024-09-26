package infrastructure.repositories;

import domain.Candidate;
import domain.CandidateQuery;
import domain.CandidateRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class SQLCandidateRepository implements CandidateRepository {

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void save(List<Candidate> candidates) {
        candidates.stream()
                    .map(infrastructure.repositories.entities.Candidate::fromDomain)
                    .forEach(entityManager::merge);
    }

    @Override
    public List<Candidate> find(CandidateQuery query) {
        var cb = entityManager.getCriteriaBuilder();
        var cq = cb.createQuery(infrastructure.repositories.entities.Candidate.class);
        var root = cq.from(infrastructure.repositories.entities.Candidate.class);

        var where = query.ids().map(id -> cb.in(root.get("id")).value(id)).get();

        cq.select(root).where(where);

        return entityManager.createQuery(cq)
        .getResultStream()
        .map(infrastructure.repositories.entities.Candidate::toDomain)
        .toList();
    }

}
