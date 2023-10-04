package noob.api.quranify.controller;

import lombok.RequiredArgsConstructor;
import noob.api.quranify.DTO.AyahDTO;
import noob.api.quranify.model.Ayah;
import noob.api.quranify.service.AyahService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/quran")
@RequiredArgsConstructor // Use @RequiredArgsConstructor
public class AyahController {

    private final AyahService ayahService; // Automatically injected by Lombok

    @GetMapping("/ayahs/{id}")
    public Mono<ResponseEntity<AyahDTO>> getAyahById(@PathVariable Long id) {
        return ayahService.getAyahById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/surah/{surahId}/ayahs/{ayahNu}")
    public ResponseEntity<?>
    getAyahByNumberAndSurahId(@PathVariable Integer surahId,
                              @PathVariable Integer ayahNu) {

        return ResponseEntity.ok(ayahService.getAyahBySurahIdAndNumber(surahId,ayahNu));
    }
}