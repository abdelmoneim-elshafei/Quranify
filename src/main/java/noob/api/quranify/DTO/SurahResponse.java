package noob.api.quranify.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurahResponse {
    String surahName;
    String surahType;
    Integer numberOfAyahs;
    List<String> surahBody;
}
