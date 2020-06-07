package bomnie.spring_jdbc.main;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bomnie.spring_jdbc.config.ApplicationConfig;

public class MainClass {

	public static void main(String[] args) {
		
		// config 파일을 읽어드려 컨테이너 생성
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		// DataSource bean 호출
		DataSource ds = ac.getBean(DataSource.class);
		
		// connection 
		Connection connection = null;
		try {
			connection = ds.getConnection();
			if (connection != null) {
				System.out.println("접속 성공!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 예외 여부와 관계없이 실행되는 로직	
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
