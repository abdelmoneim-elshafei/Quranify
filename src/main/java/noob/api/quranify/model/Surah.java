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
@Table("surahs")
public class Surah {
    @Id
    private Integer id;

    @Column("number")
    private Integer number;

    @Column("name_ar")
    private String nameArabic;

    @Column("name_en")
    private String nameEnglish;

    @Column("name_en_translation")
    private String nameEnglishTranslation;

    @Column("type")
    private String type;

    @Column("created_at")
    private Timestamp createdAt;

    @Column("updated_at")
    private Timestamp updatedAt;

    // Constructors, getters, and setters
}