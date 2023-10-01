package noob.api.quranify.mapper;

import noob.api.quranify.DTO.AyahDTO;
import noob.api.quranify.model.Ayah;
import org.mapstruct.Mapper;

@Mapper
public interface AyahMapper {
    public Ayah ayahDTOToAyah(AyahDTO ayahDTO);
    public AyahDTO ayahToAyahDTO(Ayah ayah);
}
