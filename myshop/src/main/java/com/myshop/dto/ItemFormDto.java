package com.myshop.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemFormDto {
	
	private Long id; //상품코드
	
	@NotBlank(message = "상품명은 필수 입력 값입니다.")
	private String itemNm; //상품명
	
	@NotNull(message = "가격은 필수 입력 값입니다.")
	private int price; //가격
	
	@NotNull(message = "재고는 필수 입력 값입니다.")
	private int stockNumber; //재고수량

	@NotBlank(message = "상품 상세설명은 필수 입력 값입니다.")
	private String itemDetail; //상품상세 설정
	
	private ItemSellStatus itemSellStatus; //상품 판매상태
 
	private List<ItemImgDto> itemImgDtoList = new ArrayList<>(); //상품 이미지 정보를 저장하는 리스트
	
	private List<Long> itemImgIds = new ArrayList<>(); //상품의 이미지 아이디를 저장 -> 수정시에 이미지 아이디를 담아 둘 용도.
	
	private static ModelMapper modelmapper = new ModelMapper();
	
	public Item createItem() {
		return modelmapper.map(this, Item.class);
	}
	
	public static ItemFormDto of(Item item) {
		return modelmapper.map(item, ItemFormDto.class);
	}
}
