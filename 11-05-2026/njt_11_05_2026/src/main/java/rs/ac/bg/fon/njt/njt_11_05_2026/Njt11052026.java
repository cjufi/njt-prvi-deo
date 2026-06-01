package rs.ac.bg.fon.njt.njt_11_05_2026;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rs.ac.bg.fon.njt.njt_11_05_2026.config.ApplicationConfig;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Izdavac;
import rs.ac.bg.fon.njt.njt_11_05_2026.domain.Pisac;
import rs.ac.bg.fon.njt.njt_11_05_2026.dto.KnjigaDto;

/**
 *
 * @author Filip
 */
public class Njt11052026 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Application application = applicationContext.getBean(Application.class);

        KnjigaDto dto = new KnjigaDto();
        dto.setNaziv("knjiga4");
//        za update i delete mora da se posalje id, dok za save ne
//        dto.setId(7L);
        dto.setTiraz(5);
        dto.setDatumIzdavanja(LocalDate.of(2026, Month.MAY, 11));
        dto.setIzdavac(new Izdavac(1L, "izdavac1", "123", "123", "Beograd"));
        dto.setPisac(new Pisac(1L, "pera", "pera", "Pera", "Peric", 1999));

        System.out.println("Izaberite broj: 1-jpa, 2-hibernate, 3-springjdbc, 4-jdbc");
        Scanner sc = new Scanner(System.in);
        String input = sc.next().trim();

        if (input.equals("1")) {
            System.out.println(" 1-save, 2-delete, 3-update");
            input = sc.next().trim();
            if (input.equals("1")) {
                System.out.println("save");

                application.jpaSave(dto);
            } else if (input.equals("2")) {
                System.out.println("delete");
                application.jpaDelete(dto);
            } else if (input.equals("3")) {
                System.out.println("update");
                application.jpaUpdate(dto);
            }

        } else if (input.equals("2")) {
            System.out.println("hibernate: 1-save, 2-delete, 3-update");
            input = sc.next().trim();
            if (input.equals("1")) {
                System.out.println("save");
                application.hibernateSave(dto);
            } else if (input.equals("2")) {
                System.out.println("delete");
                application.hibernateDelete(dto);
            } else if (input.equals("3")) {
                System.out.println("update");
                application.hibernateUpdate(dto);
            }
        } else if (input.equals("3")) {
            System.out.println("spring-jdbc: 1-save, 2-delete, 3-update");
            if (sc.next().trim().equals("1")) {
                System.out.println("save");
                application.springJdbcSave(dto);
            } else if (sc.next().trim().equals("2")) {
                System.out.println("delete");
                application.springJdbcDelete(dto);
            } else if (input.equals("3")) {
                System.out.println("update");
                application.springJdbcUpdate(dto);
            }
        } else if (input.equals("4")) {
            System.out.println("jdbc: 1-save, 2-delete, 3-update");
            if (sc.next().trim().equals("1")) {
                System.out.println("save");
                application.jdbcSave(dto);
            } else if (sc.next().trim().equals("2")) {
                System.out.println("delete");
                application.jdbcDelete(dto);
            } else if (input.equals("3")) {
                System.out.println("update");
                application.jdbcUpdate(dto);
            }
        }
    }
}
