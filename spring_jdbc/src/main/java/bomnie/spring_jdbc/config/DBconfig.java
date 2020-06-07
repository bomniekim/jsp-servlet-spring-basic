package bomnie.spring_jdbc.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"bomnie.spring_jdbc.dao"}) // 여러 패키지 나열하여 사용 가능
// // Controller, Component, Repository, Service 를 찾아내 bean으로 등록
@EnableTransactionManagement
public class DBconfig {

	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/bomin_DB?useSSL=false&serverTimezone=UTC";
	private String user = "bomnie";
	private String pwd = "bomin331";
	
	@Bean
	public DataSource dataSource() { // 커넥션 관리
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(pwd);	
		return dataSource;
	}
	
}
