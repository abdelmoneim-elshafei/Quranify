package noob.api.quranify.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AyahDTO {

    private Long id;

    private int number;

    private String text;

    private int numberInSurah;

    private int page;

    private int surahId;

    private int hizbId;

    private int juzId;

    private boolean sajda;

}