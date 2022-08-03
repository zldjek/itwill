package vo;
/*
create table member_info(
member_id varchar(20) primary key,
member_name varchar(20) not null,
member_passwd varchar(30) not null,
member_address varchar(100) not null,
member_phone varchar(40) not null,
member_emial varchar(40) not null
);
INSERT INTO member_info VALUES('hong','홍길동','1234','부산','010-1111-2345','aaa@aaa.com');
 */
public class MemberDTO {
	private String member_id;
	private String member_name;
	private String member_passwd;
	private String member_address;
	private String member_phone;
	private String member_email;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_passwd() {
		return member_passwd;
	}
	public void setMember_passwd(String member_passwd) {
		this.member_passwd = member_passwd;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	@Override
	public String toString() {
		return "MemberDTO [member_id=" + member_id + ", member_name=" + member_name + ", member_passwd=" + member_passwd
				+ ", member_address=" + member_address + ", member_phone=" + member_phone + ", member_email="
				+ member_email + "]";
	}
	
	
}