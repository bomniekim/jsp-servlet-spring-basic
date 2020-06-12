package bomnie.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = {"bomnie.guestbook.dao", "bomnie.guestbook.service"})
@Import({DBconfig.class})
public class ApplicationConfig {

}