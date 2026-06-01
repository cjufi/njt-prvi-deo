package rs.ac.bg.fon.njt.njt_11_05_2026.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Knjiga;
import rs.ac.bg.fon.njt.njt_11_05_2026.repository.KnjigaRepository;

/**
 *
 * @author Filip
 */
@Repository("spring-jdbc-repository")
public class KnjigaSpringJDBCRepository implements KnjigaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public KnjigaSpringJDBCRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Knjiga save(Knjiga knjiga) {
        jdbcTemplate.update("INSERT INTO knjiga VALUES (?,?,?,?,?)",
                knjiga.getNaziv(), knjiga.getDatumIzdavanja(),
                knjiga.getTiraz(), knjiga.getIzdavac().getId(),
                knjiga.getPisac().getId());
        
        return knjiga;
    }

    @Override
    public void delete(Knjiga knjiga) {
        jdbcTemplate.update("DELETE FROM knjiga WHERE id = ?", knjiga.getId());
    }

    @Override
    public boolean existsById(Long id) {
        String sql = "SELECT COUNT(*) FROM knjiga WHERE id = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return count != null && count > 0;
    }

    @Override
    public boolean existsByName(String name) {
        String sql = "SELECT COUNT(*) FROM knjiga WHERE naziv = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, name);

        return count != null && count > 0;
    }

    @Override
    public Knjiga update(Knjiga knjiga) {
        jdbcTemplate.update("""
                        UPDATE knjiga
                        SET naziv = ?,
                            datum_izdavanja = ?,
                            tiraz = ?,
                            izdavac_id = ?,
                            pisac_id = ?
                        WHERE id = ?
                        """,
                knjiga.getNaziv(),
                knjiga.getDatumIzdavanja(),
                knjiga.getTiraz(),
                knjiga.getIzdavac().getId(),
                knjiga.getPisac().getId(),
                knjiga.getId());

        return knjiga;
    }

}
