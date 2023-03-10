package jpaporj.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id @GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private Item item;
	
	@Column(name = "ORDER_PRICE")
	private int orderPrice;
	
	private int count;

	public OrderItem() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if(this.order != null)
			this.order.getOrderItems().remove(this);
		this.order = order;
		order.getOrderItems().add(this);
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		if(this.item != null)
			this.item.getOrderItems().remove(this);
		this.item = item;
		item.getOrderItems().add(this);
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
