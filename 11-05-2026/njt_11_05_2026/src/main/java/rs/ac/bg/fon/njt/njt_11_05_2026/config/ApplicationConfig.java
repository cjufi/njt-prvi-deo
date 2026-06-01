package rs.ac.bg.fon.njt.njt_11_05_2026.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import rs.ac.bg.fon.njt.njt_11_05_2026.converter.Converter;
import rs.ac.bg.fon.njt.njt_11_05_2026.repository.KnjigaRepository;
import rs.ac.bg.fon.njt.njt_11_05_2026.service.KnjigaService;
import rs.ac.bg.fon.njt.njt_11_05_2026.service.impl.KnjigaServiceImpl;

/**
 *
 * @author Filip
 */
@ComponentScan(basePackages = {
    "rs.ac.bg.fon.njt.njt_11_05_2026"
})
public class ApplicationConfig {
    
//    JPA
    @Bean("emf")
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("appPU");
    }

    @Bean("jpa-service")
    public KnjigaService jpaKnjigaService(@Qualifier("jpa-repository") KnjigaRepository knjigaRepository, @Qualifier("knjiga-converter") Converter converter) {
        return new KnjigaServiceImpl(knjigaRepository, converter);
    }
    
//    Hibernate
    @Bean("sf")
    public SessionFactory sessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }   
    
    @Bean("hibernate-service")
    public KnjigaService hibernateKnjigaService(@Qualifier("hibernate-repository") KnjigaRepository knjigaRepository, @Qualifier("knjiga-converter") Converter converter) {
        return new KnjigaServiceImpl(knjigaRepository, converter);
    }
    
//    Spring JDBC
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:mysql://localhost:3306/njt2026_c4");
        datasource.setUsername("root");
        datasource.setPassword("rootroot");
        return datasource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    
    @Bean("spring-jdbc-service")
    public KnjigaService springJdbcKnjigaService(@Qualifier("hibernate-repository") KnjigaRepository knjigaRepository, @Qualifier("knjiga-converter") Converter converter) {
        return new KnjigaServiceImpl(knjigaRepository, converter);
    } 
    
//    JDBC
    @Bean
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/njt_1_kolokv_maj_2026",
                        "root",
                        "rootroot");
    }
    
    @Bean("jdbc-service")
    public KnjigaService jdbcService(@Qualifier("jdbc-repository")KnjigaRepository knjigaRepository, @Qualifier("knjiga-converter") Converter converter) {
        return new KnjigaServiceImpl(knjigaRepository, converter);
    }
}
