package bomnie.spring_jdbc.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import bomnie.spring_jdbc.dto.Role;

//static import : 다른 클래스의 객체들을 클래스 이름 없이 바로 가져다 사용할 수 있도록 
import static bomnie.spring_jdbc.dao.RoleDaoSqls.*;

@Repository
// 저장소 역할
public class RoleDao {
	
	// 1) select 를 위한 객체
	// 기존이 jdbcTemplate의 ? 대신 이름을 이용해서 바인딩하거나 결과값을 가져옴
	private NamedParameterJdbcTemplate jdbc;
	
	
	// 2) insert 를 위한 객체
	// 쿼리문 없이 execute(params)으로 파라미터 값을 데이터에 바로 넣어주는 객체
	private SimpleJdbcInsert insertAction;
	
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	

	// 생성자
	// Config파일에서 bean으로 등록했던 datasource가 파라미터로 전달  
	// spring 4.3 ver 부터는 ComponentScan으로 객체를 찾았을 때 기본 생성자가 없다면 자동으로 객체 주입 
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
	}
	
	
	// 1) select
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL,Collections.emptyMap(), rowMapper);
		// Collections.emptyMap() : sql문에 바인딩 할 값이 있을 경우 바인딩 할 값을 전달
		// rowMapper: 조회 결과를 한 건씩 DTO 에 저장 (column의 값을 자동으로 DTO에 저장)
		// query(): 결과가 여러 건인 경우 내부적으로 반복하며 DTO 생성 후 List에 담는다.
	}
	

	// 2) insert
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		// Role 객체의 변수명을 데이터 컬럼명에 맞게 Map 객체로 만들어준다. (params)
		return insertAction.execute(params);
		// 조작된 레코드의 수를 반환한다. (int)
	}
	
		
	// 3) update
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		// Role 객체의 변수명을 데이터 컬럼명에 맞게 알아서 Map 객체로 만들어줌
		return jdbc.update(UPDATE, params);
		// jdbc.update(sql, Map 데이터)
	}
		
	
	// 4) delete by role_id
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("roleId", id);
		// int, String 등의 값을 Role 객체의 변수에 넣어준다.
		// singletonMap()는 값이 1개일 때 사용
		return jdbc.update(DELETE_BY_ROLE_ID, params);
		// jdbc.update(sql, Map 객체)
	}

	
	// 5) select by role_id 
	public Role selectById(Integer id) {
		try {
			Map<String, ?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper); 
			// queryForObject()는 한 건 select하는 경우 
		}
		catch (EmptyResultDataAccessException e) {
			return null;
			// 조건에 맞는 데이터가 없는 경우, null 을 리턴
		}
	}
}
