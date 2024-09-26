package infrastructure.schedulers;

import domain.Election;
import domain.annotations.Principal;
import infrastructure.repositories.SQLElectionRepository;
import infrastructure.repositories.RedisElectionRepository;
import io.quarkus.scheduler.Scheduled;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Sync {
    private final SQLElectionRepository sqlElectionRepository;

    private final RedisElectionRepository redisElectionRepository;

    public Sync(@Principal SQLElectionRepository sqlElectionRepository,
                RedisElectionRepository redisElectionRepository) {
        this.sqlElectionRepository = sqlElectionRepository;
        this.redisElectionRepository = redisElectionRepository;
    }

    @Scheduled(cron = "*/10 * * * * * ?")
    void sync() {
        sqlElectionRepository.findAll()
            .forEach(election -> {
                Election update = redisElectionRepository.sync(election);
                sqlElectionRepository.sync(update);
            });
    }
}
