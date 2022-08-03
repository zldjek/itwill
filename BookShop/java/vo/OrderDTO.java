package vo;

import java.util.*;

/*
create table order_info(
order_id int primary key,
order_kind varchar(30) not null,
order_price int not null,
order_image varchar(50) not null,
order_content varchar(400),
order_count int
);

 */
public class OrderDTO {
	private int order_id;
	private String order_kind;
	private int order_price;
	private String order_image;
	private String order_content;
	private int order_count;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_kind() {
		return order_kind;
	}
	public void setOrder_kind(String order_kind) {
		this.order_kind = order_kind;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public String getOrder_image() {
		return order_image;
	}
	public void setOrder_image(String order_image) {
		this.order_image = order_image;
	}
	public String getOrder_content() {
		return order_content;
	}
	public void setOrder_content(String order_content) {
		this.order_content = order_content;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	@Override
	public String toString() {
		return "OrderDTO [order_id=" + order_id + ", order_kind=" + order_kind + ", order_price=" + order_price
				+ ", order_image=" + order_image + ", order_content=" + order_content + ", order_count=" + order_count
				+ "]";
	}
	
}