package rs.ac.bg.fon.njt.njt_11_05_2026.service;

import rs.ac.bg.fon.njt.njt_11_05_2026.dto.KnjigaDto;

/**
 *
 * @author Filip
 */
public interface KnjigaService {
    KnjigaDto save(KnjigaDto dto);
    
    void delete(KnjigaDto dto);
    
    KnjigaDto update(KnjigaDto dto);
}
