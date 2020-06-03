package bomnie.di_study;

import org.springframework.stereotype.Component;

@Component
// 컴포넌트 스캔의 대상이 되는 애노테이션 중 하나로써 주로 유틸, 기타 지원 클래스에 붙이는 어노테이션
public class Engine {

		public Engine() {
			System.out.println("Engine 기본 생성자");
		}
		
		public void exec() {
			System.out.println("엔진이 동작합니다.");
		}
	
}
