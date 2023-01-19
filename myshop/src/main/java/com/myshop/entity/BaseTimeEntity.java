package com.myshop.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;


@EntityListeners(value= {AuditingEntityListener.class}) //Auditing을 적용하기 위해
@MappedSuperclass //부모 클래스를 상속받는 자식 클래스한테 매핑정보만 제공
@Getter
@Setter
public class BaseTimeEntity {
	
	@CreatedDate  //엔티티가 생성되서 저장될때 시간을 자동으로 저장
	@Column(updatable = false)
	private LocalDateTime regTime; //등록날짜

	@LastModifiedDate
	private LocalDateTime upDateTime; //수정날짜
}
