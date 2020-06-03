package bomnie.di_study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest02 {
	// applicationContext.xml의 bean c, e을 읽어들이는 객체 클래스 

	public static void main(String[] args) {
		
		// classpath 에 명시된 설정 파일을 토대로 공장 만들기 - spring container
		ApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("공장 제작 완료");
		
		Car car = (Car)aContext.getBean("c");
		car.run(); // Car의 main 메소드가 하는 일을 컨테이너가 대신 해줌
		
	}

}
