package rs.ac.bg.fon.njt.njt_11_05_2026.repository;

import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Knjiga;

/**
 *
 * @author Filip
 */
public interface KnjigaRepository {
    Knjiga save(Knjiga knjiga);

    void delete(Knjiga knjiga);

    Knjiga update(Knjiga knjiga);

    boolean existsById(Long id);

    boolean existsByName(String name);
}
