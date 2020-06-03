package bomnie.di_study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextAnnotation {

	public static void main(String[] args) {
		// java config 파일의 설정 bean을 읽어들여 공장 세우기
		ApplicationContext aContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
//		Car car = (Car)aContext.getBean("car");
		
		// 클래스 리턴 타입으로 bean 호출하기 
		Car car = (Car)aContext.getBean(Car.class);
		car.run(); 
	}
}
