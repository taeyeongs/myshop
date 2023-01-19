package com.myshop.repository;

import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;
import com.myshop.entity.QItem;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.thymeleaf.util.StringUtils;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepository;
	
	@PersistenceContext //영속성 컨텍스트를 사용하기 위해 선언
	EntityManager em;
	
	//테스트할 메서드 마다 @Test를 붙여준다.
//	@Test
//	@DisplayName("상품 저장 테스트") //구분하기위한 이름
//	public void createItemTest() {
//		Item item = new Item();
//		item.setItemNm("테스트 상품");
//		item.setPrice(10000);
//		item.setItemDetail("테스트 상품 상세 설명");
//		item.setItemSellStatus(ItemSellStatus.SELL);
//		item.setStockNumber(100);
//		item.setRegTime(LocalDateTime.now());
//		item.setUpdateTime(LocalDateTime.now());
//		
//		Item savedItem = itemRepository.save(item);//데이터 insert
//		
//		System.out.println(savedItem.toString());
//	}
	
	public void createItemTest() {
		for (int i=1; i <= 10; i ++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now());
//			item.setUpdateTime(LocalDateTime.now());
			
			Item savedItem = itemRepository.save(item);//데이터 insert
		}
	}
	
	public void createItemTest2() {
		for (int i=1; i <= 5; i ++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now());
//			item.setUpdateTime(LocalDateTime.now());
			
			Item savedItem = itemRepository.save(item);//데이터 insert
		}
		
		for (int i=1; 6 <= 10; i ++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000 + i);
			item.setItemDetail("테스트 상품 상세 설명" + i);
			item.setItemSellStatus(ItemSellStatus.SOLD_OUT);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now());
//			item.setUpdateTime(LocalDateTime.now());
			
			Item savedItem = itemRepository.save(item);//데이터 insert
		}
	}
	
//	@Test
//	@DisplayName("상품 조회 테스트") //구분하기위한 이름
//	public void findByItemNmTest() {
//		this.createItemTest(); // item 테이블에 insert
//		List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("상품명, 상품상세설명 or 테스트")
//	public void findByItemNmOrItemDetailTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1", "테스트 상품 상세 설명5");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("가격 LessThan 테스트") 
//	public void findByPriceLessThanTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceLessThan(10005);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("가격 내림차순 조회 테스트") 
//	public void findByPriceLessThanOrderByPriceDescTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
	
	
	
	/////////////////////////////////////////////
	
	
	
	
//	@Test
//	@DisplayName("상품명 and sell") 
//	public void findByItemNmAndItemSellStatusTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmAndItemSellStatus("테스트 상품1", ItemSellStatus.SELL);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("가격 between") 
//	public void findByPriceBetweenTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPriceBetween(10004, 10008);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("날짜 ~이상") 
//	public void findByRegTimeAfterTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByRegTimeAfter(LocalDateTime.of(2023, 1, 1, 12, 12, 44));
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("itemSellStatus null") 
//	public void findByItemSellStatusNotNullTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemSellStatusNotNull();
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("상품상세설명1 like") 
//	public void findByItemDetailLikeTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemDetailLike("%설명1");
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
////	
////	@Test
////	@DisplayName("@Query를 이용한 상품 조회 테스트")
////	public void findByItemDetailTest() {
////		this.createItemTest();
////		List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세 설명");
////		for(Item item : itemList) {
////			System.out.println(item.toString());
////		}
////	}
////	
////	@Test
////	@DisplayName("@Query를 이용한 상품 조회 테스트")
////	public void findByItemDetailByNativeTest() {
////		this.createItemTest();
////		List<Item> itemList = itemRepository.findByItemDetailByNative("테스트 상품 상세 설명");
////		for(Item item : itemList) {
////			System.out.println(item.toString());
////		}
////	}
////	
//	
//	@Test
//	@DisplayName("@Query 금액 조회")
//	public void findByPriceTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByPrice(10005);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
//	
//	@Test
//	@DisplayName("@Query 상품명 및 판매상태 조회")
//	public void findByItemNmAndItemSellStatusTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItemNmAndItemSellStatus("테스트 상품1" , ItemSellStatus.SELL);
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	
//	@Test
//	@DisplayName("@nativeQuery 상품명 및 판매상태 조회")
//	public void findByItemNmAndItemSellStatusByNativeTest() {
//		this.createItemTest();
//		List<Item> itemList = itemRepository.findByItem("테스트 상품1" , ItemSellStatus.SELL);//ItemSellStatus.SELL
//		for(Item item : itemList) {
//			System.out.println(item.toString());
//		}
//	}
	@Test
	@DisplayName("querydsl 조회 테스트")
	public void queryDslTest() {
		this.createItemTest();
		JPAQueryFactory qf = new JPAQueryFactory(em); //쿼리를 동적으로 생성하기 위한 객체
		QItem qItem = QItem.item;
		
		//select * from item where itemSellStateus = 'SELL' and itemDetail like %테스트 상품 상세 설명% order by pricc desc
		JPAQuery<Item> query = qf.selectFrom(qItem).where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
				.where(qItem.itemDetail.like("%테스트 상품 상세 설명%"))
				.orderBy(qItem.price.desc());
		
		List<Item> itemList = query.fetch();
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
	@Test
	@DisplayName("querydsl 조회 테스트2")
	public void queryDslTest2() {
		this.createItemTest2();
		JPAQueryFactory qf = new JPAQueryFactory(em); //쿼리를 동적으로 생성하기 위한 객체
		QItem qItem = QItem.item;
		
		Pageable page = PageRequest.of(1, 5); //of (조회할 페이지의 번호, 한페이지당 조회할 데이터의갯수)
		
		JPAQuery<Item> query = qf.selectFrom(qItem)
//								.where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
//								.where(qItem.itemDetail.like("%테스트 상품 상세 설명%"))
//								.orderBy(qItem.price.desc());
								.offset(page.getOffset())
								.limit(page.getPageSize());
		
		List<Item> itemList = query.fetch();
		
		for(Item item : itemList) {
			System.out.println(item.toString());
		}
	}
	
}
