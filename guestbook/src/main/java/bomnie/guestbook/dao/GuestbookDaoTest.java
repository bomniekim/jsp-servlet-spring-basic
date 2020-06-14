package bomnie.guestbook.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bomnie.guestbook.config.ApplicationConfig;
import bomnie.guestbook.dto.Guestbook;
import bomnie.guestbook.dto.Log;

public class GuestbookDaoTest {

	// 단위 테스트를 위한 클래스 
	public static void main(String[] args) {


		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
//		GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);
//		
//		Guestbook guestbook = new Guestbook();
//		guestbook.setName("김보민");
//		guestbook.setContent("안녕하세요.");
//		guestbook.setRegDate(new Date());
//		
//		Long id = guestbookDao.insert(guestbook); // 생성된 id 값 리턴
//		System.out.println("id: "+id + "개의 레코드가 추가되었습니다.");
		
		LogDao logDao = ac.getBean(LogDao.class);
		
		Log log = new Log();
		log.setIp("127.0.0.1");
		log.setMethod("insert");
		log.setRegDate(new Date());
		logDao.insert(log);
		
		
		
	}

}
