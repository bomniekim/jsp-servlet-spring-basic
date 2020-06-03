package bomnie.di_study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("bomnie.di_study") // 스캔할 패키지명 명시
// @Controller, @Service, @Repository, @Component 어노테이션이 붙은 클래스를 찾아 컨테이너에 등록
public class ApplicationConfig2 {
	
}
