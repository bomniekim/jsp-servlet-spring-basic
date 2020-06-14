package bomnie.guestbook.dao;

// static import: 다른 클래스의 맴버 변수나 맴버 메서드를 경로를 생략하고 사용 가능
import static bomnie.guestbook.dao.GuestbookDaoSqls.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import bomnie.guestbook.dto.Guestbook;

@Repository
public class GuestbookDao {
	private NamedParameterJdbcTemplate template;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Guestbook> rowMapper = BeanPropertyRowMapper.newInstance(Guestbook.class);

	// 생성자
	// DAO 객체 생성시 dataSource 를 인자로 넣어줌
	public GuestbookDao(DataSource dataSource) {
		// jdbc template 객체 생성
		this.template = new NamedParameterJdbcTemplate(dataSource);
		// SimpleJdbcInsert 객체 생성
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("guestbook").usingGeneratedKeyColumns("id");
	}
	
	

	// select all
	public List<Guestbook> selectAll(Integer start, Integer limit) {
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("start", start);
		paramMap.put("limit", limit);

		// template.query(sql, Map, RowMapper);
		return template.query(SELECT_PAGING, paramMap, rowMapper);
	}

	
	
	
	// insert
	public Long insert(Guestbook guestbook) {
		// guestbook 객체의 변수를 DB 컬럼명에 맞추어 Map 반환
		SqlParameterSource paramMap = new BeanPropertySqlParameterSource(guestbook);

		// SimpleJdbcInsert
		// paramMap insert 실행 및 새로 생성된 id 리턴
		return insertAction.executeAndReturnKey(paramMap).longValue();
	}
	
	
	
	
	// delete by id
	public int deleteById(Long id) {
		// singletonMap() : 1 개의 값을 Map 으로 반환
		Map<String, ?> paramMap = Collections.singletonMap("id", id);
		// 업데이트된 레코드의 개수 리턴
		return template.update(DELETE_BY_ID, paramMap);
	}
	
	
	
	// 전체 레코드 개수 조회
	public int selectCount() {
		Map<String, ?> paramMap = Collections.emptyMap();
		return template.queryForObject(SELECT_COUNT, paramMap, Integer.class);
	}
	

}