package com.myshop.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.dto.ItemSearchDto;
import com.myshop.dto.MainItemDto;
import com.myshop.service.ItemService;

import lombok.RequiredArgsConstructor;

//@RestController  //json 데이타 출력
@Controller
@RequiredArgsConstructor
public class MainController {
	private final ItemService itemService;
	
	@GetMapping(value="/")
//	public Page<MainItemDto> main(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {
	public String main(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {
		Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
		Page<MainItemDto> items = itemService.getMainItemPage(itemSearchDto, pageable);
		
		model.addAttribute("items", items);
		model.addAttribute("itemSearchDto", itemSearchDto);
		model.addAttribute("maxPage", 5);
		
//		return items;
		return "main";
	}
}
