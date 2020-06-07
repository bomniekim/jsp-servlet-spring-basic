package bomnie.spring_jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bomnie.spring_jdbc.config.ApplicationConfig;
import bomnie.spring_jdbc.dao.RoleDao;
import bomnie.spring_jdbc.dto.Role;

public class SelectById {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		Role role = roleDao.selectById(500);
		
		if (role !=null) {
			System.out.println(role);			
		}
		else {
			System.out.println("일치하는 레코드가 없습니다.");
		}

	}
}
