package bomnie.guestbook.service.impl;

import java.util.Date;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bomnie.guestbook.config.ApplicationConfig;
import bomnie.guestbook.dto.Guestbook;
import bomnie.guestbook.service.GuestbookService;

public class GuestbookServiceTest {

	public static void main(String[] args) {

		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookService guestbookService = ac.getBean(GuestbookService.class);
		
		Guestbook guestbook = new Guestbook();
		guestbook.setName("랄랄라");
		guestbook.setContent("사랑해 히히");
		guestbook.setRegDate(new Date());
		
		Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);
	}

}
