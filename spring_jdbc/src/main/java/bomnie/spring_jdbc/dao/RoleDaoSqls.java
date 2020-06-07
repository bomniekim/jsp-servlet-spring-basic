package bomnie.spring_jdbc.dao;

public class RoleDaoSqls {
	
	// final : 상수로 지정
	// 상수명은 모두 대문자로 작성하며, _ 를 사용하여 단어를 구분
	public static final String SELECT_ALL = "SELECT role_id, description FROM ROLE ORDER BY role_id";
	public static final String UPDATE = "UPDATE ROLE SET description = :description WHERE role_id = :roleId";
	public static final String SELECT_BY_ROLE_ID = "SELECT role_id, description FROM ROLE WHERE role_id = :roleId";
	public static final String DELETE_BY_ROLE_ID = "DELETE FROM ROLE WHERE role_id = :roleId";
	// :roleId - 실행할 때 파라미터로 가져온 값으로 바인딩할 값

}
