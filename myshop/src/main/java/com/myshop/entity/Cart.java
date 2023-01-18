package com.myshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="cart") //테이블명지정 //없을시 클래스명으로 자동으로 들어감
@Getter
@Setter
@ToString
public class Cart {
	
	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@OneToOne(fetch = FetchType.LAZY) //1:1 관계
	@JoinColumn(name="member_id") //join ,  자식 entity
	private Member member;
}
