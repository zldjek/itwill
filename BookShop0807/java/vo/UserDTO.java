package vo;

/*
create table user_info(
user_id varchar(20) primary key not null,
user_name varchar(20) not null,
user_passwd varchar(30) not null,
user_address varchar(100) not null,
user_phone varchar(40) not null,
user_emial varchar(40) not null
);
INSERT INTO user_info VALUES('hong','홍길동','1234','부산','010-1111-2345','aaa@aaa.com');
 */
public class UserDTO {
	private String user_id;
	private String user_name;
	private String user_passwd;
	private String user_address;
	private String user_phone;
	private String user_email;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_passwd() {
		return user_passwd;
	}

	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Override
	public String toString() {
		return "UserDTO [user_id=" + user_id + ", user_name=" + user_name + ", user_passwd=" + user_passwd
				+ ", user_address=" + user_address + ", user_phone=" + user_phone + ", user_email=" + user_email + "]";
	}

}