package rs.ac.bg.fon.njt.njt_ditime;

import java.time.LocalTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njt.njt_ditime.config.DiTimeConfig;

/**
 *
 * @author Filip
 */

@Component
public class DiTimeApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DiTimeConfig.class);
        
        DiTimeApp app = context.getBean(DiTimeApp.class);
        
        app.prikaziVreme();
    }
    
    private void prikaziVreme() {
        System.out.println(LocalTime.now());
    }
}

