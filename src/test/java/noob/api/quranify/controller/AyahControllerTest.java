package noob.api.quranify.controller;

import noob.api.quranify.DTO.AyahDTO;
import noob.api.quranify.model.Ayah;
import noob.api.quranify.service.AyahService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest(controllers = AyahController.class)
@AutoConfigureWebTestClient
public class AyahControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private AyahService ayahService;

    @BeforeEach
    public void setUp() {
        // Mocking the behavior of AyahService
        Mockito.when(ayahService.getAyahById(Mockito.anyLong()))
                .thenReturn(Mono.just(createSampleAyah()));
    }

    @Test
    public void testGetAyahById() {
        webTestClient.get()
                .uri("/api/v1/quran/ayahs/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.number").isEqualTo(1)
                .jsonPath("$.text").isEqualTo("Sample Ayah Text")
                .jsonPath("$.numberInSurah").isEqualTo(1)
                .jsonPath("$.page").isEqualTo(1)
                .jsonPath("$.surahId").isEqualTo(1)
                .jsonPath("$.hizbId").isEqualTo(1)
                .jsonPath("$.juzId").isEqualTo(1)
                .jsonPath("$.sajda").isEqualTo(true);
    }

    private AyahDTO createSampleAyah() {
        return AyahDTO.builder()
                //.id(1L)
                //.number(1)
                .text("Sample Ayah Text")
                .numberInSurah(1)
                .page(1)
                .surahId(1)
                .hizbId(1)
                .juzId(1)
                .sajda(true)
                .build();
    }
}