package noob.api.quranify.repository;

import noob.api.quranify.model.Ayah;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AyahRepository extends R2dbcRepository<Ayah, Long> {
    Flux<Ayah> getAyahsBySurahId(Integer id);
    Mono<Ayah> getAyahBySurahIdAndNumberInSurah(Integer surahId, Integer numberInSurah);
    Mono<Integer> countAyahsBySurahId(Integer surahId);
}