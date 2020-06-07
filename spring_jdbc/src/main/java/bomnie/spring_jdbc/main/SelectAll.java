package bomnie.spring_jdbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bomnie.spring_jdbc.config.ApplicationConfig;
import bomnie.spring_jdbc.dao.RoleDao;
import bomnie.spring_jdbc.dto.Role;

public class SelectAll {

public static void main(String[] args) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao = ac.getBean(RoleDao.class);
		
		List<Role> list = roleDao.selectAll();
		
		for (Role role : list) {
			System.out.println(role);
		}
		
	}

}
