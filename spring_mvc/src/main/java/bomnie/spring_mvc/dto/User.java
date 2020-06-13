package bomnie.spring_mvc.dto;

// request parameter로 전달될 변수들을 객체화시켜 값의 전달과 이동이 쉽도록!
public class User {
	private String name;
	private int age;
	private String email;
	
	// private한 변수들에 접근하기 위해 getter and setter 설정
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + "]";
	}
	
}
