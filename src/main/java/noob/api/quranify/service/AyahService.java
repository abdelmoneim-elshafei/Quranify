package noob.api.quranify.service;

import noob.api.quranify.DTO.AyahDTO;
import reactor.core.publisher.Mono;

public interface AyahService {
    Mono<AyahDTO> getAyahById(Long id);
}
