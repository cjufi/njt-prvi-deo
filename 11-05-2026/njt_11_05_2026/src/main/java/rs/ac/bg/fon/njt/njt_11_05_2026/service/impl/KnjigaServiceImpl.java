package rs.ac.bg.fon.njt.njt_11_05_2026.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.bg.fon.njt.njt_11_05_2026.converter.Converter;
import rs.ac.bg.fon.njt.njt_11_05_2026.converter.KnjigaConverter;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Knjiga;
import rs.ac.bg.fon.njt.njt_11_05_2026.dto.KnjigaDto;
import rs.ac.bg.fon.njt.njt_11_05_2026.exception.KnjigaDoesNotExistException;
import rs.ac.bg.fon.njt.njt_11_05_2026.exception.KnjigaExistException;
import rs.ac.bg.fon.njt.njt_11_05_2026.repository.KnjigaRepository;
import rs.ac.bg.fon.njt.njt_11_05_2026.service.KnjigaService;

/**
 *
 * @author Filip
 */
public class KnjigaServiceImpl implements KnjigaService {

    private final KnjigaRepository knjigaRepository;
    private final Converter converter;
    
    @Autowired
    public KnjigaServiceImpl(KnjigaRepository knjigaRepository, Converter converter) {
        this.knjigaRepository = knjigaRepository;
        this.converter = converter;
    }
    
    @Override
    public KnjigaDto save(KnjigaDto dto) {
        
        if(knjigaRepository.existsByName(dto.getNaziv())) {
            throw new KnjigaExistException("Knjiga sa ovim nazivom vec postoji!");
        }
        
        Knjiga knjiga = (Knjiga) converter.toEntity(dto);
        knjigaRepository.save(knjiga);
        
        return (KnjigaDto) converter.toDto(knjiga);
    }

    @Override
    public void delete(KnjigaDto dto) {
        if(!knjigaRepository.existsById(dto.getId())) {
            throw new KnjigaDoesNotExistException("Knjiga koju pokusavate da obrisete ne postoji!");
        }
        knjigaRepository.delete((Knjiga)converter.toEntity(dto));
    }

    @Override
    public KnjigaDto update(KnjigaDto dto) {
        
        Knjiga knjiga = (Knjiga) converter.toEntity(dto);
        knjigaRepository.update(knjiga);
        
        return (KnjigaDto) converter.toDto(knjiga);
    }
    
}
