package bomnie.guestbook.dto;

import java.util.Date;

public class Log {
	private Long id;
	private String ip;
	private String method;
	private Date regDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		return "Log [id=" + id + ", ip=" + ip + ", method=" + method + ", regDate=" + regDate + "]";
	}
	
	

}
