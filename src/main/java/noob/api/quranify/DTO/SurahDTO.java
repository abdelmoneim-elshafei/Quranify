package noob.api.quranify.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurahDTO {
    private Long id;

    private Integer number;

    private String nameArabic;

    private String nameEnglish;

    private String nameEnglishTranslation;

    private String type;

}