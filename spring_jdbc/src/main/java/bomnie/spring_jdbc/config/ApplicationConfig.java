package bomnie.spring_jdbc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBconfig.class}) // 설정파일을 여러 개로 나눠서 작성할 수 있도록하는 어노테이션
public class ApplicationConfig {

}
