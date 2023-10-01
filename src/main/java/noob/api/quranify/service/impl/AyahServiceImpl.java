package noob.api.quranify.service.impl;

import lombok.RequiredArgsConstructor;
import noob.api.quranify.DTO.AyahDTO;
import noob.api.quranify.mapper.AyahMapper;
import noob.api.quranify.model.Ayah;
import noob.api.quranify.repository.AyahRepository;
import noob.api.quranify.service.AyahService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AyahServiceImpl implements AyahService {
    private  final AyahRepository ayahRepository;
    private  final AyahMapper mapper;
    @Override
    public Mono<AyahDTO> getAyahById(Long id) {
        return ayahRepository.findById(id).map(mapper::ayahToAyahDTO);
    }
}
