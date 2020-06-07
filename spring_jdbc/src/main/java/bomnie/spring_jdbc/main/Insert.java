package bomnie.spring_jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bomnie.spring_jdbc.config.ApplicationConfig;
import bomnie.spring_jdbc.dao.RoleDao;
import bomnie.spring_jdbc.dto.Role;

public class Insert {

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		Role role = new Role();
		role.setRoleId(503);
		role.setDesc("CTO");
		
		int insertCount = roleDao.insert(role);
		System.out.println(insertCount + "건의 레코드가 입력되었습니다.");
	}

}
