package com.myshop.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cart_item") //테이블명지정 //없을시 클래스명으로 자동으로 들어감
@Getter
@Setter
@ToString
public class CartItem {
	
	@Id
	@Column(name="cart_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="item_id")
	private Item item;
	
	private int count;
}
