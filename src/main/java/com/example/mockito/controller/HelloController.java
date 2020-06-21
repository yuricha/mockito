package com.example.mockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mockito.business.ItemBusinessService;
import com.example.mockito.model.Item;

@RestController
public class HelloController {
	@Autowired
	private ItemBusinessService businessService;
	
	@GetMapping("/hello-mockito")
	public String getController() {
		return "Hello mockito";
	}
	
	@GetMapping("/dummy-item")
	public Item getControllerDummy() {
		return new Item(1,"Ball", 10.0,100);
	}
	
	@GetMapping("/dummy-item-business")
	public Item getControllerDummyService() {
		return  businessService.getHardCodeItem();// new Item(1,"Ball", 10.0,100);
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> getControllerItemsListService() {
		return  businessService.retrieveAllItems();// repo
	}
}
