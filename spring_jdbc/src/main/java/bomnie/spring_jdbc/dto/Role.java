package bomnie.spring_jdbc.dto;

public class Role {
	private int roleId;
	private String desc;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	// 실제 객체가 가진 값들을 쉽게 볼 수 있도록
	public String toString() {
		return "Role [roleId=" + roleId + ", desc=" + desc + "]";
	}
	
	
	

}
