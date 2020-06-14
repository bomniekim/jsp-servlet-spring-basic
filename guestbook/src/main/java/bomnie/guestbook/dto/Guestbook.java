package bomnie.guestbook.dto;

import java.util.Date;

public class Guestbook {
	private Long id;
	private String name;
	private String content;
	private Date regDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "Guestbook [id=" + id + ", name=" + name + ", content=" + content + ", regDate=" + regDate + "]";
	}
	

}
