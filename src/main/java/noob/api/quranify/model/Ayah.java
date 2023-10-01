package noob.api.quranify.model;

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
@Table("ayahs")
public class Ayah {

    @Id
    private Long id;

    @Column("number")
    private int number;

    @Column("text")
    private String text;

    @Column("number_in_surah")
    private int numberInSurah;

    @Column("page")
    private int page;

    @Column("surah_id")
    private int surahId;

    @Column("hizb_id")
    private int hizbId;

    @Column("juz_id")
    private int juzId;

    @Column("sajda")
    private boolean sajda;

    @Column("created_at")
    private Timestamp createdAt;

    @Column("updated_at")
    private Timestamp updatedAt;
}