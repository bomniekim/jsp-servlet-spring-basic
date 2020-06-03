package bomnie.di_study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	// 주입 대상이 되는 bean을 찾아 컨테이너에 주입하는 어노테이션
	// 주입하려고 하는 객체의 타입이 일치하는지를 찾고 객체를 자동으로 주입
	@Autowired
	private Engine v8;
	
	public Car() {
		System.out.println("Car 기본 생성자");
	}
	
	public void setEngine(Engine e) {
		this.v8 = e;
	// @Autowired가 알아서 해주므로 setter 필요 없음
	}
	
	public void run() {
		System.out.println("자동차가 엔진을 이용하여 달립니다.");
		v8.exec();
	}

//	public static void main(String[] args) {
//		Engine e = new Engine();
//		Car c = new Car();
//		c.setEngine(e);
//		c.run();
//	}
	
	// 메인 메소드가 하는 일을 Spring IoC 컨테이너가 하게 하려면 xml 설정 파일에 bean 등록 필요
}
