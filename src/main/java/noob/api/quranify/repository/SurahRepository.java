package noob.api.quranify.repository;

import noob.api.quranify.model.Surah;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface SurahRepository extends R2dbcRepository<Surah,Integer> {

}
