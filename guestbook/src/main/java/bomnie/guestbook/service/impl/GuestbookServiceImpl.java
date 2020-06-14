package bomnie.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bomnie.guestbook.dao.GuestbookDao;
import bomnie.guestbook.dao.LogDao;
import bomnie.guestbook.dto.Guestbook;
import bomnie.guestbook.dto.Log;
import bomnie.guestbook.service.GuestbookService;

@Service // 전체적인 비즈니스 로직
public class GuestbookServiceImpl implements GuestbookService {

	@Autowired
	// 데이터 관련 로직을 불러와서 사용
	GuestbookDao guestbookDao;
	
	@Autowired
	LogDao logDao;
	
	@Override
	@Transactional
	// 읽기만 하는 메서드에 붙여주면 내부적으로 readOnly라는 형태로 connection을 사용하게 됨
	// 1) guestbook 목록 가져오기
	public List<Guestbook> getGuestbooks(Integer start) {
		List<Guestbook> list = guestbookDao.selectAll(start, GuestbookService.LIMIT);
		return list;
	}
	
	
	@Override
	@Transactional(readOnly = false)
	// 2) 레코드 한 건 삭제
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount = guestbookDao.deleteById(id);
		// 입력받아 온 id의 값을 가지고 와서 삭제 
		
		// 삭제 후 log 남기기
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("delete");
		log.setRegDate(new Date());
		logDao.insert(log);
		
		return deleteCount;
	}
	
	
	
	@Override
	@Transactional(readOnly = false)
	// 3) 레코드 한 건 추가
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		guestbook.setRegDate(new Date());
		Long id = guestbookDao.insert(guestbook);
		guestbook.setId(id); // 로그 입력을 위해
		
//		if(1==1) throw new RuntimeException("test");
		// transaction은 나눌 수 없는 하나의 작업 단위
		// 중간에 exception/error 발생 시 성공했던 작업도 취소 - 트랜잭션의 '원자성'
		
		
		// 입력 후 log 남기기
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegDate(new Date());
		logDao.insert(log);
		
		return guestbook;
	}
	
	
	
	@Override
	// 페이징 처리를 위해 전체 건수 구해오기
	public int getCount() { 
		return guestbookDao.selectCount();
	}
}
