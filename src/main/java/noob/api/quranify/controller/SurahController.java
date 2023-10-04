package noob.api.quranify.controller;

import lombok.RequiredArgsConstructor;
import noob.api.quranify.DTO.AyahDTO;
import noob.api.quranify.DTO.SurahDTO;
import noob.api.quranify.DTO.SurahResponse;
import noob.api.quranify.model.Ayah;
import noob.api.quranify.model.Surah;
import noob.api.quranify.service.AyahService;
import noob.api.quranify.service.SurahService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/quran/surah")
public class SurahController {
    private final SurahService surahService;
    private final AyahService ayahService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<?>> getSurahById(@PathVariable Integer id) {
        Mono<String> name = surahService.getSurahById(id).map(SurahDTO::getNameArabic);
        Mono<String> type = surahService.getSurahById(id).map(SurahDTO::getType);
        Mono<Integer> numberOfAyahs = surahService.getCountAyahs(id);
        Mono<List<String>> ayahs = ayahService.getAyahsBySurahId(id).map(AyahDTO::getText).collectList();
        return Mono.zip(name, type, numberOfAyahs, ayahs)
                .map(tuple -> {
                    String r1 = tuple.getT1();
                    String r2 = tuple.getT2();
                    Integer r3 = tuple.getT3();
                    List<String> r4 = tuple.getT4();
                    return new SurahResponse(r1, r2, r3, r4);
                }).map(ResponseEntity::ok);
    }

    @GetMapping("/{id}/count")
    public ResponseEntity<?> getCountOfAyahs(@PathVariable Integer id) {
        return ResponseEntity.ok(surahService.getCountAyahs(id));
    }

}
