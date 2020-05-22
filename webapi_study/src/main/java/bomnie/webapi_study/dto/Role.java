package bomnie.webapi_study.dto;

public class Role {
	private Integer roleId;
	private String description;
	
	
	public Role() {
	}

	public Role(Integer roleId, String description) {
		super();
		this.roleId = roleId;
		this.description = description;
	}
	
	
	// Role 클래스 객체에 값을 넣고 빼기 위한 getters and setters
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getDesc() {
		return description;
	}
	public void setDesc(String description) {
		this.description = description;
	}
	
	
	// Role 객체가 가진 값들을 쉽게 출력할 수 있도록
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", desc=" + description + "]";
	}
	
}
