package board;

import java.sql.Date;

/*
 CREATE TABLE board (
	idx INT PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	pass VARCHAR(16) NOT NULL,
	subject VARCHAR(50) NOT NULL,
	content VARCHAR(2000) NOT NULL,
	date DATE NOT NULL,
	readcount INT NOT NULL
 );
 */
public class BoardDTO {
	private int idx;
	private String name;
	private String pass;
	private String subject;
	private String content;
	private Date date;
	private int readcount;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
}













