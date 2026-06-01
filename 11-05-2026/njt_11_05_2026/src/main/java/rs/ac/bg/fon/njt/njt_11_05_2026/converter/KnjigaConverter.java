package rs.ac.bg.fon.njt.njt_11_05_2026.converter;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Knjiga;
import rs.ac.bg.fon.njt.njt_11_05_2026.dto.KnjigaDto;

/**
 *
 * @author Filip
 */
@Component("knjiga-converter") //ovde nema potrebe da se naziva komponenta, jer postoji samo jedna impl ovog interfejsa
public class KnjigaConverter implements Converter<KnjigaDto,Knjiga> {

    @Override
    public Knjiga toEntity(KnjigaDto dto) {
        return new Knjiga(dto.getId(), dto.getNaziv(), dto.getDatumIzdavanja(), dto.getTiraz(), dto.getIzdavac(), dto.getPisac());
    }

    @Override
    public KnjigaDto toDto(Knjiga entity) {
        return new KnjigaDto(entity.getId(), entity.getNaziv(), entity.getDatumIzdavanja(), entity.getTiraz(), entity.getIzdavac(), entity.getPisac());
    }
}
