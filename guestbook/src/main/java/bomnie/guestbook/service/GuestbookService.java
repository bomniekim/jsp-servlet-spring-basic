package bomnie.guestbook.service;

import java.util.List;

import bomnie.guestbook.dto.Guestbook;

// Service Interface
// 비즈니스 로직 요구 사항이 무엇?
public interface GuestbookService {

	// 페이징을 위한 상수
	public static final Integer LIMIT = 5;
		
	public List<Guestbook> getGuestbooks(Integer start);

	// 등록, 삭제의 경우 ip를 전달하여 LogDao를 이용하여 Log 테이블에 데이터 저장
	public Guestbook addGuestbook(Guestbook guestbook, String ip);
	public int deleteGuestbook(Long id, String ip); // id에 해당하는 방명록 삭제
	public int getCount();
}
