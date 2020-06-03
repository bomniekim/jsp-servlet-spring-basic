package bomnie.di_study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// 스프링 설정 클래스를 선언하는 어노테이션
public class ApplicationConfig {

	@Bean
	public Car car(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
	
	
}
