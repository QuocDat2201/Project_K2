package entites;

import java.util.Date;

public class Report {
	private int id;
	private String content;
	private int role_sent; // from
	private int role_report; // to
	private Date create;
	
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRole_sent() {
		return role_sent;
	}
	public void setRole_sent(int role_sent) {
		this.role_sent = role_sent;
	}
	public int getRole_report() {
		return role_report;
	}
	public void setRole_report(int role_report) {
		this.role_report = role_report;
	}
	
	
}
