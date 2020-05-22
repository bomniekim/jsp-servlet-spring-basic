package bomnie.jdbc_study;


import java.util.List;

import bomnie.jdbc_study.dao.RoleDao;
import bomnie.jdbc_study.dto.Role;

public class JDBCmain {
	
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		
		// getRole() 확인
//		Role role = dao.getRole(100);
//		System.out.println(role);
		
		
		// addRole() 확인
		// 추가할 데이터 
//		int roleId = 501;
//		String description = "CTO";
//		
//		Role role = new Role(roleId, description);
//		int insertCount = dao.addRole(role);
//		System.out.println(insertCount + " 개의 레코드가 추가되었습니다.");
		
		
		// updateRole() 확인
		// 수정할 데이터 
//		int roleId = 300;
//		String description = "Publisher";
//		Role role = new Role(roleId, description);
//		int updateCount = dao.updateRole(role);
//		System.out.println(updateCount + " 개의 레코드가 수정되었습니다.");
		
		
		// deleteRole() 확인
		// 삭제할 데이터
//		int roleId = 501;
//		int deleteCount = dao.deleteRole(roleId);
//		System.out.println(deleteCount + " 개의 레코드가 삭제되었습니다.");

		
		
		
//		for (declaration : expression){ // (변수 선언 : 배열/배열을 리턴하는 함수)
//	} Enhanced For loop
		List<Role> list = dao.getRoles();
		for (Role role : list) {
			System.out.println(role);
		}
	}
}














