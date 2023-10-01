package noob.api.quranify.service.impl;

import lombok.RequiredArgsConstructor;
import noob.api.quranify.DTO.SurahDTO;
import noob.api.quranify.mapper.SurahMapper;
import noob.api.quranify.repository.AyahRepository;
import noob.api.quranify.repository.SurahRepository;
import noob.api.quranify.service.AyahService;
import noob.api.quranify.service.SurahService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SurahServiceImpl implements SurahService {

    private final SurahRepository surahRepository;
    private final AyahRepository ayahRepository;
    private final SurahMapper mapper;
    @Override
    public Mono<SurahDTO> getSurahById(Integer id) {
        return surahRepository.findById(id).map(mapper::surahToSurahDTO);
    }

    @Override
    public Mono<Integer> getCountAyahs(Integer id) {
        return ayahRepository.countAyahsBySurahId(id);
    }
}
