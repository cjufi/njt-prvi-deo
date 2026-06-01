package rs.ac.bg.fon.njt.njt_11_05_2026;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.njt_11_05_2026.dto.KnjigaDto;
import rs.ac.bg.fon.njt.njt_11_05_2026.service.KnjigaService;

/**
 *
 * @author Filip
 */
@Component
public class Application {

    private final KnjigaService jdbcService;
    private final KnjigaService springJdbcService;
    private final KnjigaService jpaService;
    private final KnjigaService hibernateService;
    
    @Autowired
    public Application(@Qualifier("jdbc-service") KnjigaService jdbcService,
            @Qualifier("spring-jdbc-service") KnjigaService springJdbcService,
            @Qualifier("jpa-service") KnjigaService jpaService,
            @Qualifier("hibernate-service") KnjigaService hibernateService) {
        this.jdbcService = jdbcService;
        this.springJdbcService = springJdbcService;
        this.jpaService = jpaService;
        this.hibernateService = hibernateService;
    }
    
    public void hibernateSave(KnjigaDto dto) {
        hibernateService.save(dto);
    }

    public void jpaSave(KnjigaDto dto) {
        jpaService.save(dto);
    }

    public void springJdbcSave(KnjigaDto dto) {
        springJdbcService.save(dto);
    }

    public void jdbcSave(KnjigaDto dto) {
        jdbcService.save(dto);
    }

    public void jpaDelete(KnjigaDto dto) {
        jpaService.delete(dto);
    }

    public void hibernateDelete(KnjigaDto dto) {
        hibernateService.delete(dto);
    }

    public void springJdbcDelete(KnjigaDto dto) {
        springJdbcService.delete(dto);
    }

    public void jdbcDelete(KnjigaDto dto) {
        jdbcService.delete(dto);
    }
    
    public void hibernateUpdate(KnjigaDto dto) {
        hibernateService.update(dto);
    }

    public void jpaUpdate(KnjigaDto dto) {
        jpaService.update(dto);
    }

    public void springJdbcUpdate(KnjigaDto dto) {
        springJdbcService.update(dto);
    }

    public void jdbcUpdate(KnjigaDto dto) {
        jdbcService.update(dto);
    }

}
