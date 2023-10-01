package noob.api.quranify.mapper;

import noob.api.quranify.DTO.SurahDTO;
import noob.api.quranify.model.Surah;
import org.mapstruct.Mapper;

@Mapper
public interface SurahMapper {
    public Surah surahDTOToSurah(SurahDTO surahDTO);
    public SurahDTO surahToSurahDTO(Surah surah);
}
