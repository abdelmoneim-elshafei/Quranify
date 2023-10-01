package noob.api.quranify.repository;

import noob.api.quranify.model.Ayah;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AyahRepository extends R2dbcRepository<Ayah, Long> {

}