package bomnie.spring_jdbc.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bomnie.spring_jdbc.config.ApplicationConfig;
import bomnie.spring_jdbc.dao.RoleDao;
import bomnie.spring_jdbc.dto.Role;

public class Update {

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		Role role = new Role();
		role.setRoleId(500);
		role.setDesc("data architecture");
		
		int updateCount = roleDao.update(role);
		System.out.println(updateCount + "건의 레코드가 수정되었습니다.");

	}


}
