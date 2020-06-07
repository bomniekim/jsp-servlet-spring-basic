package bomnie.spring_jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bomnie.spring_jdbc.config.ApplicationConfig;
import bomnie.spring_jdbc.dao.RoleDao;

public class Delete {


	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		int deleteCount = roleDao.deleteById(503);
		System.out.println(deleteCount + " 개의 레코드가 삭제되었습니다.");

	}
}
