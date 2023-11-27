package foodorder_DTO;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String food_item;
	@Column(nullable = false)
	private int cost;
	@CreationTimestamp
	private LocalDateTime ordered_time;
	@UpdateTimestamp
	private LocalDateTime delivery_time;
	@Column(nullable = false)
	private String address;
	@ManyToOne
	@JoinColumn(name = "foodorder_id")
	private User users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFood_item() {
		return food_item;
	}

	public void setFood_item(String food_item) {
		this.food_item = food_item;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public LocalDateTime getOrdered_time() {
		return ordered_time;
	}

	public void setOrdered_time(LocalDateTime ordered_time) {
		this.ordered_time = ordered_time;
	}

	public LocalDateTime getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(LocalDateTime delivery_time) {
		this.delivery_time = delivery_time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

}
