package bomnie.guestbook.dao;

// DAO: DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 객체 
import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import bomnie.guestbook.dto.Log;


@Repository
public class LogDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;

    public LogDao(DataSource dataSource) {
    	// jdbc template 객체 생성
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
     // SimpleJdbcInsert 객체 생성
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("log")
                .usingGeneratedKeyColumns("id");
        		// id column의 값을 자동으로 입력하도록 설정
    }

	public Long insert(Log log) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(log);
		return insertAction.executeAndReturnKey(params).longValue();
		// executeAndReturnKey() : insert 문을 내부적으로 만들어 실행하고, 자동 생성된 id 값을 리턴
	}
}
