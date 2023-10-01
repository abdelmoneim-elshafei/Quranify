package noob.api.quranify.service;

import noob.api.quranify.DTO.SurahDTO;
import reactor.core.publisher.Mono;

public interface SurahService {
    public Mono<SurahDTO> getSurahById(Integer id);
    public Mono<Integer> getCountAyahs(Integer id);
}
