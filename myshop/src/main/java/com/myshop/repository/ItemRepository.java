package com.myshop.repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.myshop.constant.ItemSellStatus;
import com.myshop.entity.Item;

//JpaRepository : 기본적인 CRUD 및 페이징 처리를 위한 메소드가 정의가 되어있다.
//JpaRepository<사용할 엔티티 테이블, 기본키 타입>
public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item>, ItemRepositoryCustom {
	//select * from item where item_nm = ?
//	List<Item> findByItemNm(String itemNm);
//	
//	//select * from item where item_nm = ? or item_detail = ?
//	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
//
//	//select * from item where price < ? 
//	List<Item> findByPriceLessThan(Integer price);
//	
//	//select * from item where price < ?  order by price desc
//	List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);
//	
	////////////////////////
	//퀴즈
//	List<Item> findByItemNmAndItemSellStatus(String itemNm, ItemSellStatus itemSellStatus);
//	List<Item> findByPriceBetween(Integer price, Integer price1);
//	List<Item> findByRegTimeAfter(LocalDateTime regDate);
//	List<Item> findByItemSellStatusNotNull();
//	List<Item> findByItemDetailLike(String itemNm);
	
//	@Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
//	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
//	
//	@Query("select i from Item i where i.itemDetail like %?1% order by i.price desc")
//	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
//	
//	@Query(value="select * from item i where i.item_detail like %:itemDetail% order by i.price desc ", nativeQuery = true)
//	List<Item> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
//	
//	@Query("select * from Item i where i.price >= :price")
//	List<Item> findByPrice(@Param("price") int price);
////	
//	@Query("select i from Item i where i.itemNm = ?1 and i.itemSellStatus= ?2")
//	List<Item> findByItemNmAndItemSellStatus(@Param("itemNm") String itemNm ,  @Param("itemSellStatus") ItemSellStatus itemSellStatus);
//	
//	@Query(value="select * from item i where i.item_nm = (:itemNm) and i.item_sell_status= (:itemSellStatus)", nativeQuery = true)
//	List<Item> findByItem(@Param("itemNm") String itemNm ,  @Param("itemSellStatus") ItemSellStatus itemSellStatus);//ItemSellStatus itemSellStatus
}

