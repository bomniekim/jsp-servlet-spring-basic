package bomnie.guestbook.argumentresolver;

import java.util.HashMap;
import java.util.Map;


// Map 이나 Map 을 상속받고 있는 객체는 스프링에서 이미 선언한 argument resolver가 선처리하기 때문에 직접 사용할 수 없음
// Map객체를 전달하려면 Map을 필드로 가지고 있는 별도의 객체를 선언한 후 사용해야 함

public class HeaderInfo {

	private Map<String, String> map;
	
	public HeaderInfo() {
		map = new HashMap<>();
	}

	public void put(String name, String value) {
		map.put(name,  value);
	}
	
	public String get(String name) {
		return map.get(name);
	}
}
