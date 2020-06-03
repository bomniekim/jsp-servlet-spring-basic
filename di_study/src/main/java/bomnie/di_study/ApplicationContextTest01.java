package bomnie.di_study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest01 {
	// applicationContext.xml 파일의 userBean을 읽어들이는 객체 클래스 

	public static void main(String[] args) {
		
		// classpath 에 명시된 설정 파일을 토대로 공장 만들기 - spring container
		ApplicationContext aContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("공장 제작 완료");
		
		// (xml 설정 파일을 토대로 만든) 공장으로부터 id가 userBean인 bean 얻어낸 후 클래스 대신 생성 (* IoC)
		// 공장에는 다양한 bean이 존재하므로 object로 리턴해주므로 형변환 필요
		UserBean userBean = (UserBean)aContext.getBean("userBean");
		userBean.setName("bomnie");
		
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)aContext.getBean("userBean");
		
		if(userBean == userBean2) System.out.println("같은 인스턴스 입니다.");
		// 사용자가 계속해서 getBean()으로 ApplicationContext에게 요청해도
		// 싱글톤 패턴으로 관리하기 때문에 만들어진 하나의 bean만 이용
		
	}

}
